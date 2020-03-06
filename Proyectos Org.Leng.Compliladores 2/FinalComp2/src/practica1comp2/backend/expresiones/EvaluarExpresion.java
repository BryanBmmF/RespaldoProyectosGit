/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.expresiones;

import practica1comp2.backend.analizadores.simbolos.TablaSimbolos;
import practica1comp2.backend.analizadores.simbolos.TipoVar;
import practica1comp2.backend.instrucciones.InstruccionSub;

/**
 *
 * @author bryan
 */
public interface EvaluarExpresion {
    
    public abstract void evaluarExpresiones(TipoVar ambito, TablaSimbolos sym, InstruccionSub sub);
}
