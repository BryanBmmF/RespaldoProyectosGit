package memoriaejemplo.backend.players;

import java.util.concurrent.ThreadLocalRandom;

/**
 * MemoriaEjemplo
 * @author jose - 06.04.2018 
 * @Title: TurnController
 * @Description: description
 *
 * Changes History
 */
public class TurnController {
	private int turn;
	private Player firstPlayer;
	private Player secondPlayer;
	
	public Player startTurns(Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.turn = ThreadLocalRandom.current().nextInt(0, 2);
		return getPlayerInTurn();
	}
	
	public Player getPlayerInTurn() {
		if (this.turn == 0) {
			return firstPlayer;
		} else {
			return secondPlayer;
		}
	}
	
	public Player shiftTurn() {
		this.turn = this.turn == 0 ? 1 : 0;
		return getPlayerInTurn();
	}
}