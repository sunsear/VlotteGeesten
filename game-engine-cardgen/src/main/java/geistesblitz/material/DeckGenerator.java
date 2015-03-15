package geistesblitz.material;

import java.util.ArrayList;
import java.util.List;

class DeckGenerator {

	private List<Card> cards;

	List<Card> generate() {
		cards = new ArrayList<Card>();
		cards.add(new Card(
				new Image(Item.Mouse, Color.Gray),
				new Image(Item.Ghost, Color.Blue),
				Item.Mouse
				));
		return cards;
	}

}
