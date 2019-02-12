/*
 * Clase lectora de lineas de Instruccion del Archivo que se pasa como parametro
 */
package practicaformal2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class Lector {
    private static String instruccion="";
    
    public void lecturaDeInstruccion(String path) {
    try{    
        //Declaracion de Lector de Archivo
        FileReader lector = null;
        //Declaracion de Buffer Intermediario
        BufferedReader buffer = null;
        
            //Intentando leer el Archivo de instrucciones
            try {
                lector = new FileReader(new File(path));
                //Nuevo Buffer(almacenamiento intermediario)para una mejor lectura
		buffer = new BufferedReader(lector);
		String linea = buffer.readLine();//metodo de lectura
                    while (linea != null) {
                        
                        //imprimiendo texto
                        System.out.println("\n"+linea);
                        
                        //instanciando nuevo objeto interprete
                        Interprete interprete = new Interprete();
                        System.out.println("******************************************************");
                        interprete.reconocedor(linea);
                        System.out.println("\n******************************************************");
                                              
                        linea = buffer.readLine();
                                                
                    }
            //captura de posibles excepciones      
            } catch (EOFException ex) {
                    System.out.println("Lectura Completada con Exito");
            } catch (IOException ex) {
                    System.out.println("Surgio una Anomalia al intentar leer el Archivo");
            } finally {
                    try {
			buffer.close();
                    } catch (IOException ex) {
				System.out.println("No se completo el cierre");
                        }
		}
        }
    catch(NullPointerException ex){
        System.out.println("No se a seleccionado ningun archivo para procesar");
        } 
    }
    //Buscador de archivos tipo Object
    public boolean buscarArchivo(String path){   
        //se procede a la busqueda del objeto dentro de los archivos     
        boolean encontrada= false;
        File file = new File(path);
            try (FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
                           
                    System.out.println("\n Este Archivo ya se encuentra en el HDD: ");
                           
                    encontrada= true;
                }catch (IOException e) {
                    System.out.println("Este Archivo ahun no existe en HDD: ");
                    //e.printStackTrace();
                    encontrada= false;
                }
        return encontrada;// retorna el valor true o false
    }
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
         
         
         archivo= new File("Instrucciones.txt");
         //verifica si existe
         if(!archivo.exists()){
             try{
                archivo.createNewFile();
                escribir= new FileWriter(archivo,true);
                linea= new PrintWriter(escribir);
                //escibiendo
                linea.println(parametro);
                linea.close();
                escribir.close();
             }
             catch(IOException ex){
                 //erorr en existencia
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
    //lectura de parametros y creacion de archivo
    public String lecturaBasicaDeArchivo(String path) {
        try{
	FileReader lector = null;
	BufferedReader buffer = null;
            try {
		lector = new FileReader(new File(path));
			
		//la lectura de archivos de texto necesita de un buffer (almacenamiento intermedio)
		//para una mejor lectura
		buffer = new BufferedReader(lector);
		String data = buffer.readLine();//el buffer tiene diferentes metodos de lectura
                    while (data != null) {
                        System.out.println(data);
                        instruccion=data;
                        data = buffer.readLine();
                                
                    }
                        
            }catch (EOFException ex) {
		System.out.println("Lectura finalizada");
            }catch (IOException ex) {
		System.out.println("No se puede leer archivo");
            }finally {
		try {
                    buffer.close();
		}catch (IOException ex) {
                    System.out.println("========no se pudo cerrar archivo");
		}
            }
        
        }
        catch(NullPointerException ex){
        System.out.println("No se a seleccionado ningun archivo para procesar");
        }
        return instruccion;
    }
    //buscador de archivos tipo Data
    public boolean buscarArchivo2(String path){   
        //se procede a la busqueda de la solicitud dentro de los archivos     
        boolean encontrada= false;
        File file = new File(path);
		try (FileInputStream fileInputStream = new FileInputStream(file);
			   DataInputStream inputStream = new DataInputStream(fileInputStream);) {
                           
                           System.out.println("\n Este Archivo ya se encuentra en el HDD: ");
                           
                           encontrada= true;
		} catch (IOException e) {
			System.out.println("Este Archivo ahun no existe en HDD: ");
			//e.printStackTrace();
                        encontrada= false;
		}
        return encontrada;// retorna el valor true o false
    }
    public String AbrirTexto(String As){
        FileInputStream entrada;
        String contenido="";
        
        try{
            entrada= new FileInputStream(new File(As));
            int asci;
            while((asci= entrada.read())!=-1){
                char caracter=(char)asci;
                contenido+=caracter;
            
            }
        }
        
        catch(Exception e){
        
        }
        return contenido;
    }
    
}
