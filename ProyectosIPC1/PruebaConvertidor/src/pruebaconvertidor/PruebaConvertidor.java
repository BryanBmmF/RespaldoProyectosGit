/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconvertidor;

/**
 *
 * @author bryan
 */
public class PruebaConvertidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
             String tarjet="\"4256-3102-6595-\""; 
             String ver= tarjet.substring(0, 2);
             System.out.println(tarjet);
             String ya= tarjet.replaceAll("\"", "");
        double decimal= 0.0001;
        String conv=String.valueOf(decimal);
        
        
        System.out.println(ya);
        
        
        
        
    }
    
}
