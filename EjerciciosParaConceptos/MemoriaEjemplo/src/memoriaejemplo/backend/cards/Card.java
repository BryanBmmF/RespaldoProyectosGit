package memoriaejemplo.backend.cards;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * MemoriaEjemplo
 *
 * @author jose - 06.04.2018
 * @Title: Card
 * @Description: description
 *
 * Changes History
 */
public class Card extends JLabel {

	public static final int CARD_WIDTH = 100;
	public static final int CARD_HEIGHT = 100;
	private String imagePath;
	private Card pairCard;
	private boolean displayed = false;

	public Card(String imagePath) {
		this.imagePath = imagePath;
		this.setSize(CARD_WIDTH, CARD_HEIGHT);
		this.showCover();
	}

	public String getImagePath() {
		return imagePath;
	}

	public Card getPairCard() {
		return pairCard;
	}

	public void setPairCard(Card pairCard) {
		this.pairCard = pairCard;
	}

	public boolean isPair(Card card) {
		return card != null
			   && this.pairCard != null
			   && this.pairCard.equals(card);
	}

	public boolean isDisplayed() {
		return displayed;
	}

	public void showCover() {
		this.displayed = false;
		this.setIcon(new ImageIcon(getClass().getResource(CardsManager.COVER_IMAGE_RELATIVE_PATH)));
	}

	public void showImage() {
		this.displayed = true;
		this.setIcon(new ImageIcon(getClass().getResource(this.imagePath)));
	}
}
