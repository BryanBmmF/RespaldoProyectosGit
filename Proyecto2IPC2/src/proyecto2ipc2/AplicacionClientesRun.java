/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2;

import javax.swing.JFrame;
import proyecto2ipc2.frontend.AplicacionClientes;

/**
 *
 * @author bryan
 */
public class AplicacionClientesRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AplicacionClientes appCliente= new AplicacionClientes();
        appCliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
        appCliente.setVisible(true);
    }
    
}
