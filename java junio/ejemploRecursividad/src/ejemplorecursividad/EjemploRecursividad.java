/*
 * Recursividad
 */
package ejemplorecursividad;
import java.util.Scanner;
/**
 *
 * @author bryan
 */
public class EjemploRecursividad {

    /**
     * @param args the command line arguments
     */
    static Scanner entrada = new Scanner(System.in);
    static int n1,n2;
    public static void main(String[] args) {
        System.out.println("Ingrese primer numero: ");
        n1= entrada.nextInt();
        System.out.println("Ingrese segundo numero: ");
        n2= entrada.nextInt();
        calular(n1, n2);
    }
    public static void calular(int n1, int n2){
        int result=0;
        for (int i = 0; i < n2; i++) {
            result=result+=n1;
        }
        
        System.out.println("mult = "+result);
    }
    
}
