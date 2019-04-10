/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaclienteservidor2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class Servidor {
    
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket servidor =null;
        Socket sc = null;
        ObjectOutputStream ou;
        ObjectInputStream in;
        DataInputStream in2;
        DataOutputStream ou2;
        
        final int PUERTO = 12345;
        
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado..");
            
            while(true){
                sc = servidor.accept();//se queda a la espera
                System.out.println("Cliente conectado....");
                //in = new ObjectInputStream(sc.getInputStream());
                //ou = new ObjectOutputStream(sc.getOutputStream());
                in2 = new DataInputStream(sc.getInputStream());
                ou2 = new DataOutputStream(sc.getOutputStream());
                
                String ms = in2.readUTF();
                System.out.println(ms);
                //ArrayList<Usuario> listaRecibida =null;
//                Usuario user = null;
//                try {
//                    //listaRecibida = (ArrayList<Usuario>) in.readObject();
//                    user = (Usuario)in.readObject();
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                //se muestra la lista recibida
                //for (Usuario s: listaRecibida){
                //    System.out.println("User: "+s.getNombre()+" Pass: "+s.getPass());
                //}
                 //System.out.println("User: "+user.getNombre()+" Pass: "+user.getPass());
                
                //ArrayList<Usuario> listaEnviada = new ArrayList();
                //listaEnviada.add(new Usuario("user1", "pass1"));
                //listaEnviada.add(new Usuario("user2", "pass2"));
                //listaEnviada.add(new Usuario("user3", "pass3"));
                
                //ou.writeObject(new Usuario("user3", "pass3"));
                ou2.writeUTF("mensaje2");
                sc.close();
                System.out.println("Cliente desconectado...");
                
                
            
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }
    
    
    
    
}
