/*Expresion*/
package practica1comp2.backend.expresiones;
import java.util.ArrayList;
import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Categoria;
import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.analizadores.simbolos.Token;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.EtiqCondicion;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;
import practica1comp2.backend.instrucciones.Instruccion;
import practica1comp2.backend.instrucciones.InstruccionLlamarSub;
import practica1comp2.backend.instrucciones.InstruccionSub;

/**
 *
 * @author bryan
 */
public class Expresion extends Instruccion implements GenerarCuarteto{
    
    private Operador op;
    private String lugarTemp;
    private Expresion oper1;
    private Expresion oper2;
    private List<Cuarteto> list;
    private EtiqCondicion etiq1;
    private EtiqCondicion etiq2;
    private boolean isBoolean;
    private boolean isPosArray;
    private Id idArray;
    private Id ident;
    private Tipo tipo;
    private boolean isFuncion;
    private boolean isIdent;
    private boolean isExpresion;
    private boolean isSimple;
    
    private Instruccion call;
    private List<Expresion> listaParamEnviar;
    private boolean setNombre;
    
     private List<Expresion> dimensionesArray;

    public Expresion(String lugarTemp, Tipo tipo, GeneradorCod generador) {
        super(generador);
        this.lugarTemp = lugarTemp;
        this.tipo = tipo;
        this.isSimple = true;
        this.isIdent = false;
        this.isExpresion = false;
        this.isFuncion = false;
        
        this.listaParamEnviar = new ArrayList();
    }
    
    //constructor para una expresion que es una llamada de funcion
    
    public Expresion(String lugarTemp, List<Cuarteto> list, Tipo tipo, Instruccion call, GeneradorCod generador) {
        super(generador);
        this.lugarTemp = lugarTemp;
        this.list = list;
        this.tipo = tipo;
        this.call = call;
        
        this.isBoolean = false;
        this.isPosArray = false;
        this.idArray = new Id(null, false, null);
        
        this.isSimple = false;
        this.isIdent = false;
        this.isExpresion = false;
        this.isFuncion = true;
        //this.evaluarCall();
        
        this.listaParamEnviar = new ArrayList();
    }   
    
    //constructor simple para identidicador
    public Expresion(String lugarTemp, Id ident, GeneradorCod generador) {
        super(generador);
        this.lugarTemp = lugarTemp;
        this.ident = ident;
        this.idArray = new Id(null, false, null);
        this.tipo = new Tipo(null,null,null,null,Categoria.VAR,0,null,0,0,null,null);
        
        this.isSimple = false;
        this.isIdent = true;
        this.isExpresion = false;
        this.isFuncion = false;
        
        this.listaParamEnviar = new ArrayList();
        this.setNombre = false;
    }
    
    //tipo para poder comparar

    public Expresion(Operador op, String lugarTemp, Expresion oper1, Expresion oper2, List<Cuarteto> list, EtiqCondicion etiqCon1, EtiqCondicion etiqCon2, Tipo tipo, GeneradorCod generador) {
        super(generador);
        this.op = op;
        this.lugarTemp = lugarTemp;
        this.oper1 = oper1;
        this.oper2 = oper2;
        this.list = list;
        this.etiq1 = etiqCon1;
        this.etiq2 = etiqCon2;
        this.tipo = tipo;
        this.isBoolean = false;
        this.isPosArray = false;
        this.idArray = new Id(null, false, null);
        
        this.isSimple = false;
        this.isIdent = false;
        this.isExpresion = true;
        this.isFuncion = false;
        
        //this.evaluar();
        
        this.listaParamEnviar = new ArrayList();
    }
    
    //constructor de epxresion para arrays de n dimensiones

    public Expresion(String lugarTemp, boolean isPosArray, Id idArray, List<Expresion> dimensionesArray, GeneradorCod generador) {
        super(generador);
        this.lugarTemp = lugarTemp;
        this.isPosArray = isPosArray;
        this.idArray = idArray;
        this.dimensionesArray = dimensionesArray;
    }
    
    
    
    public void addParamEnviar(Expresion ex){
        this.listaParamEnviar.add(ex);
    }
    
