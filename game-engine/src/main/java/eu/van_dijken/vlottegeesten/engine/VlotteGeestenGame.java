package eu.van_dijken.vlottegeesten.engine;

import java.util.ArrayList;
import java.util.List;

public class VlotteGeestenGame {

    private final List<PlayingObject> objects;
    private ArrayList<PlayingCard> playingCards;

    public VlotteGeestenGame() {
        objects = new ArrayList<PlayingObject>();
        objects.add(new PlayingObject("White", "Ghost"));
        objects.add(new PlayingObject("Red", "Chair"));
        objects.add(new PlayingObject("Blue", "Book"));
        objects.add(new PlayingObject("Green", "Bottle"));
        objects.add(new PlayingObject("Grey", "Mouse"));
        playingCards = generateCards();
    }

    private ArrayList<PlayingCard> generateCards() {
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        for (int i = 0; i < 60; i++) {
            playingCards.add(new PlayingCard());
        }
        return cards;
    }

    public boolean contains(PlayingObject playingObject) {
        return objects.contains(playingObject);
    }

    public List<PlayingCard> availableCards() {
        return playingCards;
    }
}
