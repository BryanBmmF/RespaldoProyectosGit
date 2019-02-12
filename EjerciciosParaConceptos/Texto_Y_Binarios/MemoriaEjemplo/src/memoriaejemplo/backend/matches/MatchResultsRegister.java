package memoriaejemplo.backend.matches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import memoriaejemplo.backend.data.FilesController;

/**
 * MemoriaEjemplo
 * @author jose - 06.04.2018 
 * @Title: MatchResultsRegister
 * @Description: description
 *
 * Changes History
 */
public class MatchResultsRegister {
	List<MatchResult> registries;
        
	public MatchResultsRegister() {
		this.registries = new ArrayList<>();
	}
	
	public MatchResult addRegistry(MatchResult registry) {
		this.registries.add(registry);
		return registry;
	}
	
	public List<MatchResult> getRegistries() {
		/*MatchResult desdeArchivo = FilesController.readResult();
		if (desdeArchivo != null) {
			this.registries.add(desdeArchivo);
		}*/
		//AQUI PENSÉ QUE ESTABA EL ERROR, PERO NO HAY ERROR YA QUE CADA VEZ QUE SE LEEN
		//TODOS LOS ARCHIVO DE RESULTADO SE CREA UNA NUEVA LISTA.
		//EL UNICO ERROR QUE SIGUE ES QUE EL NOMBRE DE LOS ARCHIVOS DEPENDEN DEL NOMBRE
		//DEL GANADOR. SI DOS GANADORES TIENE EL MISMO NOMBRE ENTONCES SE VA A 
		//SOBRE-ESCRIBIR UN ARCHIVO POR LO QUE HAY QUE HACER UN MECANISMO QUE EVITE
		//LA CREACION DE ARCHIVOS CON NOMBRE BASADO EN EL NOMBRE DEL JUGADOR Y ASEGURE
		//QUE TODOS LOS ARCHIVOS VAN A TENER UN NOMBRE DIFERENTE SIEMPRE.
		//INTENTA CREAR ESTE MECANISMO (NO ES TAREA PERO ES UN BUEN EJERCICIO MENTAL :P ).
		this.registries = FilesController.readResults();
		return this.registries;
	}
	
	public List<MatchResult> getSortedRegistries() {
		getRegistries();
		if (this.registries.isEmpty()) {
			return Collections.emptyList();
		}
		if (this.registries.size() == 1) {
			return registries;
		}
		List<MatchResult> sortedList = new ArrayList<>(this.registries);
		int i = sortedList.size();
		boolean sorted;
		MatchResult first;
		MatchResult second;
		MatchResult auxiliar;
		do {
			sorted = true;
			for (int j = 0; j + 1 < i; j++) {
				first = sortedList.get(j);
				second = sortedList.get(j + 1);
				if (first.getWinner().getScore() < second.getWinner().getScore()) {
					sorted = false;
					auxiliar = first;
					sortedList.set(j, second);
					sortedList.set(j + 1, auxiliar);
				}
			}
			i--;
		} while (!sorted && i > 1);
		return sortedList;
	}
}