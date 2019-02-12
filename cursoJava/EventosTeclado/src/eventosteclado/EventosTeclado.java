/*
 * Dedicacion a los eventos por medio del teclado
 */
package eventosteclado;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class EventosTeclado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoConTeclas Frame1= new MarcoConTeclas();
        
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame1.setTitle("Eventos de teclado");
        
    }
    
}
