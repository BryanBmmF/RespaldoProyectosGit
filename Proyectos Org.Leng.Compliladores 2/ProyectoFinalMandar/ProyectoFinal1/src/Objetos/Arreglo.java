/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.List;

/**
 *
 * @author jpmazate
 */
public class Arreglo {
    
    private Token id;
    private List<ExpresionAritmetica> lista;

    public Arreglo(Token id, List<ExpresionAritmetica> lista) {
        this.id = id;
        this.lista = lista;
    }

    public Token getId() {
        return id;
    }

    public void setId(Token id) {
        this.id = id;
    }

    public List<ExpresionAritmetica> getLista() {
        return lista;
    }

    public void setLista(List<ExpresionAritmetica> lista) {
        this.lista = lista;
    }
    
    
    
}
