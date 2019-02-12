/*
 En el siguiente codigo se presenta el ordenamiento tipo por Insercion
 */
package ordenamientoporinsercion;

import java.util.Scanner;

/**
 * title: Metodo Burbuja
 * @author bryan
 * date: marzo de 2017
 */
public class OrdenamientoPorInsercion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables y arreglos a utilizar
    int[] datos = new int [8];
    Scanner scanner = new Scanner(System.in);
    int aux; //variable auxiliar
    int cont1;
    int cont2;
    
    //pidiendo al usuario 8 numeros 
    System.out.println("\nIngrese 8 numeros: ");
        for (int i =0; i < 8; i++){
            datos[i] = scanner.nextInt();
            }
        //metodo de ordenamiento Por insercion
        for (cont1 = 1; cont1 < datos.length; cont1++){  //recorriendo el arreglo
            aux = datos[cont1];
            for (cont2 = cont1-1; cont2 >= 0 && datos[cont2] > aux; cont2--){ //comparando valores
                datos[cont2+1] = datos[cont2]; //ordenando arreglo
                datos[cont2] = (int) aux;
            }
        }
        //imprimiendo arreglo ordenado
         
        System.out.println("\nse ha ordenado usando el metodo: Por Insercion");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }
        
    }
    
}
