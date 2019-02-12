/*
 procedimientos y funciones
 */
package rutinas1;
import java.util.Scanner;
/**
 *
 * @author bryan
 */
public class Rutinas1 {

    static Scanner entrada = new Scanner(System.in);
    static int n1,n2,result;
    public static void main(String[] args) {
        // TODO code application logic here
        
        int opcion=menu();
        switch(opcion){
            case 1:{ solicitarNumeros();
                System.out.println("La suma es: "+suma(n1, n2));
                break;
            }    
            case 2:{ solicitarNumeros();
                System.out.println("La Multiplicacion es: "+multiplicacion(n1, n2));
                break;
            }    
            case 3:{ solicitarNumeros();
                System.out.println("El mayor es: "+mayor(n1, n2));
                break;
            }    
            case 4:{ solicitarNumeros();
                System.out.println("El menor es: "+menor(n1, n2));
                break;
            }
            default:{
                System.exit(0);
            }
        }
        
    }
    public static int menu(){
        int opcion;
        System.out.println("menu de opciones");
        System.out.println("1.suma");
        System.out.println("2.Multiplicacion");
        System.out.println("3.Mayor de 2");
        System.out.println("4.Menor de 2");
        System.out.println("0.Salir");
        System.out.println("\nIngrese el numero de Opcion: ");
        opcion= entrada.nextInt();
        return opcion;            
    }
    public static void solicitarNumeros(){
        System.out.println("Ingrese el primer numero: ");
        n1=entrada.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        n2=entrada.nextInt();
    }
    public static int suma(int n1,int n2){
        result=n1+n2;
        return result;
    }
    public static int multiplicacion(int n1,int n2){
        result=n1*n2;
        return result;
    }
    public static int mayor(int n1,int n2){
        if (n1>n2) result=n1;
        if (n2>n1) result=n2;
        return result;
    }
    public static int menor(int n1,int n2){
        if (n1>n2) result=n2;
        if (n2>n1) result=n1;
        return result;    
    }
    
}
