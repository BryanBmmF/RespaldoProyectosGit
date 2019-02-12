/*
 * Dedicacion ha eventos de foco 
 * clase FocusListener  and interfaz FocusListener
 * windowfocusGained(FocusEvent) ganar focos
 * windowLostFocus(FocusEvent)  pierde el foco 
 */
package eventosdefoco;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class EventosDeFoco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoFoco frame1=new MarcoFoco();
        
        frame1.setTitle("Eventos de Foco");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
}
