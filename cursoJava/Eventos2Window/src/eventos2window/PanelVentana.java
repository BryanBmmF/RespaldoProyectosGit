/*
 * Panel para ventana
 */
package eventos2window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author bryan
 */

//creacion de clase Receptor que implemente la interfaz Window listene
public class PanelVentana implements WindowListener{
    
    //implementando todos los metodos WindowListener
    @Override
    public void windowActivated(WindowEvent e1){
    
        System.out.println("Ventana Activada");
    }
    @Override
    public void windowClosed(WindowEvent e2){
    
        System.out.println("La Ventana Ha sido cerrada");
    }
    @Override
    public void windowClosing(WindowEvent e3){
    
        System.out.println("Cerrando Ventana");
    }
    @Override
    public void windowDeactivated(WindowEvent e4){
    
        System.out.println("Ventana Desactivada");
    }
    @Override
    public void windowDeiconified(WindowEvent e5){
    
        System.out.println("Ventana Restaurada");
    }
    @Override
    public void windowIconified(WindowEvent e6){
    
        //evento minimizar la ventana
        System.out.println("VentanaMinimizada");
    }
    @Override
    public void windowOpened(WindowEvent e7){
    
        System.out.println("Ventana Abierta");
    }
}
