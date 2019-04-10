/*
 * 
 */
package pruebaclienteservidor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Cliente cli = new Cliente(); //Se crea el cliente
            
            System.out.println("Iniciando cliente\n");
            cli.startClient(); //Se inicia el cliente
        } catch (IOException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
