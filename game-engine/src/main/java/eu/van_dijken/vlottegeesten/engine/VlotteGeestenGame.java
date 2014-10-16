package eu.van_dijken.vlottegeesten.engine;

import eu.van_dijken.vlottegeesten.cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class VlotteGeestenGame {

    private final List<GameToken> tokens;
    private ArrayList<PlayingCard> playingCards;

    public VlotteGeestenGame() {
        tokens = new ArrayList<GameToken>();
        tokens.add(new GameToken("White", "Ghost"));
        tokens.add(new GameToken("Red", "Chair"));
        tokens.add(new GameToken("Blue", "Book"));
        tokens.add(new GameToken("Green", "Bottle"));
        tokens.add(new GameToken("Grey", "Mouse"));
        playingCards = generateCards();
    }

    private ArrayList<PlayingCard> generateCards() {
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        for (int i = 0; i < 60; i++) {
            cards.add(new PlayingCard());
        }
        return cards;
    }

    public boolean contains(GameToken gameToken) {
        return tokens.contains(gameToken);
    }

    public List<PlayingCard> availableCards() {
        return playingCards;
    }
}
