
package cuotaagua;
import java.util.Scanner;


public class CuotaAgua {
    static Scanner scanner = new Scanner(System.in);
    
    //variables globales
    static int cantidadLitros;
    static char opcion;
    //constantes globales 'final' para que no cambie su valor
    static final float CUOTA_BASICA =40;
    static final float PRECIO_MEDIO=0.75f;// 'f' para que el programa lo tome como 
    static final float PRECIO_ALTO=1.25f;
    static final int LIMITE_CUOTA_BASICA=65;
    static final int LIMITE_CUOTA_MEDIA=250;
    static float cuota;
    public static void main(String[] args) {
        do {
            System.out.println("Ingrese numero de litros");
            String litrosTemp = scanner.nextLine(); //convirtiendo a valor entero
            cantidadLitros = Integer.valueOf(litrosTemp);
                if(cantidadLitros>=0 && cantidadLitros<=65){
                    cuota = calcularCuotaBasica();
                }
                else if(cantidadLitros>LIMITE_CUOTA_BASICA && cantidadLitros<=LIMITE_CUOTA_MEDIA){
                    cuota = calcularCuotaMedia(cantidadLitros);
                    
                   
                    
        }
                else{
                    cuota = calcularCuotaAlta(cantidadLitros);
                }
                System.out.println("La cuota a pagar es: Q." + cuota);
			
			System.out.println("Desea realizar otro calculo? [S] si, [N] no");
			String opcionTemp = scanner.nextLine();
			opcion = opcionTemp.charAt(0);
		} while (opcion == 'S'|| opcion=='s');
        
    
        }
    
    public static float calcularCuotaBasica(){
        
        return CUOTA_BASICA;
        
    
    }
    public static float calcularCuotaMedia(int cantidad){
                int extra = cantidad - LIMITE_CUOTA_BASICA;
		float subtotal = extra * PRECIO_MEDIO;
		return subtotal + calcularCuotaBasica();
    }
    
     public static float calcularCuotaAlta(int cantidad){
         
                int extra = cantidad - LIMITE_CUOTA_MEDIA;
		float subtotal = extra * PRECIO_ALTO;
		return subtotal + calcularCuotaMedia(LIMITE_CUOTA_MEDIA);
         
    }
    
    
}