    public Tipo comprobarTipoOpAr(TablaSimbolos sym){
        Tipo tipo = null;
        switch (op) {
            case MAS:
                tipo = sym.getComprob().evalOpMasConcat(oper1,oper2);
                break;
            case MENOS:
                tipo = sym.getComprob().evalOpAritmetica(oper1,oper2);
                break;
            case POR:
                tipo = sym.getComprob().evalOpAritmetica(oper1,oper2);
                break;
            case DIV:
                tipo = sym.getComprob().evalOpAritmetica(oper1,oper2);
                break;
            case MOD:
                tipo = sym.getComprob().evalOpAritmetica(oper1,oper2);
                break;
            default:
                tipo = this.getTipo();
        }
        
        return tipo;
    }
    
    /*Metodos para expresiones Globales*/
    public void evaluarExpresiones(TablaSimbolos sym, TipoVar ambito, InstruccionSub sub){
        if (this.isExpresion) {
            if (oper1!= null && oper2!=null) {
                evaluarOper(this, oper1, sym, ambito, sub); 
                evaluarOper(this, oper2, sym, ambito, sub);
                /*comprobar tipos*/
                this.setTipo(this.comprobarTipoOpAr(sym));
                this.evaluar();
            }else if (oper1!=null && oper2==null) {
                evaluarOper(this, oper1, sym, ambito, sub); 
                this.evaluar();
            } else if (oper1==null && oper2!=null) {
                evaluarOper(this, oper2, sym, ambito, sub); 
                this.evaluar();
            } else {
                
                this.evaluar();
            }
            
        } else if (this.isIdent) {
            Token nameVar;
            if (this.getIdArray().getId()!=null) {
            	nameVar = this.getIdArray().getId();
            } else {
            	nameVar = this.getIdent().getId();
            }
            if (ambito==TipoVar.GLOBAL) {
                if (sym.consultarVar(nameVar, null)) {
                    //asignando su tipo
                    this.setTipo(sym.getTipo(nameVar));
                }
            } else {
                 if (sym.consultarVarLocal(nameVar, sub.getProcessName().getLexeme())) {
                    //asignando su tipo
                    this.setTipo(sym.getTipoLocal(nameVar, sub.getProcessName().getLexeme()));
                    //seteando su nombre si no se a hecho
                    
                     if (!this.isSetNombre()) {
                         //sym.setVarLocal(nameVar, sub.getProcessName().getLexeme()); /*esto hasta despues*/
                         String name = nameVar.getLexeme()+sub.getProcessName().getLexeme();
                         this.setLugarTemp(name);
                         if (this.getIdArray().getId()!=null) {
                            this.setIdArray(new Id(new Token(name, nameVar.getLine(), nameVar.getColumn()), this.getIdArray().isIsAsig(), this.getIdArray().getAsig(), this.getIdArray().getEx()));
                        } else {
                            this.setIdent(new Id(new Token(name, nameVar.getLine(), nameVar.getColumn()), this.getIdArray().isIsAsig(), this.getIdArray().getAsig(), this.getIdArray().getEx()));
                        }
                         
                        this.setSetNombre(true);
                         
                     }
                }
            }
            
            
        } else if (this.isSimple){
        
        } else if (this.isFuncion) {
//            if (sub!=null) { /*mejor setear la tabla de simbolos con una lista temporal de instrucciones sub para consult*/
//                /*esta dentro de una sub*/
//                this.evaluarCall(sym, sub);
//            } else {
//                /*esta en el main o en alguna declaracion*/
//            }
                /*setear tipo de expresion funcion*/
                InstruccionLlamarSub subt = (InstruccionLlamarSub)this.call;
                this.setTipo(sym.buscarSubprogramaNoDeclarado(subt.getIdsub(), sym.getListaConsultaSubs()));
                this.evaluarCall(sym, ambito, sub);
            
            
        }
        
    }
    
