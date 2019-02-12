package vehiculos;

/**
 * Taller
 * @author jose - 21.02.2018 
 * @Title: Camion
 * @Description: description
 *
 * Changes History
 */
public class Camion extends Vehiculo {
	
	public Camion(int cantidadLlantas, String tipoMotor, String tipoAceite) {
		super(cantidadLlantas, tipoMotor, tipoAceite);
	}

	void aliniacion() {
		System.out.println("Alineacion para el camion");
	}
}