/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1comp2.backend.analizadores.simbolos;

/**
 *
 * @author bryan
 */
public class Parametro {
    private Tipo tipo;
    private Token token;

    public Parametro(Tipo tipo, Token token) {
        this.tipo = tipo;
        this.token = token;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
    
    
    
}
