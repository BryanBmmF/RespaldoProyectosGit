/*
 * Dedicacion al estudio de los multiples oyentes que pueden recibir la accion
 * que es desencadenada por un objeto fuente que antes
 * fue convocada por un objeto evento
 */
package multiplesoyentes;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class MultiplesOyentes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MarcoPrincipal frame1= new MarcoPrincipal();
        
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
