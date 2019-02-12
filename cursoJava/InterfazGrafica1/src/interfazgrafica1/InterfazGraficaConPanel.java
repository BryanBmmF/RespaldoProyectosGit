
package interfazgrafica1;
import javax.swing.*;

/**
 *
 * @author bryan
 */
public class InterfazGraficaConPanel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*instanciando nuevo marco, similar al creado como marco principal para
        ahorrarnos la creacion 
        **/
        
        //instancioacion de obejeto marco principal 
        MarcoParaPanel marco2= new MarcoParaPanel();
                
        //accion para cerrar el programa
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
