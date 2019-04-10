/*
 * Clase Cliente
 */
package proyecto1compi1.backend.app;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class Cliente implements Runnable {
    private int puerto;
    private String mensaje;
    private DataOutputStream ou2;
    public final String HOST = "127.0.0.1";

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run() {
        
        try {
            Socket sc = new Socket(HOST, puerto);
 
            ou2 = new DataOutputStream(sc.getOutputStream());
            ou2.writeUTF(mensaje);//se lanza el mensaje al servidor
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
