/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionSecuencial extends Instruccion implements GenerarCuarteto{
    public Instruccion ins1;
    public Instruccion ins2;

    public InstruccionSecuencial(Instruccion ins1, Instruccion ins2, GeneradorCod generador) {
        super(generador);
        this.ins1 = ins1;
        this.ins2 = ins2;
    }
    
    @Override
    public void evaluar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
    }
    
}
