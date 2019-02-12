/*
 * Clase que lleva el control de la materia prima dentro del area de produccion
 */
package proyectofinal.fabrica.produccion;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.archivo.Escritor;
import proyectofinal.fabrica.archivo.Lector;
import static proyectofinal.fabrica.produccion.Mueble.rutaContUso;
/**
 *
 * @author bryan
 */
public class MateriaPrima implements Serializable{
    
    private int contadorMP=0;
    private String tipo;
    private String nombrePieza;
    private double costo;
    private int cantidad;
    public static final String ruContExistencia="src/materiaPrima/cont";
    public static final String ruContGeneral="src/materiaPrima/contGen";
    public static final String rutaMP="src/materiaPrima/";
    public static final String extenContMP= ".cont";
    public static final String extenMP= ".map";
    private ArrayList<String> revision;
    private Escritor escritor;
    private Lector lector;
    private Archivo archivoPieza;
    private static  MateriaPrima pieza;
    
    //metodo constructor de Materia Prima
    public MateriaPrima(String tipo, double costo){
        this.costo=costo;
        this.tipo=tipo;
        
        this.escritor=new Escritor();
        this.lector=new Lector();
        this.archivoPieza= new Archivo();
        this.revision= new ArrayList<String>();
        this.pieza= new MateriaPrima();
        
    }
    // sobrecarga de constructor
    public MateriaPrima(String tipo){
        this.tipo=tipo;
    }
    public MateriaPrima(){
        
        this.escritor=new Escritor();
        this.lector=new Lector();
        this.archivoPieza= new Archivo();

    }
    
    public void mostrarDatos(){
    
        System.out.println("\n"+tipo+"\n"+costo);
    }
    //metodo que ingresa una nueva pieza desde form
    public void ingresarNuevaPieza(){
        if(archivoPieza.buscarExistente(rutaMP+tipo+extenMP)){
            JOptionPane.showMessageDialog(null, "La pieza no se ha podido crear \n"
                    + "debido a que ya existe en la fabrica ");
        }
        else{
            generarPieza(rutaMP, tipo, extenMP);
            JOptionPane.showMessageDialog(null, "Pieza Generada con Exito!!");
            //y se crea el contador con valor inicial para el archivo
            escritor.escrituraBasica(ruContExistencia+tipo+extenContMP, String.valueOf(contadorMP)); 
            escritor.escrituraBasica(ruContGeneral+tipo+extenContMP, String.valueOf(contadorMP));
        }
    }
    //metodo con la funcion de eliminar piezas usadas
    public void restaPiezasDeContador(String nombre, int numero){
        String contPieza;
        Lector lc= new Lector();
        //se llama al arhivo que almacena las piezas
        contPieza=lc.lecturaBasicaDeArchivo(ruContExistencia+nombre+extenContMP);
        int contadorLeido= Integer.parseInt(contPieza);
        
        contadorLeido=contadorLeido-numero;
        Escritor escrit= new Escritor();
        escrit.escrituraBasica(ruContExistencia+nombre+extenContMP, String.valueOf(contadorLeido));              
    
    }
    public void eliminarPiezas(String nombrePieza, int cantidad){
        String contPiezasEnUso;
        Lector lc= new Lector();
        //se llama al arhivo que lleva el conteo de piezas en uso
        contPiezasEnUso=lc.lecturaBasicaDeArchivo(rutaContUso+nombrePieza+extenContMP);
        int contadorLeido= Integer.parseInt(contPiezasEnUso);
        
        for (int i = 0; i < cantidad; i++) {
            
            contadorLeido++;
            File archivo= new File(rutaMP+nombrePieza+String.valueOf(contadorLeido)+"."+nombrePieza+"MT");
            archivo.delete();
            
        }
        Escritor escrit= new Escritor();
        escrit.escrituraBasica(rutaContUso+nombrePieza+extenContMP, String.valueOf(contadorLeido)); 
    }
    public void retirarPiezas(String nombrePieza,int numRetiro){
        String contPieza;
        Lector lc= new Lector();
        //se llama al arhivo que almacena las piezas
        contPieza=lc.lecturaBasicaDeArchivo(ruContExistencia+nombrePieza+extenContMP);
        int contadorLeido= Integer.parseInt(contPieza);
            if(contadorLeido==0){
                JOptionPane.showMessageDialog(null, "No se puede retirar esta cantidad por que ya no hay en existencia");
            }
            else if(contadorLeido<numRetiro){                    
                    JOptionPane.showMessageDialog(null, "La cantidad que se desea retirar es mayor a la disponible \n"
                            + "en existencia solo hay "+contadorLeido+" piezas");
                }
                else{
                    restaPiezasDeContador(nombrePieza, numRetiro);
                    eliminarPiezas(nombrePieza, numRetiro);
                    JOptionPane.showMessageDialog(null, "Retiro completado!!");
                    
                    
                }
    }
    
