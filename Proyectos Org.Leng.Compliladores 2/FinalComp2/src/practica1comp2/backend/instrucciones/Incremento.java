/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.instrucciones;

import practica1comp2.backend.generadores.Operador;
import practica1comp2.backend.expresiones.Expresion;

/**
 *
 * @author bryan
 */
public class Incremento {
    private Operador operador;
    private Expresion exp;

    public Incremento(Operador operador, Expresion exp) {
        this.operador = operador;
        this.exp = exp;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Expresion getExp() {
        return exp;
    }

    public void setExp(Expresion exp) {
        this.exp = exp;
    }
    
    
    
    
    
}
