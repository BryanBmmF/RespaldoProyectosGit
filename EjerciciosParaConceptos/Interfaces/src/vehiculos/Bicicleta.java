package vehiculos;

import interfaces.Desplazar;

/**
 * Interfaces
 * @author jose - 27.02.2017 
 * @Title: Bicicleta
 * @Description: description
 *
 * Changes History
 */
public class Bicicleta extends Vehiculo implements Desplazar {
	
	@Override
	public void recorrerDistancia(int metros) {
		System.out.println("iniciar a pedalear");
		System.out.println("pedalear a 30k/h");
		System.out.println("durante 5 * " + metros + "= " + 5* metros);
	}
}