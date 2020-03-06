/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.generadores.GeneradorCod;

/**
 *
 * @author bryan
 */
public class InstruccionVacia extends Instruccion {

    public InstruccionVacia(GeneradorCod generador) {
        super(generador);
    }

    @Override
    public void evaluar() {
        /*vacia*/
    }
    
    
    
}
