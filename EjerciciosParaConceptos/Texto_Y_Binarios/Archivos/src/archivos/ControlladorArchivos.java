package archivos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Archivos
 *
 * @author jose - 21.04.2017
 * @Title: ArchivoTexto
 * @Description: description
 *
 * Changes History
 */
public class ControlladorArchivos {

	private File primerArchivo = new File("/home/bryan/primerArchivo.bin");

	public void verificarInfoArchivo() {
		System.out.println("============= Existe: " + primerArchivo.exists());
		System.out.println("============= es archivo?: " + primerArchivo.isFile());
	}

	public void escribirEnArchivo() {
		FileOutputStream salida = null;
		String textoSalida = "Hola mundo";
		try {
			salida = new FileOutputStream(primerArchivo);
			salida.write(textoSalida.getBytes());
			
		} catch (IOException ex) {
			System.out.println("=========== error al escribir");
		} finally {
			try {
				salida.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}

	}

	public void lecturaBasica(String path) {
		FileInputStream entrada = null;
		try {
			entrada = new FileInputStream(new File(path));
			int byteEntrada = entrada.read();
			while (byteEntrada != -1) {
				System.out.write(byteEntrada);//lee bytes directamente del flujo y los escribe en consola
				byteEntrada = entrada.read();
			}
			System.out.println("leido");
		} catch (IOException ex) {
			System.out.println("No se puede leer archivo");
		} finally {
			try {
				entrada.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}
	}

	public void lecturaDataBasica(String path) {
		FileInputStream entradaBase = null;
		DataInputStream entrada = null;
		try {
			entradaBase = new FileInputStream(new File(path));
			entrada = new DataInputStream(entradaBase);//lee datos primitivos 
			String data = entrada.readLine();//readLine lee una linea entera
			while (data != null) {
				System.out.print(data);
				data = entrada.readLine();

			}

		} catch (EOFException ex) {
			System.out.println("Lectura finalizada");
		} catch (IOException ex) {
			System.out.println("No se puede leer archivo");
		} finally {
			try {
				entrada.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}
	}

	public void lecturaParaCaracteres(String path) {
		FileReader lector = null;
		BufferedReader buffer = null;
		try {
			lector = new FileReader(new File(path));
			
			//la lectura de archivos de texto necesita de un buffer (almacenamiento intermedio)
			//para una mejor lectura
			buffer = new BufferedReader(lector);
			String data = buffer.readLine();//el buffer tiene diferentes metodos de lectura
			while (data != null) {
				System.out.println(data);
				data = buffer.readLine();

			}

		} catch (EOFException ex) {
			System.out.println("Lectura finalizada");
		} catch (IOException ex) {
			System.out.println("No se puede leer archivo");
		} finally {
			try {
				buffer.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}
	}

	public void escrituraParaCaracteres(String textoAEscribir, String pathArchivo) {
		FileWriter escritor = null;
		try {
			//para escribir texto se usa un objeto especial que envia los caracteres al flujo
			escritor = new FileWriter(new File(pathArchivo));
			escritor.append(textoAEscribir);
		} catch (IOException e) {
			System.out.println("============== error escribiendo en archivo");
		} finally {
			try {
				escritor.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}

	}
}
