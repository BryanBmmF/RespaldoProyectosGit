/*
 * receptor que implementa KeyListener Interface.
 */
package eventosteclado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author bryan
 */

//objeto Oyente
public class EventoDeTeclado implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        
        //metodo devolverkeyCkar para devolver la letra presionada
        char letra=e.getKeyChar();
        System.out.println(letra);
        
    }
    
    //metodo presionar
    @Override
    public void keyPressed(KeyEvent e) {
        
        //almacenando codigo al presionar tecla
        //int codigo=e.getKeyCode();
        //System.out.println("codigo");
        
        
    }
    //metodo dejar de pulsar
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
