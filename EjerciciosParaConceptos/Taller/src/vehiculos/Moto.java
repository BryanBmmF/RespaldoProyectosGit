package vehiculos;

/**
 * Taller
 * @author jose - 21.02.2018 
 * @Title: Moto
 * @Description: description
 *
 * Changes History
 */
public class Moto extends Vehiculo {
	String tipoCadena;
	
        //constructor de hijo moto
	public Moto(int cantidadLlantas, String tipoMotor, String tipoAceite) {
		super(cantidadLlantas, tipoMotor, tipoAceite);
	}
	
	void mantenimientoCadena() {
		System.out.println("Mantenimiento cadena desde moto");
	}
}