package archivos;

/**
 *
 * @author jose
 */
public class Run {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//CAMBIAR EL PATH DEL ARCHIVO PARA QUE LOS EJEMPLOS FUNCIONEN EN SUS MAQUINAS
		
		String textoAEscribir = "Este es un nuevo texto a escribir,\n"
			   + "y contiene saltos de linea\n"
			   + "por cierto, Hola Mundo!!";
		//modificacion
		ControlladorArchivos archivo = new ControlladorArchivos();
		archivo.verificarInfoArchivo();
		//archivo.escribirEnArchivo();
		//archivo.lecturaBasica("/home/bryan/primerArchivo.bin");
		//archivo.lecturaDataBasica("/home/bryan/primerArchivo.bin");
                archivo.lecturaParaCaracteres("/home/bryan/primerArchivo.txt");
		//archivo.escrituraParaCaracteres(textoAEscribir, "/home/bryan/paraEscribir.txt");
	}
	
}
