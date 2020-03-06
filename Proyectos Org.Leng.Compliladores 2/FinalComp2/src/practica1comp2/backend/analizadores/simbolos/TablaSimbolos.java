package practica1comp2.backend.analizadores.simbolos;

import java.math.BigInteger;
import practica1comp2.backend.analizadores.simbolos.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import practica1comp2.backend.expresiones.ComprobadorTipos;
import practica1comp2.backend.expresiones.EvaluarExpresion;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.instrucciones.Instruccion;
import practica1comp2.backend.instrucciones.InstruccionArray;
import practica1comp2.backend.instrucciones.InstruccionAsig;
import practica1comp2.backend.instrucciones.InstruccionDeclaracion;
import practica1comp2.backend.instrucciones.InstruccionMain;
import practica1comp2.backend.instrucciones.InstruccionPrint;
import practica1comp2.backend.instrucciones.InstruccionRetorno;
import practica1comp2.backend.instrucciones.InstruccionSub;
import practica1comp2.backend.instrucciones.TipoDim;

/**
 *
 * @author jose
 */
public class TablaSimbolos {

    //private Map<String, Tipo> symTip;//para almacenra los tipos de las variables
    private List<Simbolo> sym; //este es el remplazo al map porque es posible tener vars repetidas en la misama tab
    private List<String> errorsList;
    private ComprobadorTipos comprob;
    private int contador;
    private List<Instruccion> listaConsultaSubs;
    
    

    public TablaSimbolos(List<String> errorsList) {
        this.errorsList = errorsList;
        //this.symTip = new HashMap<>();
        this.sym = new ArrayList(); /*pasar todo de symTip a sym esto involucra hacer busquedas */
        this.comprob = new ComprobadorTipos(this.errorsList,this.sym);
        this.contador = 0;
        this.listaConsultaSubs = null; //se setea a al momento de evaluar el programa completo para consultar los subs
        this.iniciarTiposBases();
    }
    
    public int getNewSimbol(){
        return contador++;
    }

    /*@METODOS GLOBALES*/
        
    /*Metodo de busqueda Global para variables*/
    public Simbolo buscarSimboloGlobal(String name){
        for(Simbolo sim: this.sym){
            if (sim.getNombre().equals(name) && sim.getTipo().getAmbito()==0) {
                return sim;
            }
        }
        return null;
        
    }
    /*Metodo de busqueda Global para subprogramas*/
    public Simbolo buscarSubprogramaGlobal(String name){
        for(Simbolo sim: this.sym){
            if (sim.getNombre().equals(name) && sim.getTipo().getCategoria()==Categoria.SUBPROGRAMA) {
                return sim;
            }
        }
        return null;
        
    }
    
    public boolean verificarProgComplet(List<Instruccion> declaraciones, List<Instruccion> subs, InstruccionMain mains){
        if (declaraciones!=null && subs!=null) {
            this.setListaConsultaSubs(subs);
            return addVariables(declaraciones) && verificarSubs(this.getListaConsultaSubs()) && verificarMain(mains);
        } else if (declaraciones==null && subs!=null) {
            this.setListaConsultaSubs(subs);
            return verificarSubs(this.getListaConsultaSubs()) && verificarMain(mains);
        } else if (declaraciones!=null && subs==null) {
            return addVariables(declaraciones) && verificarMain(mains);
        } else {
            return verificarMain(mains); //solo hay main
        }
    
    }
    public boolean verificarMain(InstruccionMain mains){
        /*evaluando cada instruccion del main*/
        return verificarTipoInstruc(mains.getInstrucciones());
    
    }
    /*verifica toda instruccion dentro del main y hace todo de forma global*/
    public boolean verificarTipoInstruc(List<Instruccion> list){
        boolean retorno = true;
        for(Instruccion in: list){
            /*verificar cada una de las instrucciones posibles sus expresiones y tipos donde se utilicen*/
            if (in instanceof InstruccionDeclaracion) {
                retorno = verificarDeclaracion(in);
            } else if (in instanceof InstruccionArray){
                retorno = verificarArreglo(in);
            } else if (in instanceof InstruccionAsig){
                retorno = verificarAsignacion(in);
            } else if (in instanceof EvaluarExpresion) {
                ((EvaluarExpresion) in).evaluarExpresiones(TipoVar.GLOBAL, this, null);
            }
            
        }
        return retorno;
    }
    
