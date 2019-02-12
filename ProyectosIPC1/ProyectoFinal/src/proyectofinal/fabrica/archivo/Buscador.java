/*
 * Clase encargada de buscar diferentes tipos de archivos
 */
package proyectofinal.fabrica.archivo;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author bryan
 */
public class Buscador {
    
    //Buscador de archivos
    public boolean buscarArchivo(String path){   
        //se procede a la busqueda del objeto dentro de los archivos     
        boolean encontrada= false;
        File file = new File(path);
            try  (FileInputStream fileInputStream = new FileInputStream(file);
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
    
    //buscador de archivos tipo Data
    public boolean buscarArchivo2(String path){   
        //se procede a la busqueda dentro de los archivos     
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
    
}
