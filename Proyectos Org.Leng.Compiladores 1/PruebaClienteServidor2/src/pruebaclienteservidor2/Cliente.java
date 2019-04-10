/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaclienteservidor2;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class Cliente {
    public static void main(String[] args) {
       final String HOST = "localhost";
       final int PUERTO = 12345;
       ObjectOutputStream ou;
       ObjectInputStream in;
       
        DataInputStream in2;
        DataOutputStream ou2;
       
        try {
            Socket sc = new Socket(HOST, PUERTO);
            ///in = new ObjectInputStream(sc.getInputStream());
            //ou = new ObjectOutputStream(sc.getOutputStream());
            
            in2 = new DataInputStream(sc.getInputStream());
            ou2 = new DataOutputStream(sc.getOutputStream());
            
            //ArrayList<Usuario> listaEnviar = new ArrayList();
            //listaEnviar.add(new Usuario("user4", "pass4"));
            //listaEnviar.add(new Usuario("user5", "pass5"));
            //listaEnviar.add(new Usuario("user6", "pass6"));
            
            //ou.writeObject(new Usuario("user4", "pass4"));//se envia al servidor
            ou2.writeUTF("mensaje desde el Cliente");
            String ms = in2.readUTF();
            System.out.println(ms);
            
            //List<String> listaRecbir = new ArrayList();
            
           //ArrayList<Usuario> listaRecbir = null;
//           Usuario user =null;
//           try {
//               //listaRecbir = (ArrayList<Usuario>) in.readObject();
//               user = (Usuario)in.readObject();
//           } catch (ClassNotFoundException ex) {
//               Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
//           }
            //for (Usuario s: listaRecbir){
            //        System.out.println("User: "+s.getNombre()+" Pass: "+s.getPass());
            //    }
            
            //System.out.println("User: "+user.getNombre()+"  Pass:"+user.getPass());
            
            sc.close();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }
    
}
