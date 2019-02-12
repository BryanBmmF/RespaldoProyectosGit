/*
 * Dedicacion a los eventos de raton MouseEvent
 */
package eventosderaton;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class EventosDeRaton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancicion de MarcoConraton
        
        MarcoConRaton frame1=new MarcoConRaton();
        
        frame1.setTitle("Eventos de Raton");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
