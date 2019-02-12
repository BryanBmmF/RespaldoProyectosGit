/*
 * En esta seccion se estudian los 3 eventos que ocurren 
 * al momento de interactuar con un frame 
 * estos son: objeto evento (que provoca la accion) action event y window event
 * objeto fuente(quien desencadena la accion) (JButton)(addActionListener(objeto Listener))
 * objeto Listener(quien recibe la accion) (JPanel) ActionListener (actionPerformed(objeto Evento))

 */
package eventos;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class Eventos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instanciacion de MarcoBotones
        MarcoBotones miFrame= new MarcoBotones();
        
        //acciones    
        miFrame.setVisible(true);      
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
