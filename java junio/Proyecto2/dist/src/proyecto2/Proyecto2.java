/*
 * clase Principal para Proyecto 2 IPC1 Junio 2018
 */
package proyecto2;

import proyecto2.UI.FramePrincipal;

/**
 * title: Aplicacion para bufete de abogados
 * @author bryan
 */

public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static FramePrincipal ventanaPrincipal= new FramePrincipal();
    public static void main(String[] args) {
        // TODO code application logic here
        ventanaPrincipal= new FramePrincipal();
        ventanaPrincipal.setExtendedState(FramePrincipal.MAXIMIZED_BOTH);
        ventanaPrincipal.setVisible(true);
    }
    
}
