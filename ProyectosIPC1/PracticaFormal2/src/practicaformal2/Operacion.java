/*
 * Clase para identificar operacion y conversion de parametros respectivos
 * para envio a su clase respectiva.
 */
package practicaformal2;

import java.io.Serializable;

/**
 *
 * @author bryan
 */
public class Operacion implements Serializable{
    //parametros a recibir
    private String[] parametros;
    private int numeroDeParamtros;
 
    //creacion de arreglos para almacenar parametros convertidos
    private int[] enteros;
    private String[]cadenas;
    
    private double monto;  //monto y contadores 
    private static int contEnteros=0;
    private static int contCadenas=0;
    
    //constructor de Operacion recibe parametros y el numero de los mismos
    public Operacion(String[] parametros, int numeroDeParametros){
        this.parametros=parametros;
        this.numeroDeParamtros=numeroDeParametros;
        enteros= new int[numeroDeParametros];
        cadenas= new String[numeroDeParametros];
    }
    //metodo encargado de asignar y crear instancias
    public void asignarOperacion(String tipo){
    
        switch(tipo){
            
            case "SOLICITUD":{               
                convierteParametros();
                //instanciando nueva solicitud
                Solicitud solicitud= new Solicitud(enteros[0],cadenas[1],enteros[1],cadenas[2],
                enteros[2],cadenas[3]);
                solicitud.revision();
                reset();
                break;
            }
            case "LISTADO_SOLICITUDES":{               
                //instanciacion de nuevo listado
                ListadoSolicitud listado= new ListadoSolicitud();
                listado.generar();
                break;
            }
            case "LISTADO_TARJETAS":{               
                //instanciacion de nuevo listado
                ListadoTarjeta listado= new ListadoTarjeta();
                listado.generar();
                break;
            }
            case "AUTORIZACION_TARJETA":{
                convierteParametros();
                //instanciacion de nueva autorizacion
                Autorizacion autorizacion= new Autorizacion(enteros[0]);
                autorizacion.revision();
                reset();
                break;
            }
            case "CANCELACION_TARJETA":{
                convierteParametros();
                //instanciacion de nueva cancelacion
                Cancelacion cancelacion=new Cancelacion(cadenas[1]);
                reset();
                break;
            }
            case "CONSULTAR_TARJETA":{
                convierteParametros();
                //instanciacion de nueva consulta
                ControladorDeTarjetas consulta= new ControladorDeTarjetas();
                break;
            }
            case "MOVIMIENTO":{
                convierteParametros();
                monto= convertidorAuxiliar();
                //instanciacion de nuevo movimiento
                Movimiento movimiento=new Movimiento(cadenas[1],cadenas[2],cadenas[3],cadenas[4],
                    cadenas[5],monto);   
                movimiento.operarMovimiento();
                reset();
                break;
            }
            case "ESTADO_CUENTA":{
                
                //instanciacion de nuevo estado
                EstadoDeCuenta estado= new EstadoDeCuenta();
                break;
            }
            default:{
                System.out.println("no se puede asignar esta operacion");
            }
                  
        }
         
    }
    //metodo de reinicio de contadores
    public void reset(){
        contEnteros=0;
        contCadenas=0;
    }
    //metodo convertidor de una cadena y remplazo de comias("")
    public String convertidor(String cadena){
            
        String devolver = cadena.replaceAll("\"", "");
            
        return devolver;   
    }
    //motodo convertidor de parametros para luego enviarlos y almacenarlos
    public void convierteParametros(){
        for(String i: parametros){
            try{
                //intenta convertir parametro en entero
                int convert= Integer.parseInt(i);
                
                enteros[contEnteros]=convert;//almacenamiento en arreglo de enteros
                contEnteros++;                      
            }
            catch(NumberFormatException e){
                //captura excepcion de formato de numero y convierte a cadena
                String convert = convertidor(i);
                cadenas[contCadenas]=convert;//almacenamiento en arreglo de cadenas
                contCadenas++;
            }
        }
        contEnteros=0; //contador de enteros inicia en 0 normalmente
        contCadenas=1; //contador2 de cadenas inicia en 1 debido al primer almacenamiento con valor nulo
    }
    //metodo que convierte el monto ya sea en String o int A Double
    public double convertidorAuxiliar(){
        double mandar=0;
        if (cadenas[6]==null){
            //convierte  entero a double por ser nula la pos[6] de cadenas
            mandar= (double)enteros[0];
        }
        else{
            //convierte cadena a double directamente ya que no es nula
            mandar= Double.parseDouble(cadenas[6]);
        }
    
        return mandar;
    } 
        
}
