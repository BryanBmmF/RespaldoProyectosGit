/*
 En el siguiente codigo se presenta el ordenamiento tipo burbuja
 */
package ordenamientoburbuja;

import java.util.Scanner;

/**
 * title: Metodo Burbuja
 * @author bryan
 * date: marzo de 2017
 */
public class OrdenamientoBurbuja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables y arreglos a utilizar
    int[] datos = new int [8];
    Scanner scanner = new Scanner(System.in);
    int aux; //variable auxiliar
        
    boolean cambio = false;
    //pidiendo al usuario 8 numeros 
    System.out.println("\nIngrese 8 numeros: ");
        for (int i =0; i < 8; i++){
            datos[i] = scanner.nextInt();
            }
        //metodo de ordenamiento
        while(true){
            cambio = false;//condicion inicial de cambio
            for(int i = 1; i < datos.length; i++){//recorriendo el arreglo datos
                if (datos[i] < datos[i-1]){
                    aux = datos[i];  
                    datos[i] = datos[i-1];
                    datos[i-1] = aux;
                    cambio = true;
                }
            }
            if (cambio == false)
                break; //deteniendo el ciclo
        }
        //imprimiendo arreglo ordenado
         
        System.out.println("\nse ha ordenado usando el metodo: BURBUJA");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }
    }
    
}
