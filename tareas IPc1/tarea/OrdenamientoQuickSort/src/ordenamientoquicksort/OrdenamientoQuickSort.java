/*
 En el siguiente codigo se presenta el ordenamiento tipo Quick sort
 */
package ordenamientoquicksort;

import java.util.Scanner;

/**
 * title: Metodo Burbuja
 * @author bryan
 * date: marzo de 2017
 */
public class OrdenamientoQuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //variables y arreglos a utilizar
    int[] datos = new int [8];
    Scanner scanner = new Scanner(System.in);
    
    //pidiendo al usuario 8 numeros 
    System.out.println("\nIngrese 8 numeros: ");
        for (int i =0; i < 8; i++){
            datos[i] = scanner.nextInt();
            }
 
        //imprimiendo arreglo ordenado
    
        System.out.println("\nse ha ordenado usando el metodo: Quick Sort");
        for (int i = 0; i < datos.length; i++){
            System.out.println(datos[i]);
            
        }
        //metodo de ordenamiento quick sort
    }
    public int [] quickSort1(int numeros []){
        return quickSort2(numeros,0,numeros.length-1);
    }
    
    public int [] quickSort2(int numeros[], int izq, int der){
        if (izq >= der){
            return numeros;        
        }
        
        int i = izq,d = der;
        
        if (izq != der){
            int pivote;
            int aux;
            pivote = izq;
            
            while (izq != der){
                while (numeros[der] >= numeros[pivote] && izq < der)
                    der--;
                while (numeros[izq] < numeros[pivote] && izq < der)
                    izq++;
            if(der!=izq){
                aux = numeros[der];
                numeros[der] = numeros[izq];
                numeros[izq] = aux;
            }
        }
            
        if (izq == der){
            quickSort2(numeros,1,izq-1);
            quickSort2(numeros,izq+1,d);
        }
        } else {
            return numeros;
        }
        return numeros;
    }
    
}
