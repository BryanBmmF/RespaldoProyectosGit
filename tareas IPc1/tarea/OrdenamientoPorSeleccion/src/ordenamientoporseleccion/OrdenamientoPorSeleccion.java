/*
 En el siguiente codigo se presenta el ordenamiento tipo por Seleccion
 */
package ordenamientoporseleccion;

import java.util.Scanner;

/**
 * title: Metodo Burbuja
 * @author bryan
 * date: marzo de 2017
 */
public class OrdenamientoPorSeleccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables y arreglos a utilizar
    int[] datos = new int [8];
    Scanner scanner = new Scanner(System.in);
    int i; //variable auxiliar
    int j;
    int menor;
    int temporal;
    int posicion;
    
    //pidiendo al usuario 8 numeros 
    System.out.println("\nIngrese 8 numeros: ");
        for (i =0; i < 8; i++){
            datos[i] = scanner.nextInt();
            }
        //metodo de ordenamiento Por Seleccion
          for (i = 0; i < datos.length - 1; i++) { 
                menor = datos[i]; // tomando como menor el primer numero 
                posicion = i; // guardando su posición
                for (j = i + 1; j < datos.length; j++){ // recorriendo el arreglo en busqueda del numero
                      if (datos[j] < menor) { 
                          menor = datos[j];//comparacion del numero con el siguiente
                          posicion = j;
                      }
                }
                if (posicion != i){ //intercambio del numero menor
                    temporal = datos[i];
                    datos[i] = datos[posicion];
                    datos[posicion] = temporal;
                }
          }
          //imprimiendo arreglo ordenado
    
        System.out.println("\nse ha ordenado usando el metodo: Por Insercion");
        for (i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
        }
    }
    
}
