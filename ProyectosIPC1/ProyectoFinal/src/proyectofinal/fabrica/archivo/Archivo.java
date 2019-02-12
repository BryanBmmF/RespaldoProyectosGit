/*
 * Clase Archivo para el ingreso de datos
 */
package proyectofinal.fabrica.archivo;

import java.io.File;
import java.io.Serializable;
import javax.swing.JFileChooser;

/**
 *
 * @author bryan
 */
public class Archivo implements Serializable{
    
    private static String nombreArchivo,ruta;
    
    public Archivo(){
    
    }
    //metodo buscador de archivo en el equipo mediante FileChooser
    public void buscar(){
    
        //creacion del visualizador
        JFileChooser fileChosser = new JFileChooser();
        int opcion= fileChosser.showOpenDialog(null);
        
        if(opcion==JFileChooser.APPROVE_OPTION){
            
            //obtener el nombre del archivo seleccionado
            nombreArchivo= fileChosser.getSelectedFile().getName();
            
            //obtener la ruta del archivo seleccionado
            ruta= fileChosser.getSelectedFile().getPath();
            
            System.out.println("Nombre del Archivo: "+nombreArchivo);
            System.out.println("Ruta del Archivo: "+ruta);
                        
        }
    }
    //metodo buscador de un archivo existente
    public boolean buscarExistente(String path){
           //se procede a la busqueda del objeto dentro de los archivos     
        boolean encontrada= false;
        File file = new File(path);
            //verifica si existe el archivo
            if(file.exists()){
                encontrada= true;
                System.out.println("\n Este Archivo ya se encuentra en el HDD: ");
            }
            else{
                System.out.println("Este Archivo ahun no existe en HDD: ");
            }
            return encontrada;
        
    }
    //creacion de metodos accesores para nonbre de archivo y ruta
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}
