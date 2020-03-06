/*
 * Instruccion Do While
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
public class InstruccionDo extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private List<Instruccion> list;
    private Expresion exp;
    //private EtiqRedireccion redir;

    public InstruccionDo(List<Instruccion> list, Expresion exp, GeneradorCod generador) {
        super(generador);
        this.list = list;
        this.exp = exp;
        //this.redir = new EtiqRedireccion(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
    }

    @Override
    public void evaluar() {
        //generar etiqueta inicial
        generarCuarteto(Operador.ETIQ, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), null, null);
        //evaluando instrucciones bloque
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }
        //agregando condicion while
        if (exp.getList()!=null) {
                for(Cuarteto c: exp.getList()){
                    this.getGenerador().addCuarteto(c);
                }
        } else {
            if (exp.getEtiq1()==null) {
                exp.iniciarEtiq1(this.getGenerador().getNuevaEtiq(), this.getGenerador().getNuevaEtiq());
                
            }
            /*loops*/
            if (exp.getLugarTemp().equals("1")) {
                generarCuarteto(Operador.IF_IGUAL, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), exp, new Expresion("1", exp.getTipo(), this.getGenerador()));
                generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
            } else if(exp.getLugarTemp().equals("0")){
                generarCuarteto(Operador.IF_IGUAL, new Expresion(exp.getEtiq1().v(), exp.getTipo(), this.getGenerador()), exp, new Expresion("1", exp.getTipo(), this.getGenerador()));
                generarCuarteto(this.getGenerador().getOp().GOTO, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null);
            }
            
            
        } 
        //etiquta de salto
        generarCuarteto(Operador.ETIQ, new Expresion(exp.getEtiq1().f(), exp.getTipo(), this.getGenerador()), null, null); 
        
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2)); 
    }

    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarDoGlobal(sym);
        } else {
            verificarDoLocal(sym, sub);
        }
        
    }
    
    public void verificarDoGlobal(TablaSimbolos sym){
        /*evaluar expresion de condicion*/
        exp.evaluarExpresiones(sym, TipoVar.GLOBAL, null); //para local deberia ser evaluarExresiones2
        /*evaluar cada instruccion*/
        sym.verificarTipoInstruc(list);
    
    }
    
    public void verificarDoLocal(TablaSimbolos sym, InstruccionSub sub){
        /*evaluar expresion de condicion*/
        exp.evaluarExpresiones(sym, TipoVar.LOCAL, sub); //para local deberia ser evaluarExresiones2
        /*evaluar cada instruccion*/
        sym.verificarInstruccionLocal(list, sub);
        
    }
    
    
}
