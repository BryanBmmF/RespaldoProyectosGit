package memoriaejemplo.backend.cards;

/**
 * MemoriaEjemplo
 * @author jose - 06.04.2018 
 * @Title: Pair
 * @Description: description
 *
 * Changes History
 */
public class Pair {
	private Card firstCard;
	private Card secondCard;

	public Card getFirstCard() {
		return firstCard;
	}

	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}

	public Card getSecondCard() {
		return secondCard;
	}

	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}
	
	public boolean isFull() {
		return firstCard != null && secondCard != null;
	}
}