/*
 Clase mueble y sus caracteristicas 
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
import java.util.Vector;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.archivo.Escritor;
import proyectofinal.fabrica.archivo.Lector;

/**
 *
 * @author bryan
 */
public class Mueble implements Serializable{
    //miembros privados de un mueble
    private String codigo;
    private String tipo;
    private String nombreNuevoMueble;
    private double precioNuevoMueble;
    private ArrayList<String> revision;
    private Archivo archivo;
    private Lector lector;
    private Escritor escritor;
    private MateriaPrima pieza;
    public static final String rutaContUso="src/materiaPrima/contUso";
    public static final String rutaMueble="src/muebles/";
    public static final String extenMueble=".mbl";
    
    
    public Mueble(String nombreMueble,double precio){
    
        this.nombreNuevoMueble=nombreMueble;
        this.precioNuevoMueble=precio;
        
        this.escritor= new Escritor();
        this.revision= new ArrayList<String>();
        
    }
    //sobrecarga de constructor
    public Mueble(String nombreMueble){
    
        this.nombreNuevoMueble=nombreMueble;
    }
    public Mueble(){
        this.archivo= new Archivo();
        this.lector= new Lector();
        this.pieza= new MateriaPrima();
        this.escritor= new Escritor();
    }
    public void mostrarDatos(){
    
        System.out.println("\n"+nombreNuevoMueble+"\n"+precioNuevoMueble);
    }
    
    //metodo para validar un usuario
    public void validarMueble(){
        //se crea la instancia de archivo Mueble y se busca
        Archivo archivoMueble= new Archivo();
            
            if (archivoMueble.buscarExistente(rutaMueble+ nombreNuevoMueble + extenMueble)) {
                revision.add("Error");
            } 
            else {
            //revision de errores en formato de parametros recibidos

            }
            //comprobando si existe un error en el mueble
            int errorMueble= revision.indexOf("Error");
                if(errorMueble>=0){
                    System.out.println("\n mueble no procesado");
                }
                else{
                    System.out.println("mueble procesado ");
                    //se genera
                    generarMueble(rutaMueble,nombreNuevoMueble,extenMueble);       
                }
            
    }
    //metodo generador de archivo de mueble nuevo
    public void generarMueble(String ruta,String nombre,String exten){
        //metodo para generar Usuarios
        File file = new File(ruta+nombre+exten);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		}
             //se guarda la instruccion
             escritor.escrituraLinea("Se introdujo el mueble "+nombreNuevoMueble+" con valor de Q."+precioNuevoMueble);
            
        
    }
    public double generarCostoYEliminarPiezas(String nombrePieza, int numero){
        int contInicial=0;
        double costoMueble=0;
         //se llama al contador de piezas usadas o se crea el nuevo contador
            String contPiezasUsadas;
            if(archivo.buscarExistente(rutaContUso+nombrePieza+".cont")){
                //si existe se llama a su contador y se sigue el conteo                     
                contPiezasUsadas=lector.lecturaBasicaDeArchivo(rutaContUso+nombrePieza+".cont");             
            }
            else{
                //sino se crea el contador con valor inicial para el archivo
                escritor.escrituraBasica(rutaContUso+nombrePieza+".cont", String.valueOf(contInicial)); 
            
                //se llama a su contador y se sigue el conteo                                       
                contPiezasUsadas=lector.lecturaBasicaDeArchivo(rutaContUso+nombrePieza+".cont");
            }
            //se convierte el contador recuperado y se aumenta debido al nuevo ensamble
            int contadorLeido= Integer.parseInt(contPiezasUsadas);
            
            
            for (int i = 0; i < numero; i++) {
                contadorLeido++;
                // se lee el precio de cada pieza
                File archivoLeer= new File("src/materiaPrima/"+nombrePieza+contadorLeido+"."+nombrePieza+"MT");
                //se intenta crear el flujo de entrada para la lectura
                    try(FileInputStream fileStream= new FileInputStream(archivoLeer);
                            ObjectInputStream inputObject = new ObjectInputStream(fileStream);){
                                //se castea el objeto leido y se almacena en objeto pieza
                                pieza=((MateriaPrima)inputObject.readObject());
                                //se lleva la suma del costo por pieza
                                costoMueble+=pieza.getCosto();                            
                                //se van eliminando las piezas usadas
                                archivoLeer.delete();
                    //se capturan las Excepciones                   
                    }catch(IOException e){
                        System.out.println("Error de conexion con el archivo");
                        e.printStackTrace();
                            
                    }catch(ClassNotFoundException e){
                        System.out.println("El objeto no tiene la forma requerida");
                                
                }
                  
        }
            
        //se guarda el contador
        escritor.escrituraBasica(rutaContUso+nombrePieza+".cont", String.valueOf(contadorLeido));
        return costoMueble;
    }
    
    public static List<Mueble> listaMuebles() {
        
        List<Mueble> muebles = new ArrayList<Mueble>();
        Mueble mueble= new Mueble();
            //se hace referencia a una carpeta
            File folder= new File("src/muebles");
            
            //se verifica el directorio
            if(folder.isDirectory()){
                //se hace una lista de todos los archivos contenidos
                String[] archivos= folder.list();
                    //se realiza la recuperacion necesaria de los archivos de interes
                    for(String nombreArch: archivos){
                        //se verifica la extension
                        if(nombreArch.endsWith(extenMueble)){
                            //se crea el contenedor del archivo
                            File archivoLeer= new File("src/muebles/"+nombreArch);                          
                            //se intenta crear el flujo de entrada para la lectura
                            try(FileInputStream fileStream= new FileInputStream(archivoLeer);
                                    ObjectInputStream inputObject = new ObjectInputStream(fileStream);){
                               
                                        //se castea el objeto leido y se agrega a la lista
                                        try{
                                            mueble=((Mueble)inputObject.readObject());
                                            muebles.add(new Mueble(mueble.getNombreNuevoMueble(),mueble.getPrecioNuevoMueble()));
                                            
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
        return muebles;
    }
    //retorna lista con nombre de todos los muebels existentes
    public Vector<String> nombreMuebles(){
        Vector<String> nombreMuebles= new Vector<String>();
        List<Mueble> muebles = new ArrayList<Mueble>();
        muebles= listaMuebles();
            
            for(Mueble mueble: listaMuebles()){
                
                nombreMuebles.add(mueble.getNombreNuevoMueble());
                System.out.println("nombre: "+mueble.getNombreNuevoMueble());
            }
        
        return nombreMuebles;
    }
    
    
    //metodos accesores de mueble

    public String getNombreNuevoMueble() {
        return nombreNuevoMueble;
    }

    public void setNombreNuevoMueble(String nombreNuevoMueble) {
        String anterior = this.nombreNuevoMueble; 
        this.nombreNuevoMueble = nombreNuevoMueble;
        propertyChangeSupport.firePropertyChange("nombre", anterior, nombreNuevoMueble); 
    }

    public double getPrecioNuevoMueble() {
        return precioNuevoMueble;
    }

    public void setPrecioNuevoMueble(double precioNuevoMueble) {
        double anterior = this.precioNuevoMueble; 
        this.precioNuevoMueble = precioNuevoMueble;
        propertyChangeSupport.firePropertyChange("precioMueble", anterior, precioNuevoMueble); 
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
