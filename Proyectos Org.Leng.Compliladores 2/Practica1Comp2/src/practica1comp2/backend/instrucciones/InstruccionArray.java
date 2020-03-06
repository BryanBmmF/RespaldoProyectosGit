/*
 * Declaracion de arrays
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.GenerarCuarteto;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public class InstruccionArray extends Instruccion implements GenerarCuarteto{
    
    private TipoDim tipoD;
    private List<Id> vars;

    public InstruccionArray(TipoDim tipoD, List<Id> vars, GeneradorCod generador) {
        super(generador);
        this.tipoD = tipoD;
        this.vars = vars;
    }

    @Override
    public void evaluar() {
        //la declaracion  de arreglos no genera codigo 3d,  eso espero....
        
    }

    @Override
    public void generarCuarteto(Operador op, String result, String arg1, String arg2) {
    }
    
}
