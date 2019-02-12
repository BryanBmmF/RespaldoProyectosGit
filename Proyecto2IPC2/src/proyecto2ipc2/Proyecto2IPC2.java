/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2ipc2;

import proyecto2ipc2.frontend.JFramePrincipal;
import proyecto2ipc2.frontend.LoginUsuario;

/**
 *
 * @author bryan
 */
public class Proyecto2IPC2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            JFramePrincipal ventana= new JFramePrincipal();
            LoginUsuario login= new LoginUsuario(ventana);
            login.setVisible(true); 
    }
    
}
