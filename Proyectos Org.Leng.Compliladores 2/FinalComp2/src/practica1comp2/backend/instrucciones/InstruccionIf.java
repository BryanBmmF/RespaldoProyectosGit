/*
 * Instruccion If
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.expresiones.EvaluarExpresion;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.EtiqRedireccion;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionIf extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private Expresion exp;
    private List<Instruccion> list;
    private EtiqRedireccion redir;
    private boolean acomp;

    public InstruccionIf(Expresion exp, List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.exp = exp;
        this.list = list;
        this.redir = new EtiqRedireccion(null, null);
        this.acomp = false;
    }
    
    @Override
    public void evaluar() {
        //cuartetos de exp
        if (exp.getList()!=null) {
            for(Cuarteto c: exp.getList()){
                this.getGenerador().addCuarteto(c);
            }
        } else {
            if (exp.getEtiq1()==null) {
                exp.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
            } 
            if (exp.getLugarTemp().equals("1")) {
                generarCuarteto(Operador.IF_IGUAL, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), exp, new Expresion("1", exp.getTipo(), this.getGenerador()));
                generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
            } else if(exp.getLugarTemp().equals("0")){
                generarCuarteto(Operador.IF_IGUAL, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), exp,  new Expresion("1", exp.getTipo(), this.getGenerador()));
                generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
            }
            
        }
        //etiqueta inicio
        generarCuarteto(Operador.ETIQ, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), null, null);
        
        //bloque de instrucciones
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }    
        
        if (acomp) {
            generarCuarteto(Operador.GOTO, new Expresion(redir.fin(), exp.getTipo(), this.getGenerador()), null, null);
        }
       
        generarCuarteto(Operador.ETIQ,new Expresion( exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
 
    }

    
    public EtiqRedireccion getRedir() {
        return redir;
    }

    public void setRedir(EtiqRedireccion redir) {
        this.redir = redir;
    }

    public boolean isAcomp() {
        return acomp;
    }

    public void setAcomp(boolean acomp) {
        this.acomp = acomp;
    }

    public Expresion getExp() {
        return exp;
    }

    public void setExp(Expresion exp) {
        this.exp = exp;
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2)); 
    }
    
    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarIfGlobal(sym);
        } else {
            verificarIfLocal(sym, sub);
        }
        
    }
    
    public void verificarIfGlobal(TablaSimbolos sym){
        /*evaluar expresion de condicion*/
        exp.evaluarExpresiones(sym, TipoVar.GLOBAL, null); //para local deberia ser evaluarExresiones2
        /*evaluar cada instruccion*/
        sym.verificarTipoInstruc(list);
    
    }
    
    public void verificarIfLocal(TablaSimbolos sym, InstruccionSub sub){
        /*evaluar expresion de condicion*/
        exp.evaluarExpresiones(sym, TipoVar.LOCAL, sub); //para local deberia ser evaluarExresiones2
        /*evaluar cada instruccion*/
        sym.verificarInstruccionLocal(list, sub);
    }
  
}
