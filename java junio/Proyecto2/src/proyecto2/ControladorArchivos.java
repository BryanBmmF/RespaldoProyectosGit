/*
 * Clase Archivos
 */
package proyecto2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bryan
 */

public class ControladorArchivos {
    public static final String rutaRegistroCliente="src/proyecto2/RegistroClientes/";
    public static final String rutaRegistroAbogado="src/proyecto2/RegistroAbogados/";
    
    //metodo para guardar registros de Personas como objetos
    public static void guardarPersona(String path,String nombre,String extension, Persona persona) {
	File file = new File(path+nombre+extension);
		
	try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
            outputStream.writeObject(persona);
	} catch (IOException e) {
            System.out.println("error de conexion con el archivo");
		e.printStackTrace();
	}		
    }
    //metodo para guardar registro de Venta
    public static void guardarVenta(String path,String nombre,String extension, Venta venta,int contador) {
	File file = new File(path+nombre+String.valueOf(contador)+extension);
		
	try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
            outputStream.writeObject(venta);
	} catch (IOException e) {
            System.out.println("error de conexion con el archivo");
		e.printStackTrace();
	}		
    }
    //metodo para guardar registro de Alquileres
    public static void guardarAlquiler(String path,String nombre,String extension, Alquiler alquiler,int contador) {
	File file = new File(path+nombre+String.valueOf(contador)+extension);
		
	try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
            outputStream.writeObject(alquiler);
	} catch (IOException e) {
            System.out.println("error de conexion con el archivo");
		e.printStackTrace();
	}		
    }
    //metodo para guardar registro de Autenticas
    public static void guardarAutentica(String path,String nombre,String extension, Autentica aut,int contador) {
	File file = new File(path+nombre+String.valueOf(contador)+extension);
		
	try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
            outputStream.writeObject(aut);
	} catch (IOException e) {
            System.out.println("error de conexion con el archivo");
		e.printStackTrace();
	}		
    }
    //metodo para leer registros de personas y devolver el registro leido
    public static Persona leerPersona(String path,String extension) {
        File folder = new File(path);
	if (folder.isDirectory()) {
            String[] archivos = folder.list();
            for (String nombreArchivo : archivos) {
		if (nombreArchivo.endsWith(extension)) {
                    File nuevoArchivo = new File(path+nombreArchivo);
                    try (FileInputStream fileInputStream = new FileInputStream(nuevoArchivo);
                        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
			return ((Persona) inputStream.readObject());
                    }catch (IOException e) {
                        System.out.println("error de conexion con el archivo");
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("El objeto no tiene la forma de un matchresult");
                        e.printStackTrace();
                    }
		}
            }
        }        
        return null;
    }
    //metodo para leer registros de personas y devolver una lista de las mismas
    public static List<Persona> leerPersonas(String path, String extension) {
        /**
         * Crear contenedor del folder y verificar si es directorio
         * Encontrar un listado con todos los archivos de esta carpeta
         * por cada archivo ver si termina en lo recibido como parametro
         * Si es verdadero entonces ingresarlo a la lista
         * sino no hacer nada
         **/
	File folder = new File(path);
	List<Persona> list = new ArrayList<>();
	if (folder.isDirectory()) {
            String[] archivos = folder.list();
            for (String nombreArchivo : archivos) {
		if (nombreArchivo.endsWith(extension)) {
                    File nuevoArchivo = new File(path+nombreArchivo);
                    try (FileInputStream fileInputStream = new FileInputStream(nuevoArchivo);
                        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
			list.add((Persona) inputStream.readObject());
                    }catch (IOException e) {
                        System.out.println("error de conexion con el archivo");
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("El objeto no tiene la forma de un matchresult");
                        e.printStackTrace();
                    }
		}
            }
        }        
	return list;
    }
    //Metodo para eliminar archivos
    public static void eliminarArchivo(String path,String nombre,String extension){
        File archivo= new File(path+nombre+extension);
        archivo.delete();
                
    }
    //metodo buscador de un archivo existente
    public static boolean buscarExistente(String path){
           //se procede a la busqueda dentro de los archivos     
        boolean encontrada= false;
        File file = new File(path);
            //verifica si existe el archivo
            if(file.exists()){
                encontrada= true;
            }
        return encontrada;
    }
    //metodo buscador de un registro Cliente o Abogado ya existenete 
    public static boolean validarRegistro(String path,String extension){
        //se procede a la busqueda dentro de los archivos     
        boolean registroEncontrado= true;
        File folder = new File(path);
	if (folder.isDirectory()) {
            String[] archivos = folder.list();
            for (String nombreArchivo : archivos) {
		if (nombreArchivo.endsWith(extension)) {
                   registroEncontrado=false;
		}
            }       
        }
        return registroEncontrado;
    }
    //metodo para leer archivos , devuelve listado con cada linea del archivo
    public static List<String> leerArchivo(String path){
        List<String> textos = new ArrayList<>();
        try{
            File archivo = new File(path);
            Scanner lectura = new Scanner(archivo);
            while (lectura.hasNext()) {
		textos.add(lectura.nextLine());
            }
        }catch(FileNotFoundException ex){
		System.out.println("No se encontró el archivo");
	}
        return textos;
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
    public static String lecturaBasica(String path){
        String texto="";
        try{
            File archivo = new File(path);
            Scanner lectura = new Scanner(archivo);
            while (lectura.hasNext()) {
		texto= lectura.nextLine();
            }   
	}catch(FileNotFoundException ex){
            System.out.println("No se encontró el archivo");
	}
        return texto;
    }
}
