/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclases;

/**
 *
 * @author christian
 */
public class jugadorjr extends Jugador {
    String apodo;

    public jugadorjr(String apodo, String nombre, String nacionalidad, String posicion, int numero) {
        super(nombre, nacionalidad, posicion, numero);
        this.apodo = apodo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    
}
