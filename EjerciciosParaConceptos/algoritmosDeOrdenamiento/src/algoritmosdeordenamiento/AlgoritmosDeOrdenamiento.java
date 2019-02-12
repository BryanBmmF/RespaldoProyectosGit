package algoritmosdeordenamiento;

import java.util.Scanner;
import tiposDeOrdenamiento.burbuja;
import tiposDeOrdenamiento.porInsercion;
import tiposDeOrdenamiento.porSeleccion;
import tiposDeOrdenamiento.quickSort;


public class AlgoritmosDeOrdenamiento {
    static int[] orden = new int [10];
    static Scanner sc = new Scanner(System.in);
    static int option;
    static String metodo;
    static char ejecucion; 
    
    public static void main(String[] args) {
        do{
            System.out.println("\nIngrese 10 numeros para ordenarlos");

            for (int i =0; i < 10; i++){
                orden[i] = sc.nextInt();
            }

            System.out.println("\nEscoja un metodo de ordenamiento");
            System.out.println("1. Por Insercion");
            System.out.println("2. Por Seleccion");
            System.out.println("3. Metodo de Burbuja");
            System.out.println("4. Quicksort");
            option = sc.nextInt();
            System.out.println("");

            switch (option){
                case 1:
                    metodo = "Por Insercion";
                    porInsercion i = new porInsercion();
                    i.insercion(orden);
                    imprimirOrden(metodo);
                    break;

                case 2:
                    metodo = "Por Seleccion";
                    porSeleccion s = new porSeleccion();
                    s.seleccion(orden);
                    imprimirOrden(metodo);
                    break;

                case 3:
                    metodo = "Burbuja";
                    burbuja b = new burbuja();
                    b.burbuja(orden);
                    imprimirOrden(metodo);
                    break;

                case 4:
                    metodo = "QuickSort";
                    quickSort q = new quickSort();
                    q.quickSort(orden);
                    imprimirOrden(metodo);
                    break;

            }
            System.out.println("Desea ordenar otra vez?  [S]i   [N]o");
            String temp = sc.next();
            ejecucion = temp.charAt(0);
        } while (ejecucion == 'S');    
    }
    
    public static void imprimirOrden(String metodo){
        for (int i = 0; i < orden.length; i++){
            System.out.println(orden[i]);
        }
        
        System.out.println("se ha ordenado usando el metodo: " + metodo);
    }
    
}
