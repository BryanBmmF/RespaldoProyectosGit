/*
  
 */
package eventos2window;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class MarcoVentanaAdapter extends JFrame {
    
    //constructor de MarcoventanaAdapter
    
    public MarcoVentanaAdapter(){
        
        setVisible(true);
        
        //instanciando panel ventana
        
        //OyenteVentanaAdapter oyenteVentana=new OyenteVentanaAdapter();
        
        //agregando eventos
        //addWindowListener(oyenteVentana);
        
        //simplificando lo anterior
        addWindowListener(new OyenteVentanaAdapter());
    
    }
    
}
