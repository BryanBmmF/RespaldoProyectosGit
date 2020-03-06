/*
 * Instruccion else
 */
package practica1comp2.backend.instrucciones;

import java.math.BigInteger;
import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Categoria;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.Tipo;
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
public class InstruccionElse extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private Expresion exp;
    private List<Instruccion> list;
    private EtiqRedireccion redir;

    public InstruccionElse(Expresion exp, List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.exp = exp;
        this.list = list;
        this.redir = new EtiqRedireccion(null, null);
    }

    public InstruccionElse(List<Instruccion> list, GeneradorCod generador) {
        super(generador);
        this.list = list;
    }
    
    @Override
    public void evaluar() {
         //bloque de instrucciones
        if (list!=null) {
            for(Instruccion in: list){
                in.evaluar();
            }
        }    
        //etiq final
        generarCuarteto(Operador.ETIQ, new Expresion(redir.fin(), new Tipo(TipoVar.INT, null, BigInteger.ONE, BigInteger.ONE, Categoria.VAR, 0, null, 0, 0, null, null), this.getGenerador()), null, null);
        
    }
    

    public EtiqRedireccion getRedir() {
        return redir;
    }

    public void setRedir(EtiqRedireccion redir) {
        this.redir = redir;
    }

    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarElseGlobal(sym);
        } else {
            verificarElseLocal(sym, sub);
        }
        
    }
    
    public void verificarElseGlobal(TablaSimbolos sym){
        /*evaluar expresion de condicion*/
        if (exp!=null) {
            exp.evaluarExpresiones(sym, TipoVar.GLOBAL, null); //para local deberia ser evaluarExresiones2
        }
        
        /*evaluar cada instruccion*/
        sym.verificarTipoInstruc(list);
    
    }
    
    public void verificarElseLocal(TablaSimbolos sym, InstruccionSub sub){
        /*evaluar expresion de condicion*/
        if (exp!=null) {
            exp.evaluarExpresiones(sym, TipoVar.LOCAL, sub); //para local deberia ser evaluarExresiones2
        }
        
        /*evaluar cada instruccion*/
        sym.verificarInstruccionLocal(list, sub);
        
    }
    
    
}
