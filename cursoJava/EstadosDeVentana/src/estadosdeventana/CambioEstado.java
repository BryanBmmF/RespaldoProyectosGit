/*
 * Implementa interfaz WindowStateListener
 */
package estadosdeventana;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

/**
 *
 * @author bryan
 */
//clase controladora de los estados de ventana que implementa la interfaz WindowStateListener
public class CambioEstado implements WindowStateListener {
    
    //implementacion de metodo Interfaz obligatorio 
    //metodo para controlar estados
    @Override
    public void windowStateChanged(WindowEvent evento1) {
        
        //System.out.println("La ventana ha cambiado de estado");
        
        //verificando si ventana esta maximizada o minimizada
        
        //comprobacion de nuevo estado obtenernewState
        //System.out.println(evento1.getNewState());
        
        if(evento1.getNewState()==Frame.MAXIMIZED_BOTH){
            System.out.println("La ventana esta a pantalla completa");
        }
        else if(evento1.getNewState()==Frame.NORMAL){
            System.out.println("Ventana normal");
        }
        else if(evento1.getNewState()==Frame.ICONIFIED){
            System.out.println("Ventana minimizada");
        
        }
    }
    
}
