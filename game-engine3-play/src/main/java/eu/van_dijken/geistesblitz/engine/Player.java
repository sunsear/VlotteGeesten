package eu.van_dijken.geistesblitz.engine;

import eu.van_dijken.geistesblitz.material.PlayingCard;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final String name;
    private final Set<PlayingCard> wonCards = new HashSet<PlayingCard>();

    public Player(String name) {
        this.name = name;
    }

    public Set<PlayingCard> getWonCards() {
        return Collections.unmodifiableSet(wonCards);
    }

    public void addToWonCards(PlayingCard cardInRound) {
        wonCards.add(cardInRound);
    }
}
