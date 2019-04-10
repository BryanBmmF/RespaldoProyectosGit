/*
 * Clase Servidor
 */
package proyecto1compi1.backend.app;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1compi1.backend.sitios.BDSitios;

/**
 *
 * @author bryan
 */
public class Servidor extends Observable implements Runnable{

    private int puerto;
    private ServerSocket servidor;
    private Socket sc;
    private DataInputStream in2;

    public Servidor(int puerto) {
        this.puerto = puerto;
        this.servidor =null;
        this.sc = null;
    }
    
    
    @Override
    public void run() {
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado..");
            
            //levantar sitios a memoria
            BDSitios bd = BDSitios.getInstance();
            bd.levantarBaseDatos();//se levanta la base de datos
            bd.actualizarBd();//se vuelve a guardar lo que se acaba de levantar
            
            //listar sitios creados
            bd.listarSitios();
            
            while(true){
                sc = servidor.accept();//se queda a la espera
                System.out.println("Cliente conectado....");
                
                in2 = new DataInputStream(sc.getInputStream());
                String ms = in2.readUTF();//se recibe el mensaje desde el cliente
                System.out.println(ms);
                
                this.setChanged();//va a canbiar algo
                this.notifyObservers(ms);//notifica a los observer el mensaje
                this.clearChanged();//lo limpia
 
                
                sc.close();
                System.out.println("Cliente desconectado...");
                
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