    /*verificar variables que se intentan declarar de forma Global*/
    public boolean addVariables(List<Instruccion> list){
        boolean retorno = true;
        for(Instruccion in: list){
            if (in instanceof InstruccionDeclaracion) {
                retorno = verificarDeclaracion(in);
            } else if (in instanceof InstruccionArray){
                retorno = verificarArreglo(in);
            } else if (in instanceof InstruccionAsig){
                retorno = verificarAsignacion(in);
            }
            
        }
        return retorno;
    }
    
    /*verificar declaracion global de variable*/
    public boolean verificarDeclaracion(Instruccion in){
        boolean retorno = true;
        //InstruccionDeclaracion declaracion = (InstruccionDeclaracion)in;
        List<Id> vars = ((InstruccionDeclaracion)in).getListVar();
        Tipo tipo = ((InstruccionDeclaracion)in).getTipo();
        /*evaluando cada variable*/
        for(Id id: vars){
            /*Y ASI HACER CON TODOS LOS METODOS QUE UTILIZAN SYMTYP*/
            if (buscarSimboloGlobal(id.getId().getLexeme())!=null) {
                errorsList.add(String.format("La variable GLOBAL '%s' que intenta declarar , linea %d columna %d ya fue declarada anteriormente.", id.getId().getLexeme(), id.getId().getLine(), id.getId().getColumn()));
                retorno = false;
            } else {
                /*evaluacion de expresiones si hay una asignacion*/
                if (id.isIsAsig()) {
                    id.getAsig().getExp().evaluarExpresiones(this, TipoVar.GLOBAL,null);
                    System.out.println("************************************"+((InstruccionDeclaracion)in).getTipo().getJerarqui()+" "+id.getAsig().getExp().getTipo().getJerarqui());
                    /*evaluar tipo a asignar*/
                    if (((InstruccionDeclaracion)in).getTipo().getJerarqui()<id.getAsig().getExp().getTipo().getJerarqui()) {
                        errorsList.add(String.format("A La variable '%s' , linea %d columna %d no se le puede asignar un valor Tipo %s.",
                            id.getId().getLexeme(), id.getId().getLine(), id.getId().getColumn(),id.getAsig().getExp().getTipo().getTipo().toString()));
                        retorno = false;
                    }
                }
                /*Y ASI HACER CON TODOS LOS METODOS QUE UTILIZAN SYMTYP*/
                sym.add(new Simbolo(getNewSimbol(), id.getId().getLexeme(),
                new Tipo(tipo.getTipo(),null,null,null,Categoria.VAR,0,null,0,tipo.getJerarqui(),null,id.getId())));
            }
        }
        
        return retorno;
    
    }
    /*verificar declaracion global de arreglo*/
    public boolean verificarArreglo(Instruccion in){
        boolean retorno = true;
        //InstruccionArray declaracion = (InstruccionArray)in;
        //List<Id> vars = ((InstruccionArray)in).getVars();
        TipoDim tipo = ((InstruccionArray)in).getTipoD();
        /*evaluando expresiones en las dimensiones*/
        for(Expresion e: tipo.getDims()){
            e.evaluarExpresiones(this, TipoVar.GLOBAL, null); //deberian evaluarse una lista de expresiones cuando se implemnte n dims
        }
        /*evaluando cada array a declarar*/
        for(Id id: ((InstruccionArray)in).getVars()){
            if (buscarSimboloGlobal(id.getId().getLexeme())!=null) {
                errorsList.add(String.format("El arreglo GLOBAL '%s' que intenta declarar , linea %d columna %d ya fue declarado anteriormente.", id.getId().getLexeme(), id.getId().getLine(), id.getId().getColumn()));
                retorno = false;
            } else {
                sym.add(new Simbolo(getNewSimbol(), id.getId().getLexeme(),
                new Tipo(tipo.getTipo().getTipo(),null,null,null,Categoria.VAR,0,null,0,tipo.getTipo().getJerarqui(),null,id.getId())));
            }
        }
        return retorno;
    
    }
    /*verificar asignacion global de variable*/
    public boolean verificarAsignacion(Instruccion in){
        
        boolean retorno = true;
        //InstruccionAsig temp = (InstruccionAsig)in;
        /*evaluacion de expresiones en la asignacion*/
        ((InstruccionAsig)in).getLoc().getEx().evaluarExpresiones(this, TipoVar.GLOBAL, null);
        ((InstruccionAsig)in).getExp().evaluarExpresiones(this, TipoVar.GLOBAL, null);
        
        if (((InstruccionAsig)in).getExp().isIsPosArray() || ((InstruccionAsig)in).getLoc().getEx().isIsPosArray()) {
                //para asignacion de pos de array son distintas validaciones
                if (!asignarArray(((InstruccionAsig)in).getLoc(), ((InstruccionAsig)in).getExp())) {
                        retorno = false;
                }
        } else {
                //para asignacion de variables
                /*consultar si la variable a asignar existe*/
                if (consultarVar(((InstruccionAsig)in).getLoc().getId(), ((InstruccionAsig)in).getExp())) {
                        if (!verificarTipoAsig(((InstruccionAsig)in).getLoc().getId(), ((InstruccionAsig)in).getExp())) {
                                //consultar si tipo de asignacion es correcta
                                retorno = false;
                        }
                } else {
                        retorno = false;
                }
        }
        
        return  retorno;
    
    }
    /*verificador de asignacion de tipo global*/
    public boolean verificarTipoAsig(Token id, Expresion ex){
        if (getTipo(id).getTipo()==ex.getTipo().getTipo()) {
            //si son tipos iguales
            return true;
        } else if (getTipo(id).getJerarqui()>=ex.getTipo().getJerarqui()) {
            //si el id es de jerarquia mayor
            return true;
        }
        errorsList.add(String.format("A La variable Global '%s' , linea %d columna %d no se le puede asignar un valor Tipo %s.",
                id.getLexeme(), id.getLine(), id.getColumn(),ex.getTipo().getTipo().toString()));
        return false;
    }
    
