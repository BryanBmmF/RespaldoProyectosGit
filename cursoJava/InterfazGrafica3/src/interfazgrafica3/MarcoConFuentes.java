/*
 *Introduccion a las fuentes
 */
package interfazgrafica3;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author bryan
 */
public class MarcoConFuentes extends JFrame {
    
    //constructor de Frame para fuentes
    public MarcoConFuentes(){
        
        setBounds(300,300,400,400);
        setTitle("Marco Con Fuentes");
        
        //instanciacion del panel o lamina        
        Panel lamina1= new Panel();
        
        //incluyendo
        
        add(lamina1);
        
        //En caso se quiera incluir el color predeterminado para todo el panel      
        //lamina1.setForeground(Color.ORANGE);
        
        
        
    }
    
}
