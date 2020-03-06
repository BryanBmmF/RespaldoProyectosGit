/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valores;

/**
 *
 * @author jpmazate
 */
public class Etiquetas {
    
    private static String etiqueta = "e";
    private static int contador=0;
    
    
    
    public static String siguienteEtiqueta(){
        etiqueta = "e"+contador;
        contador++;
        return etiqueta;
    }
    
    public static String ultimaEtiqueta(){
        return etiqueta;
    }
    
    public static void reiniciar(){
        contador=0;
    }
    
}
