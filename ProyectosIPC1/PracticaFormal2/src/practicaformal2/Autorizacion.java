/*
 * Clase que controla la autorizacion de tarjetas.
 */
package practicaformal2;
import java.io.*;
import java.time.LocalDate;

/**
 *
 * @author bryan
 */
public class Autorizacion implements Serializable{
    
    private int numeroDeSolicitud;
    private LocalDate fecha;
    public Autorizacion(int numeroDeSolicitud){
        
        this.numeroDeSolicitud= numeroDeSolicitud;
         //mostrarPar();
    }
     public void mostrarPar(){
     
         System.out.println("Autorizacion de solicitud: "+numeroDeSolicitud);
     }
     //Revision de solicitud
     public void revision(){
         Lector lector= new Lector();
         //se busca la solicitud y se verifica si no ha sido autorizada
         if(lector.buscarArchivo("solicitud"+numeroDeSolicitud+".sol")){
            if(lector.buscarArchivo("autorizacion"+numeroDeSolicitud+".aut")){
                System.out.println("Esta solicitud ya ha sido Autorizada!!");
                System.out.println("Autorizacion no procesada");
            }
            else{
                //En caso no esta autorizada
                ControladorDeTarjetas tarjeta= new ControladorDeTarjetas();
                if(tarjeta.solicitar("solicitud"+numeroDeSolicitud+".sol")){
                    generar();
                }
                else{
                    System.out.println("\n No se pudo autorizar la tarjeta de solicitud: "+numeroDeSolicitud);
                }
            }
         }
         else{
             System.out.println("La solicitud de esta Tarjeta no se ha hecho previamente");
         }
     }
     public void generar(){
        //metodo para generar nueva aotorizacion de tarjeta sin error alguno
        File file = new File("autorizacion"+numeroDeSolicitud+".aut");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			
                    outputStream.writeObject(this);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			//e.printStackTrace();
		}
            Lector lector= new Lector();
            lector.escrituraLinea("Se Autorizo la tarjeta con numero de solicitud: "+numeroDeSolicitud);
            
        
    }

    public int getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(int numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }
     
     
    
}
