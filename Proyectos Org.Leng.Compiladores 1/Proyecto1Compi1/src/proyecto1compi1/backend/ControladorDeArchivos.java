/*
 * Clase para controlar archivos lectura/escritura
 */
package proyecto1compi1.backend;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class ControladorDeArchivos {
        private static File arch=null;
        public ControladorDeArchivos(){
                
        }
        public String cargarArchivo(File file) {
            String aux="";   //variable auxiliar de texto
            String texto=""; //variable que almacenara el texto
            try {
                    /*recorremos el archivo, lo leemos y enviamos el texto
                     */
                    if(file!=null)  {     
                            FileReader archivos=new FileReader(file);
                            BufferedReader lector=new BufferedReader(archivos);
                            while((aux=lector.readLine())!=null) {
                                    texto+= aux+ "\n";
                            }
                            lector.close();//se cierra el flujo
                            arch=file;// se almacena el archivo abierto para posterior uso
                    }    
            }
            catch(IOException ex) {
                    JOptionPane.showMessageDialog(null,ex+"" +
                       "\nNo se ha encontrado el archivo",
                             "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
            }
            return texto;//El texto se almacena en el JTextArea a enviar u otro componente
        
        }
        
        //metodo para leer archivos , devuelve listado con cada linea del archivo
        public static String leerArchivo(String path){
                String textos = "";
                try{
                        File archivo = new File(path);
                        Scanner lectura = new Scanner(archivo);
                        while (lectura.hasNext()) {
                                textos+=(lectura.nextLine()+"\n");
                        }
                }catch(FileNotFoundException ex){
                        System.out.println("No se encontró el archivo");
                }
                return textos;
        }
        //metodo para escribir en un archivo
        public void escrituraBasica(String path,String nombreArchivo, String parametro) {
                FileWriter escritor = null;
                try {
                        File directionTemp = new File(path);
                        // Make Folder Si no esta creada la carpeta se crea
                        if (!directionTemp.exists()) {
                            directionTemp.mkdirs();
                            
                        }
                        //para escribir texto se usa un objeto especial que envia los caracteres al flujo
                        escritor = new FileWriter(new File(path+"/"+nombreArchivo));
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
        
        public void eliminarCarpeta(File pArchivo) {
            
            if (!pArchivo.exists()) { return; }

            if (pArchivo.isDirectory()) {
                for (File f : pArchivo.listFiles()) {
                    eliminarCarpeta(f);  }
            }
            pArchivo.delete();
        } // Cerramos funcion. 
        
        public static void agregarNuevoUsuario(String contenido){
		//éste método permite escribir si no existe y actualizar (agregar) si existe
		//  se crea pw como un nuevo escritor, que utiliza una bufferización del archivo, el "true" activa la edición y se coloca al final  
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/BaseDatos/usuarios.txt", true)))) {
			pw.println(contenido);
		}catch (IOException e) {
			System.err.println(e);
		}		
	}	

            public File getArch() {
                    return arch;
            }

            public void setArch(File arch) {
                    this.arch = arch;
            }

    }
