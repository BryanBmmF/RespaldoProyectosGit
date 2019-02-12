package vehiculos;

/**
 * Taller
 * @author jose - 21.02.2018 
 * @Title: Sedan
 * @Description: description
 *
 * Changes History
 */
public class Sedan extends Vehiculo {
	
	public Sedan(int cantidadLlantas, String tipoMotor, String tipoAceite) {
		super(cantidadLlantas, tipoMotor, tipoAceite);
	}
	
	void alineacion() {
		System.out.println("Se alinearon llantas del sedan");
	}
}