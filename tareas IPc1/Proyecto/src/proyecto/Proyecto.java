/*
 * proyecto memoria
 */
package proyecto;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        VentanaJuego miVentana= new VentanaJuego();
        
        miVentana.setVisible(true);
        
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
