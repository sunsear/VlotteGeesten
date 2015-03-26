package geistesblitz.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DeckGenerator {

	private List<Card> cards;

	List<Card> generate() {
		cards = new ArrayList<Card>();
		cards.add(new Card(
				Item.Mouse,
				new Image(Item.Mouse, Color.Gray),
				new Image(Item.Ghost, aRandomColorThatIsnt(Color.Gray, Color.White))

				));
		return cards;
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
