/*
 * Manejo de envio de primeros parametros al ejecutar el programa
 */
package parametrosenmain;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class ParametrosEnmain {
    
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String mensaje="Bienvenido al programa: ";
        String nombre="";
        //en caso de no ser especificado ningun argumento al ejecutar
        if(args.length==0){
            System.out.println("Que nombre de personaje desea? ");
            nombre= scanner.nextLine();
            //System.out.println(mensaje+nombre);        
        }else{
            //en caso de que se especifiquen argumentos al ejecutr el programa
            for (int i = 0; i < args.length; i++) {
                nombre+=args[i]+" ";
            }
            System.out.print(mensaje+nombre);   
        }
        System.out.println("");
        
        
    }
    
}
