/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vehiculos;

import interfaces.Desplazar;
import interfaces.Volar;

/**
 * Interfaces
 * @author jose - 27.02.2017 
 * @Title: Avion
 * @Description: description
 *
 * Changes History
 */
public class Avion extends Vehiculo implements Volar, Desplazar {

	@Override
	public void aumentarAltura(int metros) {
		System.out.println("Presional acelerador vertical 3*metros: " + 3 * metros);
	}

	@Override
	public void recorrerDistancia(int metros) {
		aumentarAltura(metros);
		System.out.println("Presional acelerador horizontal 11*metros: " + 11 * metros);
	}
	
	public void aterrizar() {
		System.out.println("aterriza en el aeropuerto");
	}

}