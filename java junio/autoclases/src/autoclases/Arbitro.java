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
public class Arbitro extends Persona{
    private String posicion;
    private int edad;

    public Arbitro(String nombre, String nacionalidad, String posicion, int edad) {
        super(nombre, nacionalidad);
        this.posicion = posicion;
        this.edad = edad;        
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
