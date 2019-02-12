
package menus;
import java.util.Scanner;
public class Menus {

    static Scanner scanner = new Scanner(System.in);//variables globales
    static int numeroA;
    static int numeroB;
    static int resultado;
    
    public static void main(String[] args) {
        int opcion; //variables locales
        int volver;
        System.out.println("este programa le muestra un menu de calculadora.\n");
        //Inicio de la sentencia "hacer, mientras"
        do {
            System.out.println(" Que operacion desea: \n");//despliegue del menu de opciones
            System.out.println("1.Sumar.");
            System.out.println("2.Restar.");
            System.out.println("3.Multiplicar.");
            System.out.println("4.Division entera .");
            System.out.println("5.Dicision residuo.");
            opcion = scanner.nextInt(); //leyendo la opcion
       
                switch(opcion){ //Inicio del comparador "en caso"
                    case 1:{
                        suma();
                    break;
                
                    }
                    case 2:{
                        resta();
                    break;
                    }
                    case 3:{
                        multiplicacion();
                    break;
                    }
                    case 4:{
                        div();
                    break;
                    }
                    case 5:{
                        mod();
                    break;
                    }
                default:{
                        System.out.println("la opcion no se encuantra dentro del listado");
                    }
        }
                //preguntando al usuario si desea realizar otra operacion
                System.out.println("desea volver a operar '1'si , '0'no?");
                volver = scanner.nextInt();
        }
                while(volver==1);
                // Fin del Bucle "Hacer mientras"
    }
    //funcion suma
    public static void suma(){
        
        System.out.println("Ingrese un numero:");
        numeroA = scanner.nextInt();
        System.out.println("Ingrese otro numero:");
        numeroB = scanner.nextInt();
        
        resultado = numeroA + numeroB;
        
        System.out.printf("El resultado es: %d",resultado);
        System.out.println("\n");
        }
    //funcion resta
    public static void resta(){
        
        System.out.println("Ingrese un numero:");
        numeroA = scanner.nextInt();
        System.out.println("Ingrese otro numero:");
        numeroB = scanner.nextInt();
        
        resultado = numeroA - numeroB;
        
        System.out.printf("El resultado es: %d",resultado);
        System.out.println("\n");
        }
    //funcion multiplicacion
    public static void multiplicacion(){
        
        System.out.println("Ingrese un numero:");
        numeroA = scanner.nextInt();
        System.out.println("Ingrese otro numero:");
        numeroB = scanner.nextInt();
        
        resultado = numeroA * numeroB;
        
        System.out.printf("El resultado es: %d",resultado);
        System.out.println("\n");
        }
    //funcion division
    public static void div(){
        
        System.out.println("Ingrese un numero:");
        numeroA = scanner.nextInt();
        System.out.println("Ingrese otro numero:");
        numeroB = scanner.nextInt();
        
        resultado = numeroA / numeroB;
        
        System.out.printf("El resultado es: %d",resultado);
        System.out.println("\n");
        }
    //funcion modulo
    public static void mod(){
        
        System.out.println("Ingrese un numero:");
        numeroA = scanner.nextInt();
        System.out.println("Ingrese otro numero:");
        numeroB = scanner.nextInt();
        
        resultado = numeroA % numeroB;
        
        System.out.printf("El resultado es: %d",resultado);
        System.out.println("\n");
        }
}
