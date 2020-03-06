/*
 * Declaracion de arrays
 */
package practica1comp2.backend.instrucciones;

import java.util.List;
import practica1comp2.backend.analizadores.simbolos.Id;
import practica1comp2.backend.analizadores.simbolos.Tipo;
import practica1comp2.backend.expresiones.Expresion;
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
    public void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2) {
    }

    public TipoDim getTipoD() {
        return tipoD;
    }

    public void setTipoD(TipoDim tipoD) {
        this.tipoD = tipoD;
    }

    public List<Id> getVars() {
        return vars;
    }

    public void setVars(List<Id> vars) {
        this.vars = vars;
    }

   
    
    
    
}