    public void evaluarOper(Expresion ex, Expresion oper, TablaSimbolos sym, TipoVar ambito, InstruccionSub sub){
        if (oper.isIsExpresion()) {
            oper.evaluarExpresiones(sym, ambito,sub);
        } else if (oper.isIsIdent()) {
            //revisar en tabla simbolos si existe la variable
            Token nameVar;
            if (oper.getIdArray().getId()!=null) {
            	nameVar = oper.getIdArray().getId();
            } else {
            	nameVar = oper.getIdent().getId();
            }
            if (ambito==TipoVar.GLOBAL) {
                if (sym.consultarVar(nameVar, null)) {
                    //asignando su tipo
                    oper.setTipo(sym.getTipo(nameVar));
                }
            } else {
                 if (sym.consultarVarLocal(nameVar, sub.getProcessName().getLexeme())) {
                    //asignando su tipo
                    oper.setTipo(sym.getTipoLocal(nameVar, sub.getProcessName().getLexeme()));
                    //seteando su nombre si no se a hecho
                     if (!oper.isSetNombre()) {
                         //sym.setVarLocal(nameVar, sub.getProcessName().getLexeme()); /*Esto hasta despues*/
                         String name = nameVar.getLexeme()+sub.getProcessName().getLexeme();
                         oper.setLugarTemp(name);
                         if (oper.getIdArray().getId()!=null) {
                            oper.setIdArray(new Id(new Token(name, nameVar.getLine(), nameVar.getColumn()), oper.getIdArray().isIsAsig(), oper.getIdArray().getAsig(), oper.getIdArray().getEx()));
                            
                            System.out.println("*************-------------------- "+oper.getIdArray().getId().getLexeme());
                         } else {
                            oper.setIdent(new Id(new Token(name, nameVar.getLine(), nameVar.getColumn()), oper.getIdArray().isIsAsig(), oper.getIdArray().getAsig(), oper.getIdArray().getEx()));
                            System.out.println("*************-------------------- "+oper.getIdent().getId().getLexeme());
                         }
                        oper.setSetNombre(true);
                     }
                    
                }
            }
            //oper.evaluarExpresiones(sym);
            
        } else if (oper.isIsFuncion()) {
            //revisar en tabla simbolos si existe la funcion
            //oper.evaluarCall(sym, ambito, sub);
            //oper.evaluarExpresiones(sym);
            
            /*setear tipo de expresion funcion*/
                InstruccionLlamarSub subt = (InstruccionLlamarSub)oper.getCall();
                oper.setTipo(sym.buscarSubprogramaNoDeclarado(subt.getIdsub(), sym.getListaConsultaSubs()));
                oper.evaluarCall(sym, ambito, sub);
            
        } else if (oper.isIsSimple()) {
            //oper.evaluarExpresiones(sym);
            
        }
    
    }
    
    public void cambiarEtiq(EtiqCondicion et){
        etiq1.setV(et.f());
        etiq1.setF(et.v());
    }
    
