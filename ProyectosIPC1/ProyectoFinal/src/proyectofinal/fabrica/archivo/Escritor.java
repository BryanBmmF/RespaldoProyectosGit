/*
 * Clase para Escribir en Archivos
 */
package proyectofinal.fabrica.archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class Escritor implements Serializable {
    
    //metodo para escribir en un archivo
    public void escrituraBasica(String path,String parametro) {
        FileWriter escritor = null;
            try {
                //para escribir texto se usa un objeto especial que envia los caracteres al flujo
		escritor = new FileWriter(new File(path));
		escritor.append(parametro);
            }catch (IOException e) {
		System.out.println("============== error escribiendo en archivo");
            }finally {
		try {
                    escritor.close();
		}catch (IOException ex) {
                    System.out.println("========no se pudo cerrar archivo");
		}
            }
    }
    //metodo para escribir instrucciones
    public void escrituraLinea(String parametro){
         File archivo;
         //metodos Writer para escribir
         FileWriter escribir;
         PrintWriter linea;
         
         
         archivo= new File("src/Instrucciones.txt");
         //verifica si existe
         if(!archivo.exists()){
             try{
                archivo.createNewFile();
                escribir= new FileWriter(archivo,true);
                linea= new PrintWriter(escribir);
                //escribiendo
                linea.println(parametro);
                linea.close();
                escribir.close();
             }
             catch(IOException ex){
                 //error en existencia
                 JOptionPane.showMessageDialog(null, "No se han podido leer la instrucciones");
             
             }          
         
         }
         else{
              try{//cracion de archivo
                archivo.createNewFile();
                escribir= new FileWriter(archivo,true);
                linea= new PrintWriter(escribir);
                //escibiendo
                linea.println(parametro);
                linea.close();
                escribir.close();
             }
             catch(IOException ex){
                 //error en existencia
                 JOptionPane.showMessageDialog(null, "No se han podido leer la instrucciones");
             
             }
                     
         }               
    }
    
}
