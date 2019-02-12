/*
 * Dedicacion al estudio de las areas de texto que se
 * pueden colocar dentro de un panel
 */
package areadetexto;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class AreaDeTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoArea miMarco = new MarcoArea();
        
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
