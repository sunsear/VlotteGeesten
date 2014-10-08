package eu.van_dijken.vlottegeesten.cards;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard {

    private ArrayList<CardImage> cardImages;

    public List<CardImage> images() {
        cardImages = new ArrayList<CardImage>();
        cardImages.add(new CardImage());
        cardImages.add(new CardImage());
        return cardImages;
    }
}