    public void modificarInfoPiezas(){
    
    }
    public void consultarPiezas(){
    
    }
    public void consultarmuebles(){
    
    }
    public void registrarPiezas(int cantidad){
        String contPieza;
        String contPiezaGen;
            //si existe se llama a su contador                     
            contPieza=lector.lecturaBasicaDeArchivo(ruContExistencia+tipo+extenContMP);
            contPiezaGen=lector.lecturaBasicaDeArchivo(ruContGeneral+tipo+extenContMP);
                //se convierte los contadores recuperados
                int contadorLeido= Integer.parseInt(contPieza);
                int contadorLeidoGen= Integer.parseInt(contPiezaGen);
            
                    for (int i = 0; i < cantidad; i++) {
                        contadorLeido++;
                        contadorLeidoGen++;
                        //se genera la pieza
                        generarPieza(rutaMP,tipo+String.valueOf(contadorLeidoGen),"."+tipo+"MT"); 
                
                    }
            //se guardan lo contadores   
            escritor.escrituraBasica(ruContExistencia+tipo+extenContMP, String.valueOf(contadorLeido));
            escritor.escrituraBasica(ruContGeneral+tipo+extenContMP, String.valueOf(contadorLeidoGen));    
    }
    //metodo creador de piezas
    public void revizarPieza(){
        String contPieza;
        String contPiezaGen;
        //se verifica si ya existe el Archivo pieza
            if(archivoPieza.buscarExistente(rutaMP+tipo+extenMP)){
                System.out.println("La pieza Si existe y se agregara mas");
            
                //si existe se llama a su contador                     
                contPieza=lector.lecturaBasicaDeArchivo(ruContExistencia+tipo+extenContMP);
                contPiezaGen=lector.lecturaBasicaDeArchivo(ruContGeneral+tipo+extenContMP);
            }
            else{
                //sino se crea la pieza en la fabrica
                generarPieza(rutaMP,tipo,extenMP); 
                //y se crea el contador con valor inicial para el archivo
                escritor.escrituraBasica(ruContExistencia+tipo+extenContMP, String.valueOf(contadorMP)); 
                escritor.escrituraBasica(ruContGeneral+tipo+extenContMP, String.valueOf(contadorMP));
                //se llama a su contador                                     
                contPieza=lector.lecturaBasicaDeArchivo(ruContExistencia+tipo+extenContMP);
                contPiezaGen=lector.lecturaBasicaDeArchivo(ruContGeneral+tipo+extenContMP);
            }
            
            //se genera el archivo
            System.out.println("Pieza procesada");
            
            //se convierte el contador recuperado y se aumenta para generar nueva pieza
            int contadorLeido= Integer.parseInt(contPieza);
            contadorLeido++;
            int contadorLeidoGen= Integer.parseInt(contPiezaGen);
            contadorLeidoGen++;
            
            escritor.escrituraBasica(ruContExistencia+tipo+extenContMP, String.valueOf(contadorLeido));
            escritor.escrituraBasica(ruContGeneral+tipo+extenContMP, String.valueOf(contadorLeidoGen));
            
            //se genera la pieza
            generarPieza(rutaMP,tipo+String.valueOf(contadorLeidoGen),"."+tipo+"MT"); 
               
            
    }
    //metodo generador de archivos de Materia prima 
    public void generarPieza(String ruta,String nombre,String exten){
        //metodo para generar Piezas
        File file = new File(ruta+nombre+exten);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		}
            //se guarda la instruccion
            escritor.escrituraLinea("Se ha intruducido Materia Prima "+tipo+" con valor de Q."+costo);
            
        
    }
    public static List<MateriaPrima> listaPiezas() {
        
        List<MateriaPrima> piezas = new ArrayList<MateriaPrima>();
        MateriaPrima mate= new MateriaPrima();
            //se hace referencia a una carpeta
            File folder= new File("src/materiaPrima");
            
            //se verifica el directorio
            if(folder.isDirectory()){
                //se hace una lista de todos los archivos contenidos
                String[] archivos= folder.list();
                    //se realiza la recuperacion necesaria de los archivos de interes
                    for(String nombreArch: archivos){
                        //se verifica la extension
                        if(nombreArch.endsWith(extenMP)){
                            //se crea el contenedor del archivo
                            File archivoLeer= new File("src/materiaPrima/"+nombreArch);                          
                            //se intenta crear el flujo de entrada para la lectura
                            try(FileInputStream fileStream= new FileInputStream(archivoLeer);
                                    ObjectInputStream inputObject = new ObjectInputStream(fileStream);){
                                        //se castea el objeto leido y se agrega a la lista
                                        try{
                                            mate=((MateriaPrima)inputObject.readObject());
                                            piezas.add(new MateriaPrima(mate.getTipo(),mate.getCosto()));
                                        }
                                        catch(InvalidClassException e){
                            }
                            //se capturan las Excepciones                   
                            }catch(IOException e){
                                System.out.println("Error de conexion con el archivo");
                                e.printStackTrace();
                            
                            }
                            catch(ClassNotFoundException e){
                                System.out.println("El objeto no tiene la forma requerida");
                                
                            }
                            
                        }
                        
                    
                    }
            
            }
        return piezas;
}
    //metodos accesores de MatPrima

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String anterior = this.tipo; 
        this.tipo = tipo;
         propertyChangeSupport.firePropertyChange("tipo", anterior, tipo); 
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        double anterior = this.costo; 
        this.costo = costo;
        propertyChangeSupport.firePropertyChange("costo", anterior, costo); 
    }
    
    //metodos para cambio de propiedad de materia prima
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    
}
