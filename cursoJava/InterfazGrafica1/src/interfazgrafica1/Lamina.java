/*
 *lamina o panel para dibijar en el marco para panel
 */
package interfazgrafica1;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bryan
 */
public class Lamina extends JPanel {
    
    //inicializando sobreescritura del metodo paintComponent
    
    
    @Override
    public void paintComponent(Graphics nuevoTexto){
        
        //llamando al metodo paint component
        super.paintComponent(nuevoTexto);
        
        //dibujando primer texto en el panel
        nuevoTexto.drawString("Estoy Escribiendo un nuevo Texto en el panel", 175, 175);
    
    }
    
}
