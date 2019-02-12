
package llenararreglo;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class LlenarArreglo {

    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
        int nElementos;
        //ventana que pide ingresar la magnitud del vector al usuario
        nElementos=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos Elementos desea ingresar:"));
        
        //declarando el arreglo de nElementos ingresados por el usuario
        char[] letras = new char[nElementos];
        
            //pidiendo la magnitud del array
            System.out.println("Digite los elementos del arreglo:");
                //ingresando los elementos
                for(int i=0;i<nElementos;i++){
                    System.out.println((i+1)+". Digite un caracter: ");
                    letras[i]= entrada.next().charAt(0);
                }
                //imprimiendo caracterese
         System.out.println("\nLos elementos del arreglo son:");
            for(int i=0;i<nElementos;i++){
                System.out.println(letras[i]);
            }
        
        
    }
    
}
