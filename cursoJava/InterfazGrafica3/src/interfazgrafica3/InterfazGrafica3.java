/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica3;
import javax.swing.*;


/**
 *
 * @author bryan
 */
public class InterfazGrafica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //insatanciando MracoConFuentes
        
        MarcoConFuentes Frame1= new MarcoConFuentes();
        
        //comportamiento de Frame
        Frame1.setVisible(true);
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
