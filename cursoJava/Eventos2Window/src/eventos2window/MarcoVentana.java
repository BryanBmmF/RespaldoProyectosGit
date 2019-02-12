/*
 * Marco para Ventana
 */
package eventos2window;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class MarcoVentana extends JFrame{
    
    //constructor
    public MarcoVentana(){
        
        //atributos Generales
        //setTitle("Respondiendo");
        //setBounds(300,300,500,350);
        
        setVisible(true);
        
        //instanciando panel ventana
        
        PanelVentana oyenteVentana=new PanelVentana();
        
        //agregando eventos
        addWindowListener(oyenteVentana);
    
    }
    
}

