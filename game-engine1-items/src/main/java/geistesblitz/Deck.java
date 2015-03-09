package geistesblitz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunsear on 09-03-15.
 */
public class Deck {
    private List<Card> cards = new ArrayList<Card>();
    public Deck(){
        for (int i=0;i<80;i++){
            cards.add(new Card(ItemType.Book, ItemType.Ghost));
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
