/*
 * clase que interpreta cada linea del archivo de texto con su respectivo procedimiento
 */
package practicaformal2;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author bryan
 */
public class Interprete {
    
    //creacion de lista para almacenar todos los procedimientos disponibles
    
    ArrayList<String> procedimientos = new ArrayList<String>();
    Vector<String> par= new Vector<String>();
    
    
    private static int numeroDeParametros=1;
    private String[] parametros;
    public static final int PARAMETROS_SOLICITUD= 6;
    
    public void reconocedor(String cadena){
        
        //Agregando procedimientos disponibles
        procedimientos.add("SOLICITUD");
        procedimientos.add("LISTADO_SOLICITUDES");
        procedimientos.add("LISTADO_TARJETAS");
        procedimientos.add("AUTORIZACION_TARJETA");
        procedimientos.add("CANCELACION_TARJETA");
        procedimientos.add("CONSULTAR_TARJETA");
        procedimientos.add("MOVIMIENTO");
        procedimientos.add("MOVIMIENTO");
        procedimientos.add("ESTADO_CUENTA");
        
        //Declaracion de parametros para cada procedimiento
        
        
        //remplazo de caracteres en cadena proveniente para capturar el tipo de procedimiento
        char c1='(';  //caracter a remplazar
        char c2=','; //caracter a colocar
        String remplazo;
        remplazo= cadena.replace(c1,c2);
        
        //almacenando cadena de procedimiento
        String[] cadenaDeProcedimiento=remplazo.split(",");
        
        //busqueda de la  cadenaDeProcedimiento dentro de la lista de disponibles
        int k= procedimientos.indexOf(cadenaDeProcedimiento[0]);
        if(k>=0){
            //se encontro el procedimiento dentro de la lista de procedimientos
            System.out.println("\n"+cadenaDeProcedimiento[0]+" en espera de proceso...........");
            
            //conversion de cadena a procesar para la extraccion de parametros
            String cadenaParaEx= cadena.replaceAll(cadenaDeProcedimiento[0],"");
            
            System.out.println("\ncadena para extraer parametros: ----->  "+cadenaParaEx);
            System.out.println("\n");
            
            capturaDeParametros(cadenaParaEx);
            
            
            System.out.println("\nse creara la instancia del objeto: "+procedimientos.get(k));
            //Asignacion de nueva operacion
            Operacion operacion= new Operacion(parametros,numeroDeParametros);
            operacion.asignarOperacion(procedimientos.get(k));
            
            
        }
        else{
            System.out.println("\n Este procedimiento no es un procedimiento valido");
        }
    }
    //metodo encargado de capturar parametros dentro de la linea de instruccion
    public void capturaDeParametros(String cadenaAP){
        
        //remplazo de caracteres en cadena proveniente
        char c1='(';  //caracter a remplazar
        char c2=','; //caracter a colocar
        String remplazo1;
        remplazo1= cadenaAP.replace(c1,c2);
        
        char c3=')';  //caracter a remplazar
        char c4=','; //caracter a colocar
        String remplazo2;
        remplazo2= remplazo1.replace(c3,c4);
        
        //almacenando parametros en arreglo
        parametros= remplazo2.split(",");
        
        //numero De parametros almacenados
        for(String i: parametros){
            numeroDeParametros++;
        
        }
        
    
    }
    
    
    
}
