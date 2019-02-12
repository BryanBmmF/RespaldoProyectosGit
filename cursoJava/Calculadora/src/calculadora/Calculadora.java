/*
 * Dedicacion a la aplicacion de layouts en elementos
 * y funcionalidad de cada componente
 * Calculadora moderna
 */
package calculadora;

import javax.swing.JFrame;

/**
 *
 * @author bryan
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //instanciacion de marco
        MarcoCalculadora miMarco= new MarcoCalculadora();
        
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
