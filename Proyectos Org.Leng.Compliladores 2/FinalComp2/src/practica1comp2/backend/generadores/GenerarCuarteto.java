/*
 * Interfaz dedicada a generar cuartetos
 */
package practica1comp2.backend.generadores;

import practica1comp2.backend.expresiones.Expresion;

/**
 *
 * @author bryan
 */
public interface GenerarCuarteto {
     public abstract void generarCuarteto(Operador op, Expresion result, Expresion arg1, Expresion arg2);
    
}
