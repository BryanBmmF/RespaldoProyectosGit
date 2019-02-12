/*
 * Dedicacion al estudio de los JSpinner y sus caracteristicas
 */
package jspinner;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class JSpinner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoSpinner miMarco= new MarcoSpinner();
        
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
