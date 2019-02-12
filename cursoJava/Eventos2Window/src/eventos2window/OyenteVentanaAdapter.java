/*
 * Receptor 
 */
package eventos2window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author bryan
 */
public class OyenteVentanaAdapter extends WindowAdapter{
    
    @Override
    public void windowIconified(WindowEvent e6){
    
        //evento minimizar la ventana
        System.out.println("VentanaMinimizada");
    }
    
}
