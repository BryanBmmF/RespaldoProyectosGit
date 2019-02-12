package memoriaejemplo.backend.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * MemoriaEjemplo
 *
 * @author jose - 06.04.2018
 * @Title: CardsManager
 * @Description: description
 *
 * Changes History
 */
public class CardsManager {

	public static final String IMAGE_EXTENSION = ".jpg";
	public static final String COVER_IMAGE_RELATIVE_PATH = "/memoriaejemplo/ui/images/cover" + IMAGE_EXTENSION;
	public static final String CARD_IMAGE_PARENT_RELATIVE_PATH = "/memoriaejemplo/ui/images/";
	public static final int CURRENT_IMAGE_COUNT = 15;

	public static Card[] generateCards(int pairsNumber) {
		Card[] cards = new Card[pairsNumber * 2];
		List<Integer> imageNumbers = new ArrayList<>();
		for (int i = 0; i < pairsNumber; i++) {
			int baseIndex = i * 2; //Controla el index inicial de las cartas a insertar
			int imageNumber = ThreadLocalRandom.current().nextInt(1,
				   CURRENT_IMAGE_COUNT + 1);
			if (!imageNumbers.contains(imageNumber)) {
				// Se crean dos cartas con la misma imagen y se enlazan
				Card firstCard = new Card(CARD_IMAGE_PARENT_RELATIVE_PATH + imageNumber + IMAGE_EXTENSION);
				Card secondCard = new Card(CARD_IMAGE_PARENT_RELATIVE_PATH + imageNumber + IMAGE_EXTENSION);
				firstCard.setPairCard(secondCard);
				secondCard.setPairCard(firstCard);
				// Se agregan las dos nuevas cartas en el listado de cartas
				cards[baseIndex] = firstCard;
				cards[baseIndex + 1] = secondCard;
				imageNumbers.add(imageNumber);
			} else {
				i--;
			}
		}
		return randomizeCards(cards);
	}

	private static Card[] randomizeCards(Card[] cards) {
		Card[] randomizedCards = new Card[cards.length];
		for (Card card : cards) {
			int randomIndex = getIndexAvailable(randomizedCards);
			randomizedCards[randomIndex] = card;
		}
		return randomizedCards;
	}

	private static int getIndexAvailable(Card[] randomizedCards) {
		int randomIndex;
		do {
			// Buscar index
			randomIndex = ThreadLocalRandom.current().nextInt(randomizedCards.length);
			//Hasta que casilla en index este vacio
		} while (randomizedCards[randomIndex] != null);
		return randomIndex;
	}

}
