/*
 * Clase para identificar operacion y conversion de parametros respectivos
 * para envio a su clase respectiva.
 */
package proyectofinal.fabrica.archivo;

import proyectofinal.fabrica.produccion.Ensamble;
import proyectofinal.fabrica.produccion.MateriaPrima;
import proyectofinal.fabrica.produccion.Mueble;
import proyectofinal.fabrica.produccion.PiezasDeMueble;
import proyectofinal.fabrica.usuarios.Usuario;

/**
 *
 * @author bryan
 */
public class Operacion {
    //miembros privados de Operacion
    private String[] cadenas;
    private int[] enteros;
    private double decimal;
    private ConvertidorParametros convertidor;
    
    //constructor de operacion recibe arreglo de parametros procesado 
    public Operacion(String[] parametros,int numeroDeParametros){
        
        this.convertidor=new ConvertidorParametros(parametros, numeroDeParametros);
        //se convierten los parametros recibidos
        this.convertidor.convierteParametros();
        this.enteros= convertidor.enviaEnteros();
        this.cadenas= convertidor.enviaCadenas();

    }
    //metodo encargado de asignar y crear instancias
    public void asignarOperacion(String tipo){
        switch(tipo){
            
            case "USUARIO":{               
                //instanciando nuevo usuario
                Usuario usuario= new Usuario(cadenas[1],cadenas[2],enteros[0]);
                usuario.mostrarDatos();
                usuario.validar();
                // revisar si existe usuario.revision();
                break;
            }
            case "PIEZA":{      
                decimal=convertidor.convertidorAuxiliar(cadenas,enteros);
                //instanciacion de nueva pieza
                MateriaPrima pieza = new MateriaPrima(cadenas[1],decimal);
                pieza.mostrarDatos();
                pieza.revizarPieza();
                //listado.generar();
                break;
            }
            case "MUEBLE":{               
                decimal= convertidor.convertidorAuxiliar(cadenas, enteros);
                //instanciacion de nuevo mueble
                Mueble mueble= new Mueble(cadenas[1],decimal);
                mueble.mostrarDatos();
                mueble.validarMueble();
                //listado.generar();
                break;
            }
            case "MUEBLE_PIEZAS":{
                //instanciacion piezas para muebles
                PiezasDeMueble piezasMueble= new PiezasDeMueble(new Mueble(cadenas[1]),new MateriaPrima(cadenas[2]),enteros[0]);
                //autorizacion.revision();
                piezasMueble.mostrarDatos();
                piezasMueble.revisarPiezasDeMueble();
                break;
            }
            case "ENSAMBLAR_MUEBLE":{
                
                //instanciacion de nuevo ensamble
                Ensamble ensamble=new Ensamble(new Mueble(cadenas[1]),new Usuario(cadenas[2]),cadenas[3]);
                ensamble.mostrarDatos();
                ensamble.revisarPiezasDeMueble();
                break;
            }
            
            default:{
                System.out.println("no se puede asignar esta operacion");
            }
                  
        }
         
    }
    
    
}
