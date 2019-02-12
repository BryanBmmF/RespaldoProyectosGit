package tienda.cliente;

/**
 * Hilos
 *
 * @author jose - 14.03.2017
 * @Title: Cliente
 * @Description: description
 *
 * Changes History
 */
public class Cliente {

	private String nombre;
	private int[] carroCompra;

	public Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}

}
