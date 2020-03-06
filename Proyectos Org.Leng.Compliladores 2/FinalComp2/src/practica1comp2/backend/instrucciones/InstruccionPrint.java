/*
 * Instruccion Print
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.expresiones.EvaluarExpresion;
import practica1comp2.backend.expresiones.Expresion;
import practica1comp2.backend.generadores.Cuarteto;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionPrint extends Instruccion implements GenerarCuarteto, EvaluarExpresion{
    private boolean salto;
    private List<Expresion> list;

    public InstruccionPrint(boolean salto, List<Expresion> list, GeneradorCod generador) {
        super(generador);
        this.salto = salto;
        this.list = list;
    }
    
    @Override
    public void evaluar() {
        if (salto) {
            for (Expresion ex: list){
                evalExpres(ex.getList());
                generarCuarteto(Operador.PRINTLN, ex, null, null); 
            }
            
        } else {
            for (Expresion ex: list){
                evalExpres(ex.getList());
                generarCuarteto(Operador.PRINT, ex, null, null); 
            }
        }
        
        
    }
    
    public void evalExpres( List<Cuarteto> ex){
        if (ex!=null) {
            for(Cuarteto c: ex){
                this.getGenerador().addCuarteto(c);
            }
        }
    }


    @Override
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
        this.getGenerador().addCuarteto(new Cuarteto(op, result, arg1, arg2));
    }
    
    /*IMPLENTAR DE UNA INTREFAZ QUE EVALUE LAS LAS EXPRESIONES DE LAS INSTRUCCIONES QUE LO NECESITAN
    RECIBIENDO COMO PARAMETRO DE QUE FORMA SE EVALUARA Y LA TABLA DE SIMBOLOS PARA HACER LAS CONSULTAS
    DE FORMA LOCAL O GLOBAL PARA EVITAR MAS CODIGO EN LA TABLA DE SIMBOLOS
    */
    @Override
    public void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub) {
        if (ambito==TipoVar.GLOBAL) {
            verificarPrintGlobal(sym);
        } else {
            verificarPrintLocal(sym, sub);
        }
    }
    
    public void verificarPrintGlobal(TablaSimbolos sym){
        for(Expresion ex:list){
            ex.evaluarExpresiones(sym, TipoVar.GLOBAL, null); //evaluando semanticamente cada expresion que se imprimira en pantalla
        }
    
    }
    
    public void verificarPrintLocal(TablaSimbolos sym, InstruccionSub sub){
        for(Expresion ex:list){
            ex.evaluarExpresiones(sym, TipoVar.LOCAL, sub); //evaluando semanticamente cada expresion que se imprimira en pantalla
        }
    
    }

    public List<Expresion> getList() {
        return list;
    }

    public void setList(List<Expresion> list) {
        this.list = list;
    }

    
    
    
}
