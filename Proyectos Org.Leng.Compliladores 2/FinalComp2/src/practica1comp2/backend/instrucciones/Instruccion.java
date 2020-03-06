
package practica1comp2.backend.instrucciones;
import practica1comp2.backend.generadores.GeneradorCod;
import practica1comp2.backend.generadores.Operador;

/**
 *
 * @author bryan
 */
public abstract class Instruccion {    
    private GeneradorCod generador;

    public Instruccion(GeneradorCod generador) {
        this.generador = generador;
    }
    
    public abstract void evaluar();

    public GeneradorCod getGenerador() {
        return generador;
    }

    public void setGenerador(GeneradorCod generador) {
        this.generador = generador;
    }
    
    
    
}
