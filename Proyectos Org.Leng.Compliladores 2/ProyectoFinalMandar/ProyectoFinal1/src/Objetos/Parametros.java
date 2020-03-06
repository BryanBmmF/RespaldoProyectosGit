/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author jpmazate
 */
public class Parametros {
    private String tipo;
    private Dato id;

    public Parametros(String tipo, Dato id) {
        this.tipo = tipo;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Dato getId() {
        return id;
    }

    public void setId(Dato id) {
        this.id = id;
    }
    
    
}
