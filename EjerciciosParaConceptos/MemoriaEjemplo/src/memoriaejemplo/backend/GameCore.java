package memoriaejemplo.backend;

import javax.swing.JOptionPane;
import memoriaejemplo.backend.cards.Card;
import memoriaejemplo.backend.cards.Pair;
import memoriaejemplo.backend.matches.MatchResult;
import memoriaejemplo.backend.matches.MatchResultsRegister;
import memoriaejemplo.backend.players.Player;
import memoriaejemplo.backend.players.TurnController;

/**
 * MemoriaEjemplo
 *
 * @author jose - 09.04.2018
 * @Title: GameCore
 * @Description: description
 *
 * Changes History
 */
public class GameCore {
	public static final int EASY_GAME = 5;
	public static final int NORMAL_GAME = 10;
	public static final int HARD_GAME = 15;
	public static final int POINTS_FOR_PAIR = 50;
	public static final int POINTS_FOR_MISSING_PAIR = 10;
	private static final String MESSAGE_FOR_PAIR = "Has encontrado una pareja. " + 
		   POINTS_FOR_PAIR + " ganados.";
	private static final String MESSAGE_FOR_MISSING_PAIR = "Fallaste. " + 
		   POINTS_FOR_MISSING_PAIR + " perdidos.";
	
	private Player firstPlayer;
	private Player secondPlayer;
	private Pair selectedPair;
	private TurnController turnController;
	private int pairsInGame;
	private MatchResultsRegister register;

	public GameCore() {
		turnController = new TurnController();
		register = new MatchResultsRegister();
	}

	public Player startGame(int pairNumber, Player firstPlayer, Player secondPlayer) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		//pares en juego
		pairsInGame = pairNumber;
		//definir turno
		return turnController.startTurns(firstPlayer, secondPlayer);
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	
	public String selectCard(Card selectedCard) {
		if (!selectedCard.isDisplayed()) {
			selectedCard.showImage();
			if (selectedPair == null) {
				selectedPair = new Pair();
				selectedPair.setFirstCard(selectedCard);
				return null;
			} else {
				selectedPair.setSecondCard(selectedCard);
				return checkPair();
			}
		}
		return null;
	}
	
	public boolean isPairFull() {
		return selectedPair.isFull();
	}
	
	public Player getPlayerInTurn() {
		return turnController.getPlayerInTurn();
	}
	
	public String checkPair() {
		if (isPair()) {
			turnController.getPlayerInTurn().addScore(50);
			pairsInGame--;
			return MESSAGE_FOR_PAIR;
		} else {
			turnController.getPlayerInTurn().substractScore(10);
			turnController.shiftTurn();
			return MESSAGE_FOR_MISSING_PAIR;
		}
	}
	
	public boolean isPair() {
		return secondPlayer != null && selectedPair.isFull()
			   && selectedPair.getFirstCard().isPair(selectedPair.getSecondCard());
	}
	
	public boolean hasGameEnded() {
		return pairsInGame == 0;
	}

	public Player getWinner() {
		if (firstPlayer.getScore() > secondPlayer.getScore()) {
			return firstPlayer;
		} else if (secondPlayer.getScore() > firstPlayer.getScore()) {
			return secondPlayer;
		}
		return null;
	}
	
	public void recordMatchResult() {
		MatchResult registry = new MatchResult(firstPlayer, secondPlayer);
		register.addRegistry(registry);
	}

	public Pair getSelectedPair() {
		return selectedPair;
	}
	
	public void cleanSelectedPari() {
		selectedPair = null;
	}

	public MatchResultsRegister getRegister() {
		return register;
	}
}
