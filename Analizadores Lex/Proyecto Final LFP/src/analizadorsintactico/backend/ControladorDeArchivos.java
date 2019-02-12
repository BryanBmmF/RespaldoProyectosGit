/*
 * Clase para controlar archivos lectura/escritura
 */
package analizadorsintactico.backend;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        public void exportarAarchivo(File file,String texto,String exten){ //recibir tambien la extension
                try {
                    if(file !=null) {
                            /*guardamos el archivo y le damos el formato directamente,
                            * si queremos que se guarde en formato doc lo definimos como .docx*/
                            FileWriter  save=new FileWriter(file+exten);
                            save.write(texto);
                            save.close();
                            arch=file;
                            JOptionPane.showMessageDialog(null,
                                 "El archivo se a guardado Exitosamente",
                                     "Información",JOptionPane.INFORMATION_MESSAGE);
                    }
             }
            catch(IOException ex) {
                    JOptionPane.showMessageDialog(null,
                        "Su archivo no se ha guardado",
                        "Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        
        }
        public void exportarAarchivo2(File file,String texto,String exten){ //recibir tambien la extension
                try {
                    if(file !=null) {
                            /*guardamos el archivo y le damos el formato directamente,
                            * si queremos que se guarde en formato doc lo definimos como .docx*/
                            FileWriter  save=new FileWriter(file+exten);
                            save.write(texto);
                            save.close();
                            JOptionPane.showMessageDialog(null,
                                 "El archivo se a guardado Exitosamente",
                                     "Información",JOptionPane.INFORMATION_MESSAGE);
                    }
             }
            catch(IOException ex) {
                    JOptionPane.showMessageDialog(null,
                        "Su archivo no se ha guardado",
                        "Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        
        }
         public void guardarCambiosArchivo(String rutaArhivo,String texto){ 
                try {
                    if(rutaArhivo !=null) {
                            /*guardamos el archivo y le damos el formato directamente,
                            * si queremos que se guarde en formato doc lo definimos como .docx*/
                            FileWriter  save=new FileWriter(rutaArhivo);
                            save.write(texto);
                            save.close();
                            JOptionPane.showMessageDialog(null,
                                 "El archivo se a guardado Exitosamente",
                                     "Información",JOptionPane.INFORMATION_MESSAGE);
                    }
             }
            catch(IOException ex) {
                    JOptionPane.showMessageDialog(null,
                        "Su archivo no se ha guardado",
                        "Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        
        }
        //metodo para exportar archivos pdf
        public void exportarPDF(File file, String contenido){
                try{
                        FileOutputStream archivo= new FileOutputStream(file+"pdf");
                        Document doc= new Document();// se declara un objeto document

                        PdfWriter.getInstance(doc, archivo);//se obtiene la instancia para escribir el archivo
                        doc.open();// se abre el flojo
                        doc.add(new Paragraph(contenido));// se agrega el contenido

                        doc.close();//se cierra el flujo

                        JOptionPane.showMessageDialog(null, "Se Exporto el PDF correctamente!!");
            
                }
                catch(Exception e){
                        System.out.println("Error al exportar pdf");
                }
        }

        public File getArch() {
                return arch;
        }

        public void setArch(File arch) {
                this.arch = arch;
        }

}
