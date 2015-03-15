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

    private void createCardsWithDepictedItemsAsDesiredItem(Item item1, Item item2) {
        cards.add(new Card(item1, item2, item1));
        cards.add(new Card(item1, item2, item2));
	}

    private void createCardsForItemCombination(Item item1, Item item2) {
    	createCardsWithDepictedItemsAsDesiredItem(item1, item2);
    	for (int it = 0; it < 6; it++) {
    		cards.add(new Card(item1, item2, firstItemThatIsnt(item1, item2)));
    	}
    }

    private Item firstItemThatIsnt(Item... itemsToFilter) {
        ArrayList<Item> items = new ArrayList<Item>(Arrays.asList(Item.values()));
        for (Item item : itemsToFilter) {
			items.remove(item);
		}
    	return items.get(0);
    }
}
