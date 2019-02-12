
package agua;
import java.util.Scanner;
/**
 * Parametros
 * @author jose - 09.02.2018 
 * @Title: Agua
 * @Description: description
 *
 * Changes History
 */
public class Agua {
	static Scanner scanner = new Scanner(System.in);
	
	static int cantidadLitros;
	static char opcion;
	static final float CUOTA_BASICA = 40;
	static final float PRECIO_MEDIO = 0.75F;
	static final float PRECIO_ALTO = 1.25F;
	static final int LIMITE_CUOTA_BASICA = 65;
	static final int LIMITE_CUOTA_MEDIA = 250;
	static float cuota;
		   
	
	public static void main(String[] args) {
		do {
			System.out.println("Ingrese la cantidad de litros: ");
			String litrosTemp = scanner.nextLine();
			cantidadLitros = Integer.valueOf(litrosTemp);
			
			if (cantidadLitros < 0) {
				System.out.println("Ingrese un numero entero positivo!!!");
			} else {
			
				if (cantidadLitros >= 0 && cantidadLitros <= LIMITE_CUOTA_BASICA) {
					cuota = calcularCuotaBasica();
				} else if (cantidadLitros > LIMITE_CUOTA_BASICA && cantidadLitros <= LIMITE_CUOTA_MEDIA) {
					cuota = calcularCuotaMedia(cantidadLitros);
				} else {
					cuota = calcularCuotaAlta(cantidadLitros);
				}

				System.out.println("La cuota a pagar es: Q." + cuota);
			}
			System.out.println("Desea realizar otro calculo? [S]i, [N]o");
			String opcionTemp = scanner.nextLine();
			opcion = opcionTemp.charAt(0);
		} while (opcion == 'S');
		
	}
	
	public static float calcularCuotaBasica() {
		return CUOTA_BASICA;
	}
	
	public static float calcularCuotaMedia(int cantidad) {
		int extra = cantidad - LIMITE_CUOTA_BASICA;
		float subtotal = extra * PRECIO_MEDIO;
		return subtotal + calcularCuotaBasica();
	}
	
	public static float calcularCuotaAlta(int cantidad) {
		int extra = cantidad - LIMITE_CUOTA_MEDIA;
		float subtotal = extra * PRECIO_ALTO;
		return subtotal + calcularCuotaMedia(LIMITE_CUOTA_MEDIA);
	}
	

}

