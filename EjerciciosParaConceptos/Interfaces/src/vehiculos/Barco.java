package vehiculos;

import interfaces.Desplazar;

/**
 * Interfaces
 * @author jose - 27.02.2017 
 * @Title: Barco
 * @Description: description
 *
 * Changes History
 */
public class Barco extends Vehiculo implements Desplazar {
	@Override
	public void recorrerDistancia(int metros) {
		System.out.println("Umenta potencia de turbinas por 10*metros:" + 10 * metros);
	}
}