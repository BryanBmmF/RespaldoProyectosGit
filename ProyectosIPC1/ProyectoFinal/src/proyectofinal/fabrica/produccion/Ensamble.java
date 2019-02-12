/*
 * Clase encargada de ensamblar nuevos muebles
 */
package proyectofinal.fabrica.produccion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectofinal.fabrica.archivo.Archivo;
import proyectofinal.fabrica.archivo.Escritor;
import proyectofinal.fabrica.archivo.Lector;
import proyectofinal.fabrica.usuarios.Usuario;
import proyectofinal.fabrica.ventas.AreaDeVenta;

/**
 *
 * @author bryan
 */
public class Ensamble implements Serializable{
    
    private Mueble tipoMueble,mueble;
    private Usuario nombreUsuarioEnsamble;
    private String fecha;
    private Escritor escritor;
    private ArrayList<PiezasDeMueble> listaPiezas;
    private ArrayList<String> revision;
    private Archivo archivo;
    private Lector lector;
    private MateriaPrima pieza;
    private int contadorEnsamble=0;
    private static final String rutaContEns="src/ensambles/contEnsable";
    
    //constructores
    public Ensamble(Mueble tipoMueble, Usuario nombreUsuarioEnsamble, String fecha){
    
        this.fecha= fecha;
        this.nombreUsuarioEnsamble=nombreUsuarioEnsamble;
        this.tipoMueble=tipoMueble;
        
        this.escritor= new Escritor();
        this.listaPiezas= new ArrayList<PiezasDeMueble>();
        this.archivo= new Archivo();
        this.lector= new Lector();
        this.pieza= new MateriaPrima();
        this.mueble= new Mueble();
        this.revision= new ArrayList<String>();
        
    }
    public Ensamble(){
        
    }
    public void mostrarDatos(){
    
        System.out.println("\n"+tipoMueble.getNombreNuevoMueble()+"\n"+nombreUsuarioEnsamble.getUser()+"\n"+fecha);
    }
    //metodo para el ensamble de muebles
    public void ensamblar(){ 
        int cantidadDePieza;
        double precio=0;
        System.out.println("***ENSAMBLE***");
        for(PiezasDeMueble piezas: listaPiezas){
            //se muestra cuanto se requiere de cada pieza
            System.out.println(piezas.getNumeroDePiezas()+" de "+piezas.getPieza().getTipo());
            
            //se verifica si cada pieza cuenta con la cantidad necesaria en la muebleria
            cantidadDePieza=revisarPiezasDeEnsamble(piezas.getPieza().getTipo(), piezas.getNumeroDePiezas());
                if(cantidadDePieza!=0){
                    //falta piezas 
                    revision.add("Falta Piezas");
                    revision.add(String.valueOf(cantidadDePieza)+" de "+piezas.getPieza().getTipo());
                }
                else{
                    //no hace falta piezas de este tipo                  
                }
                
        }
        //se busca en lista rvision si falta piezas
        int rev= revision.indexOf("Falta Piezas");       
        if(rev>=0){
            //no se realiza el ensamble debido a la falta de piezas
            System.out.println("Ensamble No realizado de "+tipoMueble.getNombreNuevoMueble()+" por Falta de Piezas");
                escritor.escrituraLinea("Ensamble No realizado de "+tipoMueble.getNombreNuevoMueble()+" por Falta de Piezas");      
        }
        else{          
            //se realiza el ensamble
            //se llama al contador de ensambles del mueble o se crea el nuevo contador
            String contEnsambles;
            if(archivo.buscarExistente(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont")){
                //si existe se llama a su contador y se sigue el conteo                     
                contEnsambles=lector.lecturaBasicaDeArchivo(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont");             
            }
            else{
                //sino se crea el contador con valor inicial para el archivo
                escritor.escrituraBasica(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont", String.valueOf(contadorEnsamble)); 
            
                //se llama a su contador y se sigue el conteo                                       
                contEnsambles=lector.lecturaBasicaDeArchivo(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont");
            }
            
            //se convierte el contador recuperado y se aumenta debido al nuevo ensamble
            int contadorLeido= Integer.parseInt(contEnsambles);
            contadorLeido++;
            escritor.escrituraBasica(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont", String.valueOf(contadorLeido));
            
            //se genera el ensamble
            generarEnsamble("src/ensambles/ensamble",tipoMueble.getNombreNuevoMueble()+String.valueOf(contadorLeido),".ens");
            
            //se genera el costo del mueble y se eliminan las piezas utilizadas
            for(PiezasDeMueble piezaE: listaPiezas){
                
                //se genera el costo y se eliminan las piezas usadas
                precio+=mueble.generarCostoYEliminarPiezas(piezaE.getPieza().getTipo(),piezaE.getNumeroDePiezas());
                //se procede a restar las piezas del contador
                pieza.restaPiezasDeContador(piezaE.getPieza().getTipo(),piezaE.getNumeroDePiezas());
            }
            System.out.println(">>>>El costo de fabricacion del mueble es de: "+"Q."+precio);
            
            //se registra un nuevo mueble en sala de ventas
            AreaDeVenta registrarMueble= new AreaDeVenta(new Mueble(tipoMueble.getNombreNuevoMueble()),tipoMueble.getPrecioNuevoMueble()
                    ,precio,tipoMueble.getNombreNuevoMueble()+String.valueOf(contadorLeido));
            
            registrarMueble.registrarMuebles();
            
            }
        
        
            
    }
    
    public String ensamblarMueble(){
        String identificador=null;
        int cantidadDePieza;
        
        for(PiezasDeMueble piezas: listaPiezas){
            //se verifica si cada pieza cuenta con la cantidad necesaria en la muebleria
            cantidadDePieza=revisarPiezasDeEnsamble(piezas.getPieza().getTipo(), piezas.getNumeroDePiezas());
                if(cantidadDePieza!=0){
                    //falta piezas 
                    revision.add("Falta Piezas");
                    revision.add(String.valueOf(cantidadDePieza)+" de "+piezas.getPieza().getTipo());
                }
                
        }        
            //se busca en lista revision si falta piezas
            int rev= revision.indexOf("Falta Piezas");       
                if(rev>=0){
                    String mensaje="";
                    String salto="\n";
                        for(String er: revision){           
                            mensaje= mensaje+er+salto;
                        }
                    JOptionPane.showMessageDialog(null,"Ensamble no Realizado \n"+mensaje);     
                }
                else{          
                    //se realiza el ensamble
                    //se llama al contador de ensambles del mueble o se crea el nuevo contador
                    String contEnsambles;
                        if(archivo.buscarExistente(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont")){
                            //si existe se llama a su contador y se sigue el conteo                     
                            contEnsambles=lector.lecturaBasicaDeArchivo(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont");             
                        }
                        else{
                            //sino se crea el contador con valor inicial para el archivo
                            escritor.escrituraBasica(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont", String.valueOf(contadorEnsamble)); 
            
                            //se llama a su contador y se sigue el conteo                                       
                            contEnsambles=lector.lecturaBasicaDeArchivo(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont");
                        }
            
                        //se convierte el contador recuperado y se aumenta debido al nuevo ensamble
                        int contadorLeido= Integer.parseInt(contEnsambles);
                        contadorLeido++;
                        escritor.escrituraBasica(rutaContEns+tipoMueble.getNombreNuevoMueble()+".cont", String.valueOf(contadorLeido));
            
                        //se genera el ensamble
                        generarEnsamble("src/ensambles/ensamble",tipoMueble.getNombreNuevoMueble()+String.valueOf(contadorLeido),".ens");
                        identificador=tipoMueble.getNombreNuevoMueble()+String.valueOf(contadorLeido);
           
        } 
            return identificador;
    }
    
    public double eliminaPiezasGeneraCosto(){
        double precio=0;
        
         //se genera el costo del mueble y se eliminan las piezas utilizadas
            for(PiezasDeMueble piezaE: listaPiezas){          
                //se genera el costo y se eliminan las piezas usadas
                precio+=mueble.generarCostoYEliminarPiezas(piezaE.getPieza().getTipo(),piezaE.getNumeroDePiezas());
                //se procede a restar las piezas del contador
                pieza.restaPiezasDeContador(piezaE.getPieza().getTipo(),piezaE.getNumeroDePiezas());
            }
        return precio;
    }
    
    public int revisarPiezasDeEnsamble(String nombre, int numeroNecesario){

        int nPiezaFaltante;
        //se llama al archivo que almacena las piezas
        String contPieza=lector.lecturaBasicaDeArchivo("src/materiaPrima/cont"+nombre+".cont");
        int contadorLeido= Integer.parseInt(contPieza);
                
            //se verifica si el numero de piezas existentes son suficientes para el ensamble
            if(contadorLeido>=numeroNecesario){           
                nPiezaFaltante=0;                    
            }
            else{
                nPiezaFaltante= numeroNecesario-contadorLeido;
            }
        return nPiezaFaltante;
    }
    public void revisarPiezasDeMueble(){
        //se verifica si existen las piezas para este mueble y su cantidad requerida
        listaPiezas= cargarPiezas();
        try{
            //se verifica si la lista recupero datos
            if(listaPiezas.get(0)!=null){
            
                //se verifica la existencia del usuario que realiza el ensamble
                if(archivo.buscarExistente("src/usuarios/usuario"+nombreUsuarioEnsamble.getUser()+".usr")){
                    //se procede a ensamblar la pieza 
                    ensamblar();
                }
                else{
                    System.out.println("Ensamble no realizado no existe User "+nombreUsuarioEnsamble.getUser());
                    escritor.escrituraLinea("Ensamble de "+tipoMueble.getNombreNuevoMueble()+" no realizado porque"
                        +nombreUsuarioEnsamble.getUser()+" NO EXISTE");
                }
            }
        }
        catch(IndexOutOfBoundsException e){
            //no se procede al ensamble 
            System.out.println("Ensamble no realizado no existe info de como armar mueble");
            escritor.escrituraLinea("Ensamble no realizado no se han asignado las piezas para "+tipoMueble.getNombreNuevoMueble());
            
        }
        
    }
    public String revisarEnsamble(){
        String retorno=null;
        //se verifica si existen las piezas para este mueble y su cantidad requerida
        listaPiezas= cargarPiezas();
        
        //se verifica si la lista recupero datos
        try{
            if(listaPiezas.get(0)!=null){
                //ensamblar
                retorno=ensamblarMueble();     
            }
        }
        catch(IndexOutOfBoundsException e){        
            JOptionPane.showMessageDialog(null,"Ensamble no realizado no existe info de como armar este mueble");
            
        }
        return retorno;
    }
    //metodo generador de archivo de mueble nuevo
    public void generarEnsamble(String ruta,String nombre,String exten){
        //metodo para generar Ensambles
        File file = new File(ruta+nombre+exten);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		}
            
        //se guarda la instruccion
        escritor.escrituraLinea("Ensable Exitoso de Mueble "+tipoMueble.getNombreNuevoMueble()+" por"+nombreUsuarioEnsamble.getUser()+" "+fecha);
    }
    
    //metodo de carga de piezas para el mueble
    public ArrayList<PiezasDeMueble> cargarPiezas(){
        
        //se hace referencia a una carpeta
        File folder= new File("src/piezasMuebles");
            //se crea una lista que contenga a los archivos
            ArrayList<PiezasDeMueble> piezasMueble= new ArrayList();
            //se verifica el directorio
            if(folder.isDirectory()){
                //se hace una lista de todos los archivos contenidos
                String[] archivos= folder.list();
                    //se realiza la recuperacion necesaria de los archivos de interes
                    for(String nombreArch: archivos){
                        //se verifica la extension
                        if(nombreArch.endsWith(tipoMueble.getNombreNuevoMueble()+"PM")){
                            //se crea el contenedor del archivo
                            File archivoLeer= new File("src/piezasMuebles/"+nombreArch);
                            
                            //se intenta crear el flujo de entrada para la lectura
                            try(FileInputStream fileStream= new FileInputStream(archivoLeer);
                                    ObjectInputStream inputObject = new ObjectInputStream(fileStream);){
                                        //se castea el objeto leido y se agrega a la lista
                                        piezasMueble.add((PiezasDeMueble)inputObject.readObject());
                            //se capturan las Excepciones                   
                            }catch(IOException e){
                                System.out.println("Error de conexion con el archivo");
                                e.printStackTrace();
                            
                            }catch(ClassNotFoundException e){
                                System.out.println("El objeto no tiene la forma requerida");
                                
                            }
                        
                        }
                        
                    
                    }
            
            }
            return piezasMueble;
        
    }
}
