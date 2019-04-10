/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaclienteservidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class Servidor extends Conexion{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            //salidaCliente = new DataOutputStream(cs.getOutputStream());
            salidaObCliente = new ObjectOutputStream(cs.getOutputStream());
            listaSalidaCliente = new ArrayList();

            //Se le envía un mensaje al cliente usando su flujo de salida
            //salidaCliente.writeUTF("Petición recibida y aceptada");
            listaSalidaCliente.add("Lista Recibida y Aceptada desde el Cliente");
            salidaObCliente.writeObject(listaSalidaCliente);

            //Se obtiene el flujo entrante desde el cliente
            //BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            ObjectInputStream entradaOb = new ObjectInputStream(cs.getInputStream());
            
//            listaMensajesServidor = (List<String>)entradaOb.readObject();
//            //Se muestra por pantalla el mensaje recibido
//                for(String s: listaMensajesServidor){
//                    System.out.println(s);
//                }

//            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
//            {
//                //Se muestra por pantalla el mensaje recibido
//                System.out.println(mensajeServidor);
//            }
            while((listaMensajesServidor = (List<String>)entradaOb.readObject()) != null) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                for(String s: listaMensajesServidor){
                    System.out.println(s);
                }
            }
            

            System.out.println("Fin de la conexión");

            ss.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