    public void generarDobleCuarteto(Operador op, String et1, String et2){
        this.isBoolean = true;
        generarCuarteto(op, new Expresion(et1, tipo, this.getGenerador()),new Expresion( oper1.getLugarTemp(), tipo, this.getGenerador()), new Expresion(oper2.getLugarTemp(), tipo, this.getGenerador()));
        generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(et2, tipo, this.getGenerador()), null, null);
    
    }
    public void generarTripleCuarteto(String et1, String et2){
        generarCuarteto(this.getGenerador().getOp().ETIQ, new Expresion(et1, tipo, this.getGenerador()), null, null);
        generarCuarteto(this.getGenerador().getOp().ETIQ, new Expresion(et2, tipo, this.getGenerador()), null, null);
        generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(et2, tipo, this.getGenerador()), null, null);
    }
    @Override
    public void evaluar() {
       
        //alguna evalucion semantica
        if (op!=null) {
            switch (op) {
                case MENOR: 
                    generarDobleCuarteto(this.getGenerador().getOp().IF_MENOR,etiq1.v(),etiq1.f());
                    break;
                case MENOR_I: 
                    generarDobleCuarteto(this.getGenerador().getOp().IF_MEN_IGUAL,etiq1.v(),etiq1.f());
                    break;
                case MAYOR: 
                    generarDobleCuarteto(this.getGenerador().getOp().IF_MAYOR,etiq1.v(),etiq1.f());
                    break;
                case MAYOR_I: 
                    generarDobleCuarteto(this.getGenerador().getOp().IF_MAY_IGUAL,etiq1.v(),etiq1.f());
                    break;
                case IGUAL: 
                    generarDobleCuarteto(this.getGenerador().getOp().IF_IGUAL,etiq1.v(),etiq1.f());
                    break;
                case DISTINTO: 
                    generarDobleCuarteto(this.getGenerador().getOp().IF_NOIGUAL,etiq1.f(),etiq1.v());
                    break;
                case NOT: {
                    if (oper1.getList()!=null) {
                       list = this.getGenerador().unirQuad(oper1.getList(), null); 
                       this.iniciarEtiq1(oper1.getEtiq1().v(),oper1.getEtiq1().f());
                       this.isBoolean = true;
                    } else{
                        list = this.getGenerador().unirQuad(null, null); 
                        this.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, new Expresion(etiq1.v(), tipo, this.getGenerador()), new Expresion(oper1.getLugarTemp(), tipo, this.getGenerador()),  new Expresion("1", tipo, this.getGenerador()));
                        generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(etiq1.f(), tipo, this.getGenerador()), null, null);
                        this.isBoolean = true;
                        
                    }
                    this.cambiarEtiq(new EtiqCondicion(etiq1.v(),etiq1.f()));
                    //this.etiq1.setV(etiq1.v());  VPOSIBLE ERROR   
                    }
                    
                    break;
                case MINUS: 
                    //cambiarEtiq(new EtiqCondicion(etiq1.v(), etiq1.f()));
                    break;
                case AND: {
                    
                    if (oper1.getList()!=null) {
                       list = this.getGenerador().unirQuad(oper1.getList(), null); 
                       generarCuarteto(this.getGenerador().getOp().ETIQ,new Expresion( etiq1.v(), tipo, this.getGenerador()), null, null);
                    } else {
                        list = this.getGenerador().unirQuad(oper1.getList(), null);
                        
                        if (oper2.getEtiq1()!=null) {
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f());
                            //setear las del oper dos poruq evan despues
                            oper2.getEtiq1().setV(this.getGenerador().getNuevaEtiq());
                            oper2.getEtiq1().setF(this.getGenerador().getNuevaEtiq());
                            //iniciando etiquetas de oper 1
                            oper1.iniciarEtiq1(etiq1.v(), etiq1.f());
                            oper2.getList().get(oper2.getList().size()-2).setResult(new Expresion(oper2.getEtiq1().v(), null, tipo, null, this.getGenerador()));
                        } else {
                            oper2.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f());
                        }                      
                        //generando cuartetos AND
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, new Expresion(etiq1.v(), tipo, this.getGenerador()), new Expresion(oper1.getLugarTemp(), tipo, this.getGenerador()), new Expresion("1", tipo, this.getGenerador()));
                        generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(etiq1.f(), tipo, this.getGenerador()), null, null);
                        generarCuarteto(this.getGenerador().getOp().ETIQ, new Expresion(etiq1.v(), tipo, this.getGenerador()), null, null);
                        
                    }

                    if (oper2.getList()!=null) {
                        //setear resultado de ultimo cuarteto para que retorne a una etiqueta anterior
                        oper2.getList().get(oper2.getList().size()-1).setResult(new Expresion(oper1.getEtiq1().f(), null, tipo, null, this.getGenerador()));
                        list = this.getGenerador().unirQuad(this.list, oper2.getList());
                        //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);
                        this.isBoolean = true;
                    } else {
                        etiq2 = new EtiqCondicion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, new Expresion(etiq2.v(), tipo, this.getGenerador()), new Expresion(oper2.getLugarTemp(), tipo, this.getGenerador()), new Expresion("1", tipo, this.getGenerador()));
                        generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(etiq1.f(), tipo, this.getGenerador()), null, null);
                        //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);
                        this.isBoolean = true;
                    }
                        this.etiq1.setV(etiq2.v());

                }
                    break;
                case OR: {
                    if (oper1.getList()!=null) {
                       list = this.getGenerador().unirQuad(oper1.getList(), null); 
                       generarCuarteto(this.getGenerador().getOp().ETIQ, new Expresion(etiq1.f(), tipo, this.getGenerador()), null, null); //**  rev AND
                    } else {
                        list = this.getGenerador().unirQuad(oper1.getList(), null);
                        
                        if (oper2.getEtiq1()!=null) {
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f()); //*
                            //setear las del oper dos poruq evan despues
                            oper2.getEtiq1().setV(this.getGenerador().getNuevaEtiq());  
                            oper2.getEtiq1().setF(this.getGenerador().getNuevaEtiq());
                            //iniciando etiquetas de oper 1
                            oper1.iniciarEtiq1(etiq1.v(), etiq1.f());//**
                            oper2.getList().get(oper2.getList().size()-2).setResult(new Expresion(oper1.getEtiq1().v(), null, tipo, null, this.getGenerador()));
                        } else {
                            oper2.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f()); //**
                        } 
                        
                        //generando cuartetos OR
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, new Expresion(etiq1.v(), tipo, this.getGenerador()), new Expresion(oper1.getLugarTemp(), tipo, this.getGenerador()), new Expresion("1", tipo, this.getGenerador()));
                        generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(etiq1.f(), tipo, this.getGenerador()), null, null);
                        generarCuarteto(this.getGenerador().getOp().ETIQ, new Expresion(etiq1.f(), tipo, this.getGenerador()), null, null);//**
                        
                    }
                    
                    
                    
                    if (oper2.getList()!=null) {
                        //setear resultado de ultimo cuarteto para que retorne a una etiqueta anterior
                        oper2.getList().get(oper2.getList().size()-2).setResult(new Expresion(oper1.getEtiq1().v(), null, tipo, null, this.getGenerador())); //**  rev AND
                        oper2.getList().get(oper2.getList().size()-1).setResult(new Expresion(oper2.getEtiq1().v(), null, tipo, null, this.getGenerador()));
                        list = this.getGenerador().unirQuad(this.list, oper2.getList());
                        //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);
                        this.isBoolean = true;
                    } else {
                        etiq2 = new EtiqCondicion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, new Expresion(etiq1.v(), tipo, this.getGenerador()), new Expresion(oper2.getLugarTemp(), tipo, this.getGenerador()), new Expresion("1", tipo, this.getGenerador()));//*  rev AND
                        generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(etiq2.v(), tipo, this.getGenerador()), null, null);//*  rev AND
                        //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);
                        this.isBoolean = true;
                    }
                    this.etiq1.setV(etiq1.v());
                    this.etiq1.setF(etiq2.v());   
                        
                }
                    break;
                case TRUE: 
                    //
                    break;
                case FALSE: 
                    //
                    break;
                    
                default:
                    //une los cuartetos que provienen de las experesiones y el nuevo YA QUE CUANDO VAN SUBIENDO SOLO SE GUARDAN PARA DESPUES EVALUAR
                    list = this.getGenerador().unirQuad(oper1.getList(), oper2.getList());
                    this.getGenerador().agregarTemporal(new Token(lugarTemp, 0, 0), tipo); //agregando a la tabla de simbolos el temporal
                    generarCuarteto(op, new Expresion(this.lugarTemp, this.tipo, this.getGenerador()), this.oper1,this.oper2);
            }
            
            
        }
        
    }
    
    public void evaluarCall(TablaSimbolos sym, TipoVar ambito, InstruccionSub sub){
        /*verificar existencia del sub, ya declarado o ahun no pero en proceso de serlo*/
        if (call!=null) {
            InstruccionLlamarSub cal = (InstruccionLlamarSub)this.call;
            if (cal.getLisParam()!=null) {
               /*evaluar expresiones de parametros antes de consultar existencia porque alli se usan */
                    for(Expresion ex: cal.getLisParam()){
                        ex.evaluarExpresiones(sym, ambito, sub);
                    } 
            }
            if (sym.consultarExistenciaSub(cal.getIdsub(), cal.getLisParam(), sym.getListaConsultaSubs())) {
                //String temp = this.getGenerador().getLugarTemp(); //guardando temporal
                this.getGenerador().agregarTemporal(new Token(lugarTemp, 0, 0), tipo);
                /*esta expresion tiene el nombre de la funcion en la llamada y los parametros que se envian se agregar abajo*/
                Expresion exprEspecial =  new Expresion(cal.getIdsub().getLexeme(), tipo, this.getGenerador());
                if (cal.getLisParam()!=null) {
                    /*declarar parametros*/
                    for(Expresion ex: cal.getLisParam()){
                        generarCuarteto(this.getGenerador().getOp().PARAM, ex, null, null);
                        /*agregando para la llamada*/
                        exprEspecial.addParamEnviar(ex);
                    }
                    generarCuarteto(this.getGenerador().getOp().CALL, new Expresion(lugarTemp, tipo, this.getGenerador()), exprEspecial, new Expresion(""+cal.getLisParam().size(), tipo, this.getGenerador()));
                } else {
                    generarCuarteto(this.getGenerador().getOp().CALL, new Expresion(lugarTemp, tipo, this.getGenerador()), exprEspecial,  new Expresion("0", tipo, this.getGenerador()));
                }    
            }
            
        }
        
       
    
    }
    
     @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        list.add(new Cuarteto(op, result, arg1, arg2));
    }
    
    
    public void iniciarEtiq1(String arg1, String arg2){
        etiq1 = new EtiqCondicion(arg1, arg2);
    }
    public void iniciarEtiq2(String arg1, String arg2){
        etiq2 = new EtiqCondicion(arg1, arg2);
    }

    public Operador getOp() {
        return op;
    }

    public void setOp(Operador op) {
        this.op = op;
    }

    public String getLugarTemp() {
        return lugarTemp;
    }

    public void setLugarTemp(String lugarTemp) {
        this.lugarTemp = lugarTemp;
    }

    public Expresion getOper1() {
        return oper1;
    }

    public void setOper1(Expresion oper1) {
        this.oper1 = oper1;
    }

    public Expresion getOper2() {
        return oper2;
    }

    public void setOper2(Expresion oper2) {
        this.oper2 = oper2;
    }

    public List<Cuarteto> getList() {
        return list;
    }

    public void setList(List<Cuarteto> list) {
        this.list = list;
    }

    public EtiqCondicion getEtiq1() {
        return etiq1;
    }

    public void setEtiq1(EtiqCondicion etiq1) {
        this.etiq1 = etiq1;
    }

    public EtiqCondicion getEtiq2() {
        return etiq2;
    }

    public void setEtiq2(EtiqCondicion etiq2) {
        this.etiq2 = etiq2;
    }

    public boolean isIsBoolean() {
        return isBoolean;
    }

    public void setIsBoolean(boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public boolean isIsPosArray() {
        return isPosArray;
    }

    public void setIsPosArray(boolean isPosArray) {
        this.isPosArray = isPosArray;
    }

    public Id getIdArray() {
        return idArray;
    }

    public void setIdArray(Id idArray) {
        this.idArray = idArray;
    }

    public Id getIdent() {
        return ident;
    }

    public void setIdent(Id ident) {
        this.ident = ident;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isIsFuncion() {
        return isFuncion;
    }

    public void setIsFuncion(boolean isFuncion) {
        this.isFuncion = isFuncion;
    }

    public boolean isIsIdent() {
        return isIdent;
    }

    public void setIsIdent(boolean isIdent) {
        this.isIdent = isIdent;
    }

    public boolean isIsExpresion() {
        return isExpresion;
    }

    public void setIsExpresion(boolean isExpresion) {
        this.isExpresion = isExpresion;
    }

    public boolean isIsSimple() {
        return isSimple;
    }

    public void setIsSimple(boolean isSimple) {
        this.isSimple = isSimple;
    }

    public Instruccion getCall() {
        return call;
    }

    public void setCall(Instruccion call) {
        this.call = call;
    }

    public List<Expresion> getListaParamEnviar() {
        return listaParamEnviar;
    }

    public void setListaParamEnviar(List<Expresion> listaParamEnviar) {
        this.listaParamEnviar = listaParamEnviar;
    }

    public boolean isSetNombre() {
        return setNombre;
    }

    public void setSetNombre(boolean setNombre) {
        this.setNombre = setNombre;
    }
        
    
}
