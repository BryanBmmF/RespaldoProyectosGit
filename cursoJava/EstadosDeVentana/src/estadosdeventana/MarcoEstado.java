/*
 * Marco para ver estados
 */
package estadosdeventana;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MarcoEstado extends JFrame{
    
    //constructor
    public MarcoEstado(){
    
        //atributos
        setVisible(true);
        setBounds(300,300,500,350);
        
        //instanciando nuevoCambio de estado
        CambioEstado nuevoEstado=new CambioEstado();
        
        //poniendo instancia a la escucha de un cambio de ventana
        addWindowStateListener(nuevoEstado);
        
        
    }
    
}
