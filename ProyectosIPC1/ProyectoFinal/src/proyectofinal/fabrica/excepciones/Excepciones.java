/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.fabrica.excepciones;

/**
 *
 * @author bryan
 */
public class Excepciones {
    
}
class errorLongitud extends Exception{
    
    public errorLongitud(){
    
    }
    public errorLongitud(String mensaje){
        
        super(mensaje);
    
    }
}
