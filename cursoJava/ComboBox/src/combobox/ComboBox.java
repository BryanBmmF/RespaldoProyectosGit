/*
 * Dedicacion a los menus desplegables o combo Box
 * y su aplicacion en panel
 */
package combobox;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class ComboBox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoCombo miMarco= new MarcoCombo();
        
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
