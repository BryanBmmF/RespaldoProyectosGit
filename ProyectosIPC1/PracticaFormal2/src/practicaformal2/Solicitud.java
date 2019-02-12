/*
 * Clase que permite realizar la solicitud de una tarjeta de credito
 */
package practicaformal2;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author bryan
 */
public class Solicitud implements Serializable{
    
    private ArrayList<String> revision;
    private int numeroDeSolicitud,salarioSolicitante,tipo;
    private String fecha,nombreSolicitante,direccionSolicitante;
    
    public Solicitud (int numeroDeSolicitud,String fecha,
            int tipo,String nombreSolicitante,int salarioSolicitante,String direccionSolicitante){
    
        this.numeroDeSolicitud=numeroDeSolicitud; //unico
        this.fecha=fecha;                         //formato dd/mm/aa
        this.tipo=tipo;                           //tipo de tarjeta  
        this.nombreSolicitante= nombreSolicitante;// hasta 100 caracteres
        this.salarioSolicitante=salarioSolicitante;//enteros
        this.direccionSolicitante=direccionSolicitante;//100 caracteres
        
        revision= new ArrayList<String>();
       
    }
    public void mostrarPar(){
        System.out.println("\nnumero: "+numeroDeSolicitud);
        System.out.println("fecha: "+fecha);
        System.out.println("Tipo: "+tipo);
        System.out.println("Nombre: "+nombreSolicitante);
        System.out.println("Salario: "+salarioSolicitante);
        System.out.println("Direccion: "+direccionSolicitante);
    }
    public void revision(){
        Lector lector= new Lector();
        if(lector.buscarArchivo("solicitud"+numeroDeSolicitud+".sol")){
            //System.out.println("\n Esta solicitud ya ha sido pedida anteriormemte no se puede duplicar");
            revision.add("Error");
        }
        else{
            //revision de errores en formato de parametros recibidos
            try{
                revisarNombre();
            }
            catch(Exception e){
                System.out.println("El Nombre del Solicitante supera el rango de caracteres!!");
                revision.add("Error");
            }
            revisarSalario();
            revisarTipo();
            try{
                revisarDireccion();
            }
            catch(Exception e){
                System.out.println("La direccion del Solicitante supera el rango de caracteres!!");
                revision.add("Error");
            }
        }
        //comprobando si existe un error en solicitud pedidda
        int errorSolicitud= revision.indexOf("Error");
        if(errorSolicitud>=0){
            System.out.println("\n Solicitud no procesada");
        }
        else{
            System.out.println("Solicitud lista para procesar: ");
            mostrarPar();
            generar();
        }
        
        
    }
    public void revisarSalario(){
        //revision de algun error en el formato de salario
        if(salarioSolicitante==0){
            System.out.println("El salario del solicitante tiene un formato no valido!!");
            //error en el salario 
            revision.add("Error");
        }
    }
    public void revisarNombre() throws errorLongitud{
        // revision del formato de Nombre
        if(nombreSolicitante.length()>100){
            throw new errorLongitud();// lanza excepcion errorLongitud      
        }           
    }
    public void revisarDireccion() throws errorLongitud{
        //revision del formato
        if(direccionSolicitante.length()>100){
            throw new errorLongitud(); //lanza excepcion errorLongitud        
        }         
    }
    public void revisarTipo(){
        //revision de tipo de Tarjeta Valido
        if(tipo<=0 || tipo>3){
            System.out.println("El tipo de Tarjeta solicitada no Existe!!");
            revision.add("Error");
        }
    }
    public void generar(){
        //metodo para generar la solicitud sin error alguno
        File file = new File("solicitud"+numeroDeSolicitud+".sol");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			//e.printStackTrace();
		}
            Lector lector = new Lector();
            lector.escrituraLinea("Solicitud "+numeroDeSolicitud+" aprobada de "+ nombreSolicitante+" salario: "+salarioSolicitante);
            
        
    }

    //metodo accesores para los miembros de solicitud
    public int getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(int numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }

    public int getSalarioSolicitante() {
        return salarioSolicitante;
    }

    public void setSalarioSolicitante(int salarioSolicitante) {
        this.salarioSolicitante = salarioSolicitante;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getDireccionSolicitante() {
        return direccionSolicitante;
    }

    public void setDireccionSolicitante(String direccionSolicitante) {
        this.direccionSolicitante = direccionSolicitante;
    }
    
    
}
