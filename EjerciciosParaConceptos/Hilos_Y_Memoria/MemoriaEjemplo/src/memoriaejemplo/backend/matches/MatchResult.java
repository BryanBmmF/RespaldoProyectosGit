package memoriaejemplo.backend.matches;

import java.time.LocalDateTime;
import memoriaejemplo.backend.players.Player;

/**
 * MemoriaEjemplo
 * @author jose - 06.04.2018 
 * @Title: MatchResult
 * @Description: description
 *
 * Changes History
 */
public class MatchResult {
	private Player winner;
	private Player loser;
	private LocalDateTime gameDate;

	public MatchResult(Player firstPlayer, Player secondPlayer) {
		if (firstPlayer.getScore() > secondPlayer.getScore()) {
			this.winner = firstPlayer;
			this.loser = secondPlayer;
		} else {
			this.winner = secondPlayer;
			this.loser = firstPlayer;
		}
		this.gameDate = LocalDateTime.now();
	}

	public Player getWinner() {
		return winner;
	}

	public Player getLoser() {
		return loser;
	}

	public LocalDateTime getGameDate() {
		return gameDate;
	}
}