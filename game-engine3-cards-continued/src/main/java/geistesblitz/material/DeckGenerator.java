package geistesblitz.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DeckGenerator {
	private List<Card> cards;

	List<Card> generate() {
		cards = new ArrayList<Card>();
		createCardsForAllItemCombinations();
		return cards;
	}

	private void createCardsForAllItemCombinations() {
		Item[] items = Item.values();
		for (int i = 0; i < items.length; i++) {
			for (int j = i + 1; j < items.length; j++) {
				createCardsForItemCombination(items[i], items[j]);
			}
		}
	}

	private void createCardsForItemCombination(Item item1, Item item2) {
		createCardsWithItemDepictedInOriginalColor(item1, item2);
		for (int i = 0; i < 6; i++) {
			cards.add(new Card(Item.Book, new Image(item1, Color.Red), new Image(
					item2, Color.Gray)));
		}
	}

	private void createCardsWithItemDepictedInOriginalColor(Item item1,
			Item item2) {
		cards.add(new Card(item1, new Image(item1, item1.color()), new Image(
				item2, aRandomColorThatIsnt(item1.color(), item2.color()))));
		cards.add(new Card(item2, new Image(item1, aRandomColorThatIsnt(
				item1.color(), item2.color())), new Image(item2, item2.color())));
	}

	private Color aRandomColorThatIsnt(Color... skipColors) {
		ArrayList<Color> colors = colorsMinus(skipColors);
		return colors.get((int) Math.round(-0.5 + Math.random() * colors.size()));
	}

	private ArrayList<Color> colorsMinus(Color... skipColors) {
		ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.values()));
		for (int i = 0; i < skipColors.length; i++) {
			colors.remove(skipColors[i]);
		}
		return colors;
	}

}
