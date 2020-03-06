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
public class Simbolo {
    private int num;
    private String nombre;
    private Tipo tipo;

    public Simbolo(int num, String nombre, Tipo tipo) {
        this.num = num;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
