package geistesblitz.material;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> cardsInDeck = new ArrayList<Card>();

    public Deck(){
        for (int i=0;i<80;i++){
            cardsInDeck.add(new Card());
        }
    }
    public int remainingCards(){
        return cardsInDeck.size();
    }
}
