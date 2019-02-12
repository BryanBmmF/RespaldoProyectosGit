package memoriaejemplo.backend.players;

import java.io.Serializable;

/**
 * MemoriaEjemplo
 * @author jose - 06.04.2018 
 * @Title: Player
 * @Description: description
 *
 * Changes History
 */
public class Player implements Serializable {
	private String name;
	private int score;

	public Player(String name) {
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	public void addScore(int points) {
		this.score += points;
	}
	
	public void substractScore(int points) {
		if (this.score - points < 0) {
			this.score = 0;
		} else {
			this.score -= points;
		}
	}
}