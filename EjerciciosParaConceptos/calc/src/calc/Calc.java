
package calc;
import java.util.Scanner;

/**
 * Este es un ejemplo y estas leyendo un comentario que puede incluir documentacion interna
 * sobre la funcionalidad del programa
 */
public class Calc {
	
	//una variable con ambito global
	static Scanner scanner = new Scanner(System.in);
	

	/**
	 * Este es el procedimiento principal
	 */
	public static void main(String[] args) {
		//declaracion de variables locales
		int numeroA;
		int numeroB;
		int resultado;
		/* ESTE
			ES UN COMENTARIO
				DE VARIAS LINEAS*/
		String opcion;
		System.out.println("'suma para sumar, 'resta' para restar: ");
		opcion = scanner.nextLine();
		
		System.out.println("Ingrese un numero");
		numeroA = scanner.nextInt();
		System.out.println("Ingrese otro numero");
		numeroB = scanner.nextInt();

		if (opcion.equals( "suma")) {
			resultado = suma(numeroA, numeroB);
		} else {
			resultado = resta(numeroA, numeroB);
		}
		
		System.out.printf("El resultado es %d\n", resultado);
	}

	/**
	 * Este metodo suma dos numeros y devuelve el resultado
	 * @param primerNumero	el primer numero a sumar
	 * @param segundoNumero	el segundo numero a sumar
	 * @return el total de la suma
	 */
	public static int suma(int primerNumero, int segundoNumero) {
		
		int resultado = primerNumero + segundoNumero;
		
		return resultado;

		
	}

	public static int resta(int primerNumero, int segundoNumero) {
		
		int resultado = primerNumero - segundoNumero;

		return resultado;
	}
	
}