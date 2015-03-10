package geistesblitz.material;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Deck {

	private List<Card> cards;
	private ListIterator<Card> iterator;

	public Deck() {
		cards = new DeckGenerator().generate();
		Collections.shuffle(cards, new Random(System.nanoTime()));
		iterator = cards.listIterator();
	}

	public Card draw() {
		return iterator.next();
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

}
