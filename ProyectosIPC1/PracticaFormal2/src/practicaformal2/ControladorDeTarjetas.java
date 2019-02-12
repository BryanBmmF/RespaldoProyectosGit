/*
 * Clase tarjeta para el control de cada operacion que se realice
 */
package practicaformal2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class ControladorDeTarjetas implements Serializable{
    
    private String numeroTarjeta;
    private double credito;
    private static int contadorTarjetaN=1;
    private static int contadorTarjetaR=1;
    private static int contadorTarjetaI=1;
    private static boolean autoriza=false;
    //formatos de tarjetas
    public static final String FORMATO_NACIONAL="4256-3102-6585-";
    public static final String FORMATO_REGIONAL="4256-3102-6590-";
    public static final String FORMATO_INTERNACIONAL="4256-3102-6595-";
    public static String ceros="000";
    //tipos de tarjetas
    public static final int TIPO_NACIONAL=1;
    public static final int TIPO_REGIONAL=2;
    public static final int TIPO_INTERNACIONAL=3;
    
    //montos para cada tarjeta
    public static final double MONTO_NACIONAL=1.2;
    public static final double MONTO_REGIONAL=2.3;
    public static final double MONTO_INTERNACIONAL=3.75;
    
    //limites de credito para cada tarjeta
    public static final int LIMITE_CREDITO_NACIONAL= 2000;
    public static final int LIMITE_CREDITO_REGIONAL= 5000;
    public static final int LIMITE_CREDITO_INTERNACIONAL= 12000;
    
    //porcentaje minimo de salario para autorizar tarjeta
    public static final int PORCENTAJE_SALARIO=60;
    
    
    public boolean solicitar(String pathSolicitud){
        //se lee el objeto solicitud para su autorizacion
        File file = new File(pathSolicitud);
		try (FileInputStream fileInputStream = new FileInputStream(file);
                         ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
                         Solicitud nuevaSolicitud;  //se crea objeto solicitud
                         nuevaSolicitud= (Solicitud) inputStream.readObject();
                         autorizar(nuevaSolicitud); //llamada de metodon autorizar 
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("El objeto no tiene la forma de Solicitud");
			e.printStackTrace();
		}
            return autoriza;//retornando autorizacion
    }
    public void autorizar(Solicitud solicitud){
        //reconociendo tipo de autorizacion de tarjeta
        switch(solicitud.getTipo()){
            case TIPO_NACIONAL:{    //si es tipo nacional
                operarAutorizacion(LIMITE_CREDITO_NACIONAL,solicitud,PORCENTAJE_SALARIO,
                        FORMATO_NACIONAL,contadorTarjetaN,"Nac","1");
                break;
            }
            case TIPO_REGIONAL:{    //si es tipo regional
                operarAutorizacion(LIMITE_CREDITO_REGIONAL,solicitud,PORCENTAJE_SALARIO,
                        FORMATO_REGIONAL,contadorTarjetaR,"Reg","2");
                break;
            }
            case TIPO_INTERNACIONAL:{   // si es tipo internacional
                operarAutorizacion(LIMITE_CREDITO_INTERNACIONAL,solicitud,PORCENTAJE_SALARIO,
                        FORMATO_INTERNACIONAL,contadorTarjetaI,"Int","3");
                break;
            }
            default:{
                //sin tipo
            }
        
        }
    
    }
    // metodo operador de autorizaciones de tarjeta
    public void operarAutorizacion(int limiteCredito, Solicitud solicitud, int porcentajeSalario,String formato,int contador,String tipo,String cola){
        
        int porcenSalarioRequerido;
        //calculo del porcentaje requerido
        porcenSalarioRequerido= (solicitud.getSalarioSolicitante()*porcentajeSalario)/100;
        
        if(porcenSalarioRequerido>limiteCredito){
            //se autoriza la tarjeta con el 60% del salario como credito
            //llamar archivo contador de tarjetas
            String contadorEnviar;
            Lector lector= new Lector();
            if(lector.buscarArchivo2("contadorTarjeta"+tipo+".bin")){
                contadorEnviar=lector.lecturaBasicaDeArchivo("contadorTarjeta"+tipo+".bin");
                establecerFormato(formato,contadorEnviar,tipo);
            }
            else{
                lector.escrituraBasica("contadorTarjeta"+tipo+".bin", String.valueOf(contador));
                contadorEnviar=lector.lecturaBasicaDeArchivo("contadorTarjeta"+tipo+".bin");
                establecerFormato(formato,contadorEnviar,tipo);
            }
            //autorizacion de la tarjeta
            autoriza= true;
            String tipoTarjeta= validaTipo(solicitud.getTipo());
            TarjetaDeCredito tarjeta= new TarjetaDeCredito(numeroTarjeta,tipoTarjeta,porcenSalarioRequerido,solicitud.getNombreSolicitante()
                     ,solicitud.getDireccionSolicitante(),solicitud.getFecha(),"ACTIVA");
            //genera el archivo
            tarjeta.generarNuevaTarjeta(contadorEnviar);
            
        }
        else{
            //el salarioMinimo requerido no supera al limite de credito de ControladorDeTarjetas
            System.out.println("EL SALARIO NO APLIC PARA AUTORIZAR LA TARJETA!!");
            autoriza=false;
        }
        
        
    }
    //metodo para establecer formato de tarjetas
    public void establecerFormato(String format,String contador,String tipo){
        int contadorTarjet= Integer.parseInt(contador);
        //estableciendo formato de tarjeta segun el contador
        if(contadorTarjet<10){
            numeroTarjeta= format.concat(ceros).concat(String.valueOf(contadorTarjet));           
        }
        else if(contadorTarjet<100){
            ceros="00";
            numeroTarjeta= format.concat(ceros).concat(String.valueOf(contadorTarjet));
        }
        else if(contadorTarjet<1000){
            ceros="0";
            numeroTarjeta= format.concat(ceros).concat(String.valueOf(contadorTarjet));
        }
        else{
            numeroTarjeta= format.concat(String.valueOf(contadorTarjet));
        }     
        System.out.println("se autorizo la solicitud con numero de tarjeta: "+numeroTarjeta);
            contadorTarjet++;
            
            //se guarda contador
            Lector guarda= new Lector();
            guarda.escrituraBasica("contadorTarjeta"+tipo+".bin", String.valueOf(contadorTarjet));
    }
    //validacion de tipo
    public String validaTipo(int num){
        String regresa="";
            switch(num){
                case TIPO_NACIONAL:{
                    regresa= "NACIONAL";
                    break;
                }
                case TIPO_REGIONAL:{
                    regresa="REGIONAL";
                    break;
                }
                default:{
                    regresa="INTERNACIONAL";
                    break;
                }
            }
        return regresa;
    }
    
    public void realizarMovimiento(){
        
        
    
    }
    public void operarMovimiento(){
    
    }
    public void consultar(){
    
    }
    public void cancelar(){
    
    }
    public void revisarEstado(){
    
    }
    public void listarTarjetas(){
    
    }
    public void listarSolicitudes(){
    
    }
}
