/*
 * Clase empleada para la conversion de tipos de datos
 */
package proyectofinal.fabrica.archivo;

/**
 *
 * @author bryan
 */
public class ConvertidorParametros {
    
     //parametros a recibir
    private String[] parametros;
    private int numeroDeParamtros;
 
    //creacion de arreglos para almacenar parametros convertidos
    private int[] enteros;
    private String[]cadenas;
     //contadores 
    private static int contEnteros=0;
    private static int contCadenas=0;
    
    //constructor de ConvertidorDeParametros recibe arreglo y nParam
    public ConvertidorParametros(String[] parametros,int numeroDeParametros){
        
        this.parametros=parametros;
        this.numeroDeParamtros=numeroDeParametros;
        enteros= new int[numeroDeParametros];
        cadenas= new String[numeroDeParametros];
    
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
        contEnteros=0; //reinicio de contadores
        contCadenas=0; 
    }
    //metodo que convierte una cadena ya sea en String o int A Double
    public double convertidorAuxiliar(String[] cadenaR,int[] enteroR){
        double mandar=0;
        if (cadenaR[2]==null){
            //convierte  entero a double por ser nula la pos[2] de cadenas
            mandar= (double)enteroR[0];
        }
        else{
            //convierte cadena a double directamente ya que no es nula
            mandar= Double.parseDouble(cadenaR[2]);
        }
        //retorna valor decimal
        return mandar;
    }
    //envio de paramatros procesados
    public String[] enviaCadenas(){
    
        return cadenas;
    }
    public int[] enviaEnteros(){
    
        return enteros;
    }
}
