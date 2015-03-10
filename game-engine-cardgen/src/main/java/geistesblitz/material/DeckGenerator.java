package geistesblitz.material;

import java.util.ArrayList;
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
        for (int it = 0; it < 8; it++) {
            for (int i = 0; i < items.length; i++) {
                for (int j = i + 1; j < items.length; j++) {
                    createCardsForItemCombination(items[i], items[j]);
                }
            }
        }
    }

    private void createCardsForItemCombination(Item item1, Item item2) {
        cards.add(new Card(item1, item2));
    }

}
