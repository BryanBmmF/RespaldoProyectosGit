package busquedabinaria;

/**
 * BusquedaBinaria
 * @author jose - 07.03.2018 
 * @Title: Dato
 * @Description: description
 *
 * Changes History
 */
public class Dato {
	private int clave;
	private String texto;

	public Dato(int clave, String texto) {
		this.clave = clave;
		this.texto = texto;
	}
	
	public int obtenerClave() {
		return this.clave;
	}
	
	public String obtenerTexto() {
		return this.texto;
	}

}