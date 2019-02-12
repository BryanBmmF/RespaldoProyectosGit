/*
 * Dedicacion al estudio de los layouts o disposiciones(para elementos o eventos)
 * esto para utilizar las disposiociones de java como FlowLayout etc
 * y construir propias dispociociones
 */
package layoutsdisposiciones;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class LayoutsDisposiciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoLayout frame1= new MarcoLayout();
        
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
