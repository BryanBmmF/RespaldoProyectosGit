package memoriaejemplo.backend.matches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		return this.registries;
	}
	
	public List<MatchResult> getSortedRegistries() {
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