/*
 * Dedicacion al estudio de los cuadros de texto
 * y metodos para crearlos
 */
package cuadrodetexto;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class CuadroDeTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoTexto miMarco= new MarcoTexto();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
    
}
