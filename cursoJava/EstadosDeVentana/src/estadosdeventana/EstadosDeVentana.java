/*
 * dedicacion al uso de Window Event windowStatelistener
 * para controlar estados de la ventana 
 */
package estadosdeventana;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class EstadosDeVentana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instanciacion de marco
        
        MarcoEstado Frame1= new MarcoEstado();
        //accion de cierre
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