    /*consultar la existencia de una variable Global*/
    public boolean consultarVar(Token id, Expresion ex){
        if (buscarSimboloGlobal(id.getLexeme())!=null) {
            //symTip.put(id.getLexeme(), tipo); //actualiza su tipo
            return true;
        } 
        errorsList.add(String.format("La variable Global '%s' que intenta utilizar o asignar , linea %d columna %d no ha sido declarada.", id.getLexeme(), id.getLine(), id.getColumn()));
        return false;
    
    }
    //agregar una variable de forma global
    public boolean addSimbolo(Token id, Tipo tipo){
        if (buscarSimboloGlobal(id.getLexeme())!=null) {
            errorsList.add(String.format("La variable Global '%s' que intenta declarar , linea %d columna %d ya fue declarada anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            return false;
        } 
        sym.add(new Simbolo(getNewSimbol(), id.getLexeme(),tipo));
        return true;
    
    }
    
    //agregar nuevo Subprograma global
    public boolean addSubprograma(Token id, Tipo tipo){
        if (buscarSubprogramaGlobal(id.getLexeme())!=null) {
            errorsList.add(String.format("El nombre '%s' que intenta declarar como subprograma , linea %d columna %d ya fue declarado anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            return false;
        } 
        sym.add(new Simbolo(getNewSimbol(), id.getLexeme(), tipo));
        return true;
    
    }
    
    /*consulta existencia de subprograma global*/
    public boolean consultarExistenciaSub(Token id, List<Expresion> list, List<Instruccion> listPendiente){
        /*buscar si ya esta declarado*/
        if (buscarSubprogramaGlobal(id.getLexeme())==null) {
            /*buscar si ahun no se a declarado pero se va a declarar*/
            if (buscarSubprogramaNoDeclarado(id, listPendiente)==null) {
                errorsList.add(String.format("El subprograma '%s' que intenta llamar , linea %d columna %d no existe.", id.getLexeme(), id.getLine(), id.getColumn()));            
                return false;
            }
            
        } 
        
        return evaluarParametros(id, list);
    
    }
    /*busqueda de subprograma en lista sin declarar ahun ;ero que se va a realizar retorna su tipo*/
    public Tipo buscarSubprogramaNoDeclarado(Token id, List<Instruccion> listPendiente){
        //InstruccionSub sub;
        for(Instruccion in: listPendiente){
            //sub = (InstruccionSub)in;
            if (id.getLexeme().equals(((InstruccionSub)in).getProcessName().getLexeme())) {
                return ((InstruccionSub)in).getTipo();
            }
        }
        return null;
    
    }
    
    /*busqueda de subprograma en lista,  retorna el sub como tal*/
    public InstruccionSub getSubprogramaCargado(Token id, List<Instruccion> listPendiente){
        //InstruccionSub sub;
        for(Instruccion in: listPendiente){
            //sub = (InstruccionSub)in;
            if (id.getLexeme().equals(((InstruccionSub)in).getProcessName().getLexeme())) {
                return ((InstruccionSub)in);
            }
        }
        return null;
    
    }
    
    /*evaluacion de parametros a enviar en un subprograma que se esta llamando*/
    public boolean evaluarParametros(Token id, List<Expresion> list){
        //recuperar el tipo del sub y todos sus atributos
        Tipo tipo = this.buscarSubprogramaNoDeclarado(id, this.listaConsultaSubs);
        
        //comparar numero de parametros
        if (list!=null) {
            if (tipo.getNumParam()!=list.size()) {
                errorsList.add(String.format("*Numero de Parametros no Coincide* La llamada del subprograma '%s' , linea %d columna %d requiere '%d' parametros NO '%d'.",
                        id.getLexeme(), id.getLine(), id.getColumn(), tipo.getNumParam(),list.size()));
                return false;
            } else {
                boolean equiv = true;
                List<Tipo> tiposParam = tipo.getParametros();
                //comprobar tipos de parametros
                int contParam = 0;
                Tipo tipoE;
                for(Tipo tipoR: tiposParam){
                    tipoE = list.get(contParam).getTipo();
                    if (tipoR.getTipo()!=tipoE.getTipo()) {
                        if (tipoE.getJerarqui()>=2 && tipoE.getJerarqui()<=6) {
                            if ( tipoR.getJerarqui()>=2 && tipoR.getJerarqui()<=6) {
                                if (tipoE.getJerarqui()>tipoR.getJerarqui()) {
                                    errorsList.add(String.format("El Parametro No. '%d' '%s' tipo '%s' , que desea enviar linea %d columna %d no es compatible con el parametro '%d' de tipo '%s' del subprograma '%s'.",
                                    contParam+1, list.get(contParam).getLugarTemp(),tipoE.getTipo().toString(),
                                    id.getLine(),id.getColumn(),contParam+1,tipoR.getTipo(), id.getLexeme()));
                                    equiv = false;
                                }
                            } else {
                                errorsList.add(String.format("El Parametro No. '%d' '%s' tipo '%s' , que desea enviar linea %d columna %d no es compatible con el parametro '%d' de tipo '%s' del subprograma '%s'.",
                                    contParam+1, list.get(contParam).getLugarTemp(),tipoE.getTipo().toString(),
                                    id.getLine(),id.getColumn(),contParam+1,tipoR.getTipo(), id.getLexeme()));
                                    equiv = false;
                            }
                        } else {
                            errorsList.add(String.format("El Parametro No. '%d' '%s' tipo '%s' , que desea enviar linea %d columna %d no es compatible con el parametro '%d' de tipo '%s' del subprograma '%s'.",
                                    contParam+1, list.get(contParam).getLugarTemp(),tipoE.getTipo().toString(),
                                    id.getLine(),id.getColumn(),contParam+1,tipoR.getTipo(), id.getLexeme()));
                                    equiv = false;
                        }  
                    }
                    
                    contParam++;
                }
                
                return equiv;
            }
            
        } else {
            //si no se envia ningun parametro
            if (tipo.getNumParam()!=0) {
                errorsList.add(String.format("*Numero de Parametros no Coincide* La llamada del subprograma '%s' , linea %d columna %d requiere '%d' parametros y no se esta enviando ninguno.",
                        id.getLexeme(), id.getLine(), id.getColumn(), tipo.getNumParam()));
                return false;
            }
            
            return true;
        }
 
    }
    
    /*Devuelve tipo en busqueda global*/
    public Tipo getTipo(Token id) {
        if ((Simbolo)buscarSimboloGlobal(id.getLexeme())!=null) {
            return (Tipo)buscarSimboloGlobal(id.getLexeme()).getTipo();
            
        } else {
            return null;
        }
        
    }
    /*asignacion global de array*/
    public boolean asignarArray(Id id, Expresion exp){
        //comprobar existencia y tipos de arreglos
        if (exp.isIsPosArray()) {
            return consultarVar(id.getId(), null) && consultarVar(exp.getIdArray().getId(), null) ;
        }
        return consultarVar(id.getId(), null);
    }
    /*inicializa tipos primitivos*/
    public void iniciarTiposBases(){
        float a = 23.6f;
        int b = 8;
        
        long c= 89;
        a = c;
        
        //c=a; error
        a=b;
        
        //INICIALIZAR LOS PRIMEROS TIPOS
        this.addSimbolo(new Token("int",0,0), new Tipo(TipoVar.INT,null,new BigInteger("-2147483648"),new BigInteger("2147483647"),Categoria.BASE,0,null,0,3,null,null));
        this.addSimbolo(new Token("long",0,0), new Tipo(TipoVar.LONG,null,new BigInteger("-9223372036854775808"),new BigInteger("9223372036854775807"),Categoria.BASE,0,null,0,4,null,null));
        this.addSimbolo(new Token("double",0,0), new Tipo(TipoVar.DOUBLE,null,new BigInteger("-9223372036854775808"),new BigInteger("9223372036854775807"),Categoria.BASE,0,null,0,6,null,null));
        this.addSimbolo(new Token("float",0,0), new Tipo(TipoVar.FLOAT,null,new BigInteger("-2147483648"),new BigInteger("2147483647"),Categoria.BASE,0,null,0,5,null,null));
        this.addSimbolo(new Token("byte",0,0), new Tipo(TipoVar.BYTE,null,new BigInteger("-128"),new BigInteger("127"),Categoria.BASE,0,null,0,2,null,null));
        this.addSimbolo(new Token("char",0,0), new Tipo(TipoVar.CHAR,null,new BigInteger("-128"),new BigInteger("127"),Categoria.BASE,0,null,0,2,null,null));
        this.addSimbolo(new Token("boolean",0,0), new Tipo(TipoVar.BOOLEAN,null,null,null,Categoria.BASE,0,null,0,1,null,null));
        this.addSimbolo(new Token("string",0,0), new Tipo(TipoVar.STRING,null,null,null,Categoria.BASE,0,null,0,7,null,null));
        this.addSimbolo(new Token("void",0,0), new Tipo(TipoVar.VOID,null,null,null,Categoria.BASE,0,null,0,8,null,null));
    
        
    }
    /*evaluar tipo de subprograma void u otro*/
    public boolean evaluarVoid(Tipo tipo, List<Instruccion> list, Token id, InstruccionSub sub){
        if (tipo.getTipo()==TipoVar.VOID) {
            if (list!=null) {
               //evaluar que no venga ningun return
                for(Instruccion ins: list){
                    if (ins!=null) {
                      if (ins instanceof InstruccionRetorno) {
                            InstruccionRetorno insRet = (InstruccionRetorno)ins;
                            errorsList.add(String.format("El Subprograma '%s' tipo VOID que intenta declarar , linea %d columna %d no puede contener ningun RETORNO como el de la linea %d columna %d  .",
                                    id.getLexeme(), id.getLine(), id.getColumn(), insRet.getRetorno().getLine(),insRet.getRetorno().getColumn()));
                            return false;
                        }  
                    }

                } 
            }
            
        } else {
            boolean equiv = true;
            if (list!=null) {
               //evaluar que venga almenos un return
                for(Instruccion ins: list){
                    if (ins!=null) {
                      if (ins instanceof InstruccionRetorno) {
                            //evaluar que cada uno de los retornos sea del mismo tipo
                            for(Instruccion ins1: list){
                                if (ins1 instanceof InstruccionRetorno) {
                                    InstruccionRetorno ret = (InstruccionRetorno)ins1;
                                    /*evaluar exp de retorno*/
                                    ret.getExp().evaluarExpresiones(this, TipoVar.LOCAL, sub);
                                    if (ret.getExp().getTipo().getTipo()!=tipo.getTipo() ) {
                                        
                                        if (ret.getExp().getTipo().getJerarqui()>=2 && ret.getExp().getTipo().getJerarqui()<=6) {
                                            if ( tipo.getJerarqui()>=2 && tipo.getJerarqui()<=6) {
                                                if (ret.getExp().getTipo().getJerarqui()>tipo.getJerarqui()) {
                                                    errorsList.add(String.format("El tipo '%s' de '%s' , que desea retornar linea %d columna %d no es compatible con el tipo '%s' del subprograma '%s'.",
                                                    ret.getExp().getTipo().getTipo().toString(), ret.getExp().getLugarTemp(),
                                                    ret.getRetorno().getLine(),ret.getRetorno().getColumn(),tipo.getTipo(), id.getLexeme()));
                                                    equiv = false;
                                                }
                                            } else {
                                                errorsList.add(String.format("El tipo '%s' de '%s' , que desea retornar linea %d columna %d no es compatible con el tipo '%s' del subprograma '%s'.",
                                                    ret.getExp().getTipo().getTipo().toString(), ret.getExp().getLugarTemp(),
                                                    ret.getRetorno().getLine(),ret.getRetorno().getColumn(),tipo.getTipo(), id.getLexeme()));
                                                    equiv = false;
                                            }
                                        } else {
                                            errorsList.add(String.format("El tipo '%s' de '%s' , que desea retornar linea %d columna %d no es compatible con el tipo '%s' del subprograma '%s'.",
                                                    ret.getExp().getTipo().getTipo().toString(), ret.getExp().getLugarTemp(),
                                                    ret.getRetorno().getLine(),ret.getRetorno().getColumn(),tipo.getTipo(), id.getLexeme()));
                                                    equiv = false;
                                        }  
                                        
                                    }
                                }
                            }
                            return equiv;
                        }  
                    }

                } 
            }
            
            errorsList.add(String.format("El Subprograma '%s' tipo '%s' que intenta declarar , linea %d columna %d debe tener RETORNO .", id.getLexeme(),tipo.getTipo().toString(), id.getLine(), id.getColumn()));
            return false;
        }
        return true;
    }
    
    /*@METODOS LOCALES---------------------------------------------------------------------------------------------------*/
    /*consultar la existencia de una variable Local*/
    public boolean consultarVarLocal(Token id, String padre){
        if (buscarSimboloLocal(id.getLexeme(), padre)!=null) {
            //si se encuentra de manera local
            return true;
        } else if (buscarPrametroLocal(id.getLexeme(), padre)!=null) {
            //si se encuentra como parametro del subPrograma
            return true;
            
        }  else if (buscarSimboloGlobal(id.getLexeme())!=null) {
            //sino si se encuentra de manera global
            return true;
        }
        errorsList.add(String.format("La variable Local '%s' que intenta utilizar o asignar , linea %d columna %d no ha sido declarada.", id.getLexeme(), id.getLine(), id.getColumn()));
        return false;
    
    }
    /*buscar variable como parametro de un subprograma*/
    /*Metodo de busqueda Local, pueden hacerse mas dependiendo que parametros verificar*/
    public Simbolo buscarPrametroLocal(String name, String padre){
        for(Simbolo sim: this.sym){
            if (sim.getNombre().equals(name) && sim.getTipo().getAmbito()==1 && sim.getTipo().getSubPadre().equals(padre) && sim.getTipo().getCategoria()== Categoria.PARAMETRO) {
                return sim;
            }
        }
        return null;
        
    }
    //agregar una variable de forma global
    public boolean addPrametroLocal(Token id, Tipo tipo, String Padre){
        if (buscarPrametroLocal(id.getLexeme(), Padre)!=null) {
            errorsList.add(String.format("El Parametro Local '%s' que intenta declarar , linea %d columna %d ya fue declarado anteriormente.", id.getLexeme(), id.getLine(), id.getColumn()));
            return false;
        } 
        sym.add(new Simbolo(getNewSimbol(), id.getLexeme(),tipo));
        return true;
    
    }
    
    /*Devuelve tipo en busqueda global*/
    public Tipo getTipoLocal(Token id, String padre) {
        if ((Simbolo)buscarSimboloLocal(id.getLexeme(), padre)!=null) {
            return (Tipo)buscarSimboloLocal(id.getLexeme(), padre).getTipo();
        } else if ((Simbolo)buscarPrametroLocal(id.getLexeme(), padre)!=null) {
            return (Tipo)buscarPrametroLocal(id.getLexeme(), padre).getTipo();
        } else if ((Simbolo)buscarSimboloGlobal(id.getLexeme())!=null) {
            return (Tipo)buscarSimboloGlobal(id.getLexeme()).getTipo();
        } else {
            return null;
        }
        
    }
    
    /*Devuelve tipo en busqueda global*/
    public void setVarLocal(Token id, String padre) {
        if ((Simbolo)buscarSimboloLocal(id.getLexeme(), padre)!=null) {
            ((Simbolo)buscarSimboloLocal(id.getLexeme(), padre)).setNombre(id.getLexeme()+padre);
        } else if ((Simbolo)buscarPrametroLocal(id.getLexeme(), padre)!=null) {
            ((Simbolo)buscarPrametroLocal(id.getLexeme(), padre)).setNombre(id.getLexeme()+padre);
        } else if ((Simbolo)buscarSimboloGlobal(id.getLexeme())!=null) {
            //es global no setear
        } else {
            //no existe
        }
        
    }
    
    /*Metodo de busqueda Local, pueden hacerse mas dependiendo que parametros verificar*/
    public Simbolo buscarSimboloLocal(String name, String padre){
        for(Simbolo sim: this.sym){
            if (sim.getNombre().equals(name) && sim.getTipo().getAmbito()==1 && sim.getTipo().getSubPadre().equals(padre)) {
                return sim;
            }
        }
        return null;
        
    }
    /*verifica lista de subprogramas*/
    public boolean verificarSubs(List<Instruccion> list){
        //verificar que todo lo que se utiliza en el sub es valido
        boolean retorno = true;
        //InstruccionSub sub;
        for(Instruccion in: list){
            //sub = (InstruccionSub)in;
            retorno = verificarSub((InstruccionSub)in);
        }
        return retorno;
    
    }
    /*verifica un subprograma*/
    public boolean verificarSub(InstruccionSub sub){
        boolean retorno = true;
        sub.agregar(); /*setea su tipo y evalua sus parametros*/
        if (verificarTipoInstrucLocal(sub)) { /*verifica cada instruccion del sub*/
            /*validar que el nombre del sub no se este utilizando */
            if (this.addSubprograma(sub.getProcessName(), sub.getTipo())) {
                    retorno = this.evaluarVoid(sub.getTipo(), sub.getInstruccionesLocal(), sub.getProcessName(), sub); //evaluar las instrucciones locales del sub
            } else {
                    retorno = false;
            }		
        }
        return  retorno;
    
    }
    /*verifica instrucciones locales de un subprograma*/
    public boolean verificarTipoInstrucLocal(InstruccionSub sub){
        return verificarInstruccionLocal(sub.getDeclaracionesLocal(), sub) && verificarInstruccionLocal(sub.getInstruccionesLocal(), sub);
        
    }
    /*verificar instruccion Local segun tipo*/
    public boolean verificarInstruccionLocal(List<Instruccion> list, InstruccionSub sub){
        boolean retorno = true;
        for(Instruccion in: list){
            /*verificar cada una de las instrucciones posibles sus expresiones
                y tipos donde se utilicen*/
            if (in instanceof InstruccionDeclaracion) {
                retorno = verificarDeclaracionLocal(in, sub);
            } else if (in instanceof InstruccionArray){
                retorno = verificarArregloLocal(in, sub);
            } else if (in instanceof InstruccionAsig){
                retorno = verificarAsignacionLocal(in, sub);
            } else if (in instanceof EvaluarExpresion) {
                ((EvaluarExpresion) in).evaluarExpresiones(TipoVar.LOCAL, this, sub);
            }
            
        }
        return retorno;
    }
    
    /*verificar declaracion Local de variable*/
    public boolean verificarDeclaracionLocal(Instruccion in, InstruccionSub sub){
        boolean retorno = true;
        //InstruccionDeclaracion declaracion = (InstruccionDeclaracion)in;
        //List<Id> vars = ((InstruccionDeclaracion)in).getListVar();
        Tipo tipo = ((InstruccionDeclaracion)in).getTipo();
        /*evaluando cada variable Localmente*/
        for(Id id: ((InstruccionDeclaracion)in).getListVar()){
            /*buscar simbolo Local con  padre procesName*/
            if (buscarSimboloLocal(id.getId().getLexeme(), sub.getProcessName().getLexeme())!=null) {
                errorsList.add(String.format("La variable LOCAL '%s' que intenta declarar , linea %d columna %d ya fue declarada anteriormente.", id.getId().getLexeme(), id.getId().getLine(), id.getId().getColumn()));
                retorno = false;
            } else {
                /*evaluacion de expresiones si hay una asignacion*/
                if (id.isIsAsig()) {
                    id.getAsig().getExp().evaluarExpresiones(this, TipoVar.LOCAL, sub);
                    /*evaluar tipo a asignar*/
                    if (((InstruccionDeclaracion)in).getTipo().getJerarqui()<id.getAsig().getExp().getTipo().getJerarqui()) {
                        errorsList.add(String.format("A La variable LOCAL '%s' , linea %d columna %d no se le puede asignar un valor Tipo %s.",
                            id.getId().getLexeme(), id.getId().getLine(), id.getId().getColumn(),id.getAsig().getExp().getTipo().getTipo().toString()));
                        retorno = false;
                    }
                }
                /*Guardando la variable Local con ambito 1 Local perteneciente al subpadre sub.procesName*/
                sym.add(new Simbolo(getNewSimbol(), id.getId().getLexeme(),
                new Tipo(tipo.getTipo(),null,null,null,Categoria.VAR,0,null,1,tipo.getJerarqui(),sub.getProcessName().getLexeme(),id.getId())));
            }
        }
        
        return retorno;
    
    }
    
    /*verificar declaracion global de arreglo*/
    public boolean verificarArregloLocal(Instruccion in, InstruccionSub sub){
        boolean retorno = true;
        //InstruccionArray declaracion = (InstruccionArray)in;
        //List<Id> vars = ((InstruccionArray)in).getVars();
        TipoDim tipo = ((InstruccionArray)in).getTipoD();
        /*evaluando expresiones en las dimensiones*/
        for(Expresion e: tipo.getDims()){
            e.evaluarExpresiones(this, TipoVar.LOCAL, sub); //deberian evaluarse una lista de expresiones cuando se implemnte n dims
        }
        
        /*evaluando cada array a declarar*/
        for(Id id: ((InstruccionArray)in).getVars()){
            if (buscarSimboloLocal(id.getId().getLexeme(), sub.getProcessName().getLexeme())!=null) {
                errorsList.add(String.format("El arreglo LOCAL '%s' que intenta declarar , linea %d columna %d ya fue declarado anteriormente.", id.getId().getLexeme(), id.getId().getLine(), id.getId().getColumn()));
                retorno = false;
            } else {
                sym.add(new Simbolo(getNewSimbol(), id.getId().getLexeme(),
                new Tipo(tipo.getTipo().getTipo(),null,null,null,Categoria.VAR,0,null,1,tipo.getTipo().getJerarqui(),sub.getProcessName().getLexeme(),id.getId())));
            }
        }
        return retorno;
    
    }
    
    /*verificar asignacion global de variable*/
    public boolean verificarAsignacionLocal(Instruccion in, InstruccionSub sub){
        boolean retorno = true;
        //InstruccionAsig temp = (InstruccionAsig)in;
        /*evaluacion de expresiones en la asignacion*/
        ((InstruccionAsig)in).getLoc().getEx().evaluarExpresiones(this, TipoVar.LOCAL, sub);
        
        ((InstruccionAsig)in).getExp().evaluarExpresiones(this, TipoVar.LOCAL, sub);
        
        
        if (((InstruccionAsig)in).getExp().isIsPosArray() || ((InstruccionAsig)in).getLoc().getEx().isIsPosArray()) {
                //para asignacion de pos de array son distintas validaciones
                if (!asignarArrayLocal(((InstruccionAsig)in).getLoc(), ((InstruccionAsig)in).getExp(), sub)) {
                        retorno = false;
                }
        } else {
                //para asignacion de variables
                /*consultar si la variable a asignar existe*/
                if (consultarVarLocal(((InstruccionAsig)in).getLoc().getId(), sub.getProcessName().getLexeme())) {
                        if (!verificarTipoAsigLocal(((InstruccionAsig)in).getLoc().getId(), ((InstruccionAsig)in).getExp(), sub)) {
                                //consultar si tipo de asignacion es correcta
                                retorno = false;
                        }
                } else {
                        retorno = false;
                }
        }
        ((InstruccionAsig)in).setLoc(new Id(new Token(((InstruccionAsig)in).getLoc().getId().getLexeme()+sub.getProcessName().getLexeme(), ((InstruccionAsig)in).getLoc().getId().getLine(), ((InstruccionAsig)in).getLoc().getId().getColumn()), ((InstruccionAsig)in).getLoc().isIsAsig(), ((InstruccionAsig)in).getLoc().getAsig(), ((InstruccionAsig)in).getLoc().getEx()));
        return  retorno;
    
    }
    /*asignacion Local de array*/
    public boolean asignarArrayLocal(Id id, Expresion exp, InstruccionSub sub){
        //comprobar existencia y tipos de arreglos
        if (exp.isIsPosArray()) {
            return consultarVarLocal(id.getId(), sub.getProcessName().getLexeme()) && consultarVarLocal(exp.getIdArray().getId(), sub.getProcessName().getLexeme()) ;
        }
        return consultarVarLocal(id.getId(), sub.getProcessName().getLexeme());
    }
    
    /*verificador de asignacion de tipo Local*/
    public boolean verificarTipoAsigLocal(Token id, Expresion ex, InstruccionSub sub){
        if (getTipoLocal(id, sub.getProcessName().getLexeme()).getTipo()==ex.getTipo().getTipo()) {
            //si son tipos iguales
            return true;
        } else if (getTipoLocal(id, sub.getProcessName().getLexeme()).getJerarqui()>=ex.getTipo().getJerarqui()) {
            //si el id es de jerarquia mayor
            return true;
        }
        errorsList.add(String.format("A La variable LOCAL '%s' , linea %d columna %d no se le puede asignar un valor Tipo %s.",
                id.getLexeme(), id.getLine(), id.getColumn(),ex.getTipo().getTipo().toString()));
        return false;
    }
    
    //**************************************************************************
    
    public void cleanAll() {
        this.sym.clear();
        this.errorsList.clear();
    }

    public List<String> getErrorsList() {
        return errorsList;
    }

    public void setErrorsList(List<String> errorsList) {
        this.errorsList = errorsList;
    }

    public ComprobadorTipos getComprob() {
        return comprob;
    }

    public void setComprob(ComprobadorTipos comprob) {
        this.comprob = comprob;
    }

    public List<Simbolo> getSym() {
        return sym;
    }

    public void setSym(List<Simbolo> sym) {
        this.sym = sym;
    }

    public List<Instruccion> getListaConsultaSubs() {
        return listaConsultaSubs;
    }

    public void setListaConsultaSubs(List<Instruccion> listaConsultaSubs) {
        this.listaConsultaSubs = listaConsultaSubs;
    }
    
    
}
