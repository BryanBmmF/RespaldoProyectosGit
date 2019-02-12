package vehiculos;

/**
 * Interfaces
 * @author jose - 27.02.2017 
 * @Title: Vehiculo
 * @Description: description
 *
 * Changes History
 */
public class Vehiculo {
	private String tipoCombustible;
	private int cantidadMaxima;
	
	public void llenarTanque(int litros) {
		System.out.println("Agregue a mi tanque: " + litros + " litros");
	}
}