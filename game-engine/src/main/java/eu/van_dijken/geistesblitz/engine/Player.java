package eu.van_dijken.geistesblitz.engine;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import material.PlayingCard;

public class Player {
    private final String name;
    private final Set<PlayingCard> wonCards = new HashSet<PlayingCard>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<PlayingCard> getWonCards() {
        return Collections.unmodifiableSet(wonCards);
    }

    public void addToWonCards(PlayingCard cardInRound) {
        wonCards.add(cardInRound);
    }

    public void giveCardTo(Player winner) {
        if (wonCards.size() > 0) {
            PlayingCard playingCard = wonCards.iterator().next();
            wonCards.remove(playingCard);
            winner.addToWonCards(playingCard);
        }
    }
}
