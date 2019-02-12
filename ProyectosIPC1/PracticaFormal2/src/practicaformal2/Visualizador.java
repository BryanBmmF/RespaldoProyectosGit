/*
 * Clase que permite Visualizar los archivos dentro del ordenador y seleccionar uno
 */
package practicaformal2;

import javax.swing.JFileChooser;

/**
 *
 * @author bryan
 */
public class Visualizador {
    
    private static String nombreArchivo,ruta;
    
    public Visualizador(){
    
    }
    public void CargarArchivo(){
        
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
