package empresarial.backend.excepciones;

/**
 * Escritorio
 *
 * @author jose - 11.04.2017
 * @Title: EspacioExcepcion
 * @Description: description
 *
 * Changes History
 */
public class EspacioExcepcion extends Exception {

	/**
	 * Creates a new instance of <code>EspacioExcepcion</code> without detail message.
	 */
	public EspacioExcepcion() {
	}

	/**
	 * Constructs an instance of <code>EspacioExcepcion</code> with the specified detail
	 * message.
	 *
	 * @param msg the detail message.
	 */
	public EspacioExcepcion(String msg) {
		super(msg);
	}
}
