package geistesblitz.material;

import java.util.ArrayList;
import java.util.List;

class DeckGenerator {

	private List<Card> cards;

	List<Card> generate() {
		cards = new ArrayList<Card>();
        cards.add(new Card(Item.Mouse, Item.Mouse, Color.Gray, Item.Ghost, Color.Blue));
		return cards;
	}

}
