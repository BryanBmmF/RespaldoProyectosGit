/*
 * 
 */
package juegodememoria;
import javax.swing.JFrame;

/**
 * 
 * 
 * @author bryan
 */

public class JuegoDeMemoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //instanciando nuevo Frame
        PlayerFrame frame1= new PlayerFrame();
        
        //haciendo visible el Frame
        frame1.setVisible(true);
        
        //accion de cierre
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //ventana completa
        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
    }
    
    
}
