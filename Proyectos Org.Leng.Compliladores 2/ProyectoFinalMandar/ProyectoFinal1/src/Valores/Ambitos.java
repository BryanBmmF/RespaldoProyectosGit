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
public class Ambitos {
    
    private static int contador=0;
    
    public static int siguienteAmbito(){
        contador++;
        return contador;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Ambitos.contador = contador;
    }
    
    
    
    
}
