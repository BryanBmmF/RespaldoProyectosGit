/*
 * dedicacion a eventos de teclado keyEvent 
 */
package eventosteclado;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoConTeclas extends JFrame{
    
    public  MarcoConTeclas(){
        
        setVisible(true);
        setBounds(700,300,600,450);
        
        //instanciacion
        EventoDeTeclado tecla= new EventoDeTeclado();
        
        //colocando a escucha del evento teclado
        addKeyListener(tecla);
    }
    
}
