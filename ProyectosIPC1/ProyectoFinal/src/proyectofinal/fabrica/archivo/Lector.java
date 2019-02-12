/*
 * Clase para leer Archivos de entrada
 */
package proyectofinal.fabrica.archivo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Lector implements Serializable{
    
    private static String instruccion="";
    
    //metodo de lectura de Archivo linea por linea
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
                                              
                        linea = buffer.readLine();//se lee la linea
                                                
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
        ex.printStackTrace();
        } 
    }  
    //metodo retorno String para lectura de datos de una archivo linea a linea
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
            //excepciones posibles       
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
    public String abrirInstrucciones(String As){
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
