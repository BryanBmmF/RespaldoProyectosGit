
package interfazgrafica2;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class InterfazGrafica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //instanciacion de marco con dibujo
        
        MarcoDibujo nuevoMarco= new MarcoDibujo();
        
        //visble
        nuevoMarco.setVisible(true);
        
        //accion de cierre
        nuevoMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
