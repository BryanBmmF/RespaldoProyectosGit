package memoriaejemplo.backend.data;

import memoriaejemplo.backend.matches.MatchResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MemoriaEjemplo
 *
 * @author jose - 13.04.2018
 * @Title: FilesController
 * @Description: description
 *
 * Changes History
 */
public class FilesController {

	public static boolean persistMatchResult(MatchResult result) {
		File file = new File(result.getWinner().getName() + ".bin");
		//FileOutputStream fileOutputStream = null;
		//ObjectOutputStream outputStream = null;
		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
			   ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
			//fileOutputStream = new FileOutputStream(file);
			//outputStream = new ObjectOutputStream(fileOutputStream);
			outputStream.writeObject(result);
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		}
		/*finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Exception e) {
					System.out.println("no se puede cerrar el archivo");
				}
			}
			
		}*/

		return true;
	}

	public static MatchResult readResult() {
		File file = new File("a.bin");
		try (FileInputStream fileInputStream = new FileInputStream(file);
			   ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
			return (MatchResult) inputStream.readObject();
		} catch (IOException e) {
			System.out.println("error de conexion con el archivo");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("El objeto no tiene la forma de un matchresult");
			e.printStackTrace();
		}
		return null;
	}

	public static List<MatchResult> readResults() {
		//averiguar en que carpeta estoy
		//encontrar un listado con todos los archivos de esta carpeta
		//por cada archivo ver si termina en .bin
		//	si es verdadero entonces ingresarlo a la lista
		//	sin no no hacer nada

		File folder = new File(".");
		List<MatchResult> list = new ArrayList<>();
		if (folder.isDirectory()) {
			String[] files = folder.list();
			for (String fileName : files) {
				if (fileName.endsWith(".bin")) {
					File childFile = new File(fileName);
					try (FileInputStream fileInputStream = new FileInputStream(childFile);
						   ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
						list.add((MatchResult) inputStream.readObject());
					} catch (IOException e) {
						System.out.println("error de conexion con el archivo");
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						System.out.println("El objeto no tiene la forma de un matchresult");
						e.printStackTrace();
					}
				}
			}
		}

		return list;
	}
}
