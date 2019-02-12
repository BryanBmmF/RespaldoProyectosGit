/*
 *Dedicado al estudio de los eventos window que son por medio de la ventana
 */
package eventos2window;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class Eventos2Window {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instanciacion de MarcoVentana
        
        MarcoVentana miFrame=new MarcoVentana();
        
        //acciones
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //instanciacion de otra ventana
        MarcoVentana miFrame2= new MarcoVentana();
        
        //accion para no cerrar conjuntamente
        miFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //atributos por ventana
        miFrame.setTitle("Ventana1");
        miFrame.setBounds(300, 300, 500, 350);
        
        miFrame2.setTitle("Ventana2");
        miFrame2.setBounds(900, 300, 500, 350);
    }
    
}
