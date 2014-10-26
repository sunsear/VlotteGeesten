package eu.van_dijken.vlottegeesten.engine;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private String name;
    private Set<PlayingCard> wonCards = new HashSet<PlayingCard>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<PlayingCard> getWonCards() {
        return Collections.unmodifiableSet(wonCards);
    }

    void addToWonCards(PlayingCard cardInRound) {
        wonCards.add(cardInRound);
    }
}
