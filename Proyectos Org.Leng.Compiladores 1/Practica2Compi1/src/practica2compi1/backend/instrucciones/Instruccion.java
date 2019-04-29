/*
 * Clase general Instruccion
 */
package practica2compi1.backend.instrucciones;

import practica2compi1.frontend.PanelGrafico;

/**
 *
 * @author bryan
 */
public abstract class Instruccion {
    
    String token;

    public Instruccion(String token) {
        this.token = token;
    }
    
    
        
    public abstract void ejecutar(PanelGrafico panel);
}
