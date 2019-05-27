/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2compi1.backend.instrucciones;

/**
 *
 * @author bryan
 */
public abstract class Instruccion {
    String token;

    public Instruccion(String token) {
        this.token = token;
    }
        
    public abstract void ejecutar();
    public abstract String recuperarTexto();
    
}
