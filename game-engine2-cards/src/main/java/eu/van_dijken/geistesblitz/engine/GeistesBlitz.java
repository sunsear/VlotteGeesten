package eu.van_dijken.geistesblitz.engine;

import eu.van_dijken.geistesblitz.material.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class GeistesBlitz {

    private final List<PlayingCard> playingCards;

    public GeistesBlitz() {
        playingCards = generateCards();
    }

    private List<PlayingCard> generateCards() {
        return create60Cards();
    }

    private List<PlayingCard> create60Cards() {
        List<PlayingCard> cards = new ArrayList<PlayingCard>();
        for (int i = 0; i < 60; i++) {
            cards.add(new PlayingCard());
        }
        return cards;
    }

    public List<PlayingCard> availableCards() {
        return playingCards;
    }

    public boolean isValid(PlayingCard card) {
        return false;
    }

    public boolean isPresentOnce(PlayingCard card) {
        return false;
    }
}
