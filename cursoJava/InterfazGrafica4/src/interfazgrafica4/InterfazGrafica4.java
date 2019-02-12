/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica4;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class InterfazGrafica4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //instanciacion de MarcoConImagen
        
        MarcoConImagen newFrame1=new MarcoConImagen();
        
        //acciones del frame1  
        newFrame1.setVisible(true);
        newFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
