/*
 *Metodos de simplificacion para eventos de ventanas
 * quien es el receptor debe heredadr de abstract Adapter
 */
package eventos2window;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class ClaseAdaptadoraWindow {

    public static void main(String[] args) {
        
        // Instanciacion de MarcoVentana
        
        MarcoVentanaAdapter miFrame=new MarcoVentanaAdapter();
        
        //acciones
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //instanciacion de otra ventana
        MarcoVentanaAdapter miFrame2= new MarcoVentanaAdapter();
        
        //accion para no cerrar conjuntamente
        miFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //atributos por ventana
        miFrame.setTitle("VentanaAdapter1");
        miFrame.setBounds(300, 300, 500, 350);
        
        miFrame2.setTitle("VentanaAdapter2");
        miFrame2.setBounds(900, 300, 500, 350);
        
    }
    
}
