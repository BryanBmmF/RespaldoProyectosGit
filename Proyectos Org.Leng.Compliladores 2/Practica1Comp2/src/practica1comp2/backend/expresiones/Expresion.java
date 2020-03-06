/*Expresion*/
package practica1comp2.backend.expresiones;
import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.ast.AST;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.EtiqCondicion;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;
import practica1comp2.backend.instrucciones.Instruccion;

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
    
    //constructor simple para identidicador
    public Expresion(String lugarTemp, Id ident, GeneradorCod generador) {
        super(generador);
        this.lugarTemp = lugarTemp;
        this.ident = ident;
        this.idArray = new Id(null, false, null);
        this.tipo = new Tipo(null,0,null);
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
        this.evaluar();
    }
    
    public void cambiarEtiq(EtiqCondicion et){
        etiq1.setV(et.f());
        etiq1.setF(et.v());
    }
    
    public void generarDobleCuarteto(Operador op, String et1, String et2){
        this.isBoolean = true;
        //etiq2 = new EtiqCondicion(et1, et2);
//        if (etiq2==null) {   
//            etiq2 = new EtiqCondicion(et1, this.getGenerador().getNuevaEtiq());
//            //this.getGenerador().dismEtiq();
//        }
        generarCuarteto(op, et1, oper1.getLugarTemp(), oper2.getLugarTemp());
        generarCuarteto(this.getGenerador().getOp().GOTO, et2, null, null);
    
    }
    public void generarTripleCuarteto(String et1, String et2){
        generarCuarteto(this.getGenerador().getOp().ETIQ, et1, null, null);
        generarCuarteto(this.getGenerador().getOp().ETIQ, et2, null, null);
        generarCuarteto(this.getGenerador().getOp().GOTO, et2, null, null);
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
                case DISTINTO: 
                    generarDobleCuarteto(this.getGenerador().getOp().IF_NOIGUAL,etiq1.f(),etiq1.v());
                    break;
                case NOT: {
                        //cambiarEtiq(new EtiqCondicion(etiq1.v(), etiq1.f()));
                    //etiq1 = new EtiqCondicion();
//                    list = this.getGenerador().unirQuad(null, null); 
//                    this.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
//                    //generando cuartetos OR
//                    generarCuarteto(this.getGenerador().getOp().IF_IGUAL, etiq1.v(), oper1.getLugarTemp(), "1");
//                    generarCuarteto(this.getGenerador().getOp().GOTO, etiq1.f(), null, null);
//                    this.isBoolean = true;
                    //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);//**
                    
                    if (oper1.getList()!=null) {
                       list = this.getGenerador().unirQuad(oper1.getList(), null); 
                       this.iniciarEtiq1(oper1.getEtiq1().v(),oper1.getEtiq1().f());
                       //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.v(), null, null);
                        //this.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                        //generarCuarteto(this.getGenerador().getOp().IF_IGUAL, etiq1.v(), oper1.getLugarTemp(), "1");
                        //generarCuarteto(this.getGenerador().getOp().GOTO, etiq1.f(), null, null);
                        this.isBoolean = true;
                    } else{
                        list = this.getGenerador().unirQuad(null, null); 
                        this.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, etiq1.v(), oper1.getLugarTemp(), "1");
                        generarCuarteto(this.getGenerador().getOp().GOTO, etiq1.f(), null, null);
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
                       generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.v(), null, null);
                    } else {
                        list = this.getGenerador().unirQuad(oper1.getList(), null);
                        
                        if (oper2.getEtiq1()!=null) {
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f());
                            //setear las del oper dos poruq evan despues
                            oper2.getEtiq1().setV(this.getGenerador().getNuevaEtiq());
                            oper2.getEtiq1().setF(this.getGenerador().getNuevaEtiq());
                            //iniciando etiquetas de oper 1
                            oper1.iniciarEtiq1(etiq1.v(), etiq1.f());
                            oper2.getList().get(oper2.getList().size()-2).setResult(oper2.getEtiq1().v());
                        } else {
                            oper2.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f());
                        }                      
                        //generando cuartetos AND
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, etiq1.v(), oper1.getLugarTemp(), "1");
                        generarCuarteto(this.getGenerador().getOp().GOTO, etiq1.f(), null, null);
                        generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.v(), null, null);
                        
                    }

                    if (oper2.getList()!=null) {
                        //setear resultado de ultimo cuarteto para que retorne a una etiqueta anterior
                        oper2.getList().get(oper2.getList().size()-1).setResult(oper1.getEtiq1().f());
                        list = this.getGenerador().unirQuad(this.list, oper2.getList());
                        //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);
                        this.isBoolean = true;
                    } else {
                        etiq2 = new EtiqCondicion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, etiq2.v(), oper2.getLugarTemp(), "1");
                        generarCuarteto(this.getGenerador().getOp().GOTO, etiq1.f(), null, null);
                        //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);
                        this.isBoolean = true;
                    }
                        this.etiq1.setV(etiq2.v());

                }
                    break;
                case OR: {
                    if (oper1.getList()!=null) {
                       list = this.getGenerador().unirQuad(oper1.getList(), null); 
                       generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null); //**  rev AND
                    } else {
                        list = this.getGenerador().unirQuad(oper1.getList(), null);
                        
                        if (oper2.getEtiq1()!=null) {
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f()); //*
                            //setear las del oper dos poruq evan despues
                            oper2.getEtiq1().setV(this.getGenerador().getNuevaEtiq());  
                            oper2.getEtiq1().setF(this.getGenerador().getNuevaEtiq());
                            //iniciando etiquetas de oper 1
                            oper1.iniciarEtiq1(etiq1.v(), etiq1.f());//**
                            oper2.getList().get(oper2.getList().size()-2).setResult(oper1.getEtiq1().v());
                        } else {
                            oper2.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                            etiq1 = new EtiqCondicion(oper2.getEtiq1().v(), oper2.getEtiq1().f()); //**
                        } 
                        
                        //generando cuartetos OR
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, etiq1.v(), oper1.getLugarTemp(), "1");
                        generarCuarteto(this.getGenerador().getOp().GOTO, etiq1.f(), null, null);
                        generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);//**
                        
                    }
                    
                    
                    
                    if (oper2.getList()!=null) {
                        //setear resultado de ultimo cuarteto para que retorne a una etiqueta anterior
                        oper2.getList().get(oper2.getList().size()-2).setResult(oper1.getEtiq1().v()); //**  rev AND
                        oper2.getList().get(oper2.getList().size()-1).setResult(oper2.getEtiq1().v());
                        list = this.getGenerador().unirQuad(this.list, oper2.getList());
                        //generarCuarteto(this.getGenerador().getOp().ETIQ, etiq1.f(), null, null);
                        this.isBoolean = true;
                    } else {
                        etiq2 = new EtiqCondicion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                        generarCuarteto(this.getGenerador().getOp().IF_IGUAL, etiq1.v(), oper2.getLugarTemp(), "1");//*  rev AND
                        generarCuarteto(this.getGenerador().getOp().GOTO, etiq2.v(), null, null);//*  rev AND
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
                    //une los cuartetos que provienen de las experesiones y el nuevo
                    //list = this.getGenerador().unirQuad(oper1.getList(), oper2.getList());
                    generarCuarteto(op, lugarTemp, oper1.getLugarTemp(), oper2.getLugarTemp());
            }
            
            
        }
        
    }
    

    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
        //Cuarteto cu = new Cuarteto(op, result, arg1, arg2);
        //code += cu.imprimir()+"\n";
        //si son condiciones necesitan de if y gostos
        
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
    
    
    
}
