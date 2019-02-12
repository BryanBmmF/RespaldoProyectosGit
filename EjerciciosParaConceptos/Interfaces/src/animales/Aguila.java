package animales;

import interfaces.Desplazar;
import interfaces.Volar;

/**
 * Interfaces
 * @author jose - 27.02.2017 
 * @Title: Aguila
 * @Description: description
 *
 * Changes History
 */
public class Aguila extends Animal implements Volar, Desplazar {
	
	@Override
	public void recorrerDistancia(int metros) {
		aumentarAltura(metros);
		System.out.println("Bate sus alas de manera horizontal");
	}
	
	@Override
	public void aumentarAltura(int metros) {
		System.out.println("Batir alas de manera vertical por 5 segundos: " + 5 * metros);
	}
	
	public void aterrizar() {
		System.out.println("Aterriza el aguila en su nido");
	}
}
