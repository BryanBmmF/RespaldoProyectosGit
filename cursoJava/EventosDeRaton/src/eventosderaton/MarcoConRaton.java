/*
 * Marco para recibir instrucciones de raton
 */
package eventosderaton;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */

//objeto Fuente
public class MarcoConRaton extends JFrame{
    
    public MarcoConRaton(){
        
        setVisible(true);
        setBounds(300,300,500,400);
        
        //instancia que implementa Mouse Listener
        EventoRaton nuevoEventoRaton=new EventoRaton();
        
        //metodo que pone a escucha al oyente EventoRaton
        
        addMouseListener(nuevoEventoRaton);
        
    
    }
}
