
package pruebas;
import java.util.Scanner;
import java.util.Random; //importe de la libreria random la cual permite trabar numero aleatorios

public class Pruebas {


    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int numero;
        int numero3;
        int numero2;
        Random aleatorio = new Random();
        Random aleatorio2 = new Random();
        Random aleatorio3 = new Random();
        System.out.println("se mostrara un numero aleatorio entre 1 y 10");
        
        numero = aleatorio.nextInt(10); //tira un numero aleatorio entre 0 y 10
        
        System.out.printf("el numero escogido es: \t%d",numero);
        System.out.println("\n");
        
        numero2 = (aleatorio2.nextInt(10)+1); //tira un numero aleatorio entre 1 y 10
        
        System.out.printf("el numero escogido es: \t%d",numero2);
        System.out.println("\n");
        
        numero3 = (aleatorio3.nextInt(30-20+1)+20); //tira un numero aleatorio entre el intervalo 20  a 30
        
        System.out.printf("el numero escogido es: \t%d",numero3);
        System.out.println("\n");
        
         String enemigoSeleccionado;
         enemigoSeleccionado= "Dark_Wolf";
         
         System.out.println("eres:  "+enemigoSeleccionado);
         
         
         for(int cont=1;cont<10;cont++){
             
             if(cont%2==0){
                 
                 System.out.println("modulo 0");
             }
             else{
                 System.out.println("modulo valor");
             }
         }
    }
    
}
