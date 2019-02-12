/*
 * Clase encargada de interpretar cada linea de instruccion
 */
package proyectofinal.fabrica.archivo;

import java.util.ArrayList;
/**
 *
 * @author bryan
 */
public class Interprete {
    
    //creacion de lista para almacenar todos los procedimientos disponibles
    
    ArrayList<String> procedimientos = new ArrayList<String>();
    //miembros para el manejo de los parametros de instruccion
    private static int numeroDeParametros=1;
    private String[] parametros;
    
    //metodo reconocedor del tipo de procedimiento que se desea ingresar
    public void reconocedor(String cadena){
        
        //Agregando procedimientos disponibles
        procedimientos.add("USUARIO");
        procedimientos.add("PIEZA");
        procedimientos.add("MUEBLE");
        procedimientos.add("MUEBLE_PIEZAS");
        procedimientos.add("ENSAMBLAR_MUEBLE");
        
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
            //captura de parametros para enviar luego
            capturaDeParametros(cadenaParaEx);
                       
            System.out.println("\nse creara la instancia del objeto: "+procedimientos.get(k));
            
            //se instancia nueva operacion y se asigna
            Operacion operacion= new Operacion(parametros,numeroDeParametros);
            operacion.asignarOperacion(procedimientos.get(k));
            
        }
        else{
            System.out.println("\n Procedimiento no valido");
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
        
        //contador de numero De parametros almacenados
        for(String i: parametros){
            numeroDeParametros++;
        
        }
        
    
    }
    
}
