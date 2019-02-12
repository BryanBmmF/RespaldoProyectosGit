/**
 * Creacion de marcos o frames
 */
package interfazgrafica1;
import javax.swing.*;

/**
 *
 * @author bryan
 */
public class InterfazGrafica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //instancioacion de obejeto marco principal 
        MarcoPrincipal marco1= new MarcoPrincipal();
        
        //visualizando marco 1
        marco1.setVisible(true);
        
        //accion para cerrar el programa
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
}
