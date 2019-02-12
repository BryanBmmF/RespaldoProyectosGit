/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedabinaria;

/**
 *
 * @author jose
 */
public class BusquedaBinaria {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Dato[] datos = new Dato[10];
		datos[0] = new Dato(3, "A");
		datos[1] = new Dato(8, "B");
		datos[2] = new Dato(13, "C");
		datos[3] = new Dato(23, "D");
		datos[4] = new Dato(33, "E");
		datos[5] = new Dato(43, "F");
		datos[6] = new Dato(53, "G");
		datos[7] = new Dato(63, "H");
		datos[8] = new Dato(73, "I");
		datos[9] = new Dato(83, "J");
		
		int clave = 8;
		Dato datoEncontrado = encontrarDatoUsandoClave(datos, clave);
		
		if (datoEncontrado == null) {
			System.out.println("No encontrado dato con clave " + clave);
		} else {
			System.out.println("Si se encontro dato, texto: " + datoEncontrado.obtenerTexto());
		}
		
		Dato datoEncontrado2 = encontrarPorBinario(datos, clave);
		if (datoEncontrado2 == null) {
			System.out.println("No encontrado dato con clave " + clave);
		} else {
			System.out.println("Si se encontro dato, texto: " + datoEncontrado2.obtenerTexto());
		}
	}
	
	public static Dato encontrarDatoUsandoClave(Dato[] datos, int clave) {
		for (Dato dato : datos) {
			System.out.println("texto = " + dato.obtenerTexto());
			if (dato.obtenerClave() == clave) {
				return dato;
			}
		}
		return null;
	}
	
	public static Dato encontrarPorBinario(Dato[] datos, int clave) {
		int mitad;
		int indiceInicial = 0;
		int indiceFinal = datos.length - 1;
		Dato valorMedio;
		
		while (indiceInicial <= indiceFinal) {
			mitad = (indiceFinal + indiceInicial) / 2;
			valorMedio = datos[mitad];
			System.out.println("texto = " + valorMedio.obtenerTexto());
			if (valorMedio.obtenerClave() == clave) {
				return valorMedio;
			} else if(clave < valorMedio.obtenerClave()) {
				indiceFinal = mitad - 1 ;
			} else {
				indiceInicial = mitad + 1;
			}
		}
		return null;
	}
	
}
