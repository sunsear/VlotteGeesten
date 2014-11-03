package eu.van_dijken.geistesblitz.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import material.Item;
import material.PlayingCard;

public class GameRound {
    private final PlayingCard shownCard;
    private final List<AnAnswer> answersGiven = new ArrayList<AnAnswer>();
    private Player winner;
    private List<Player> losers;

    public GameRound(PlayingCard playingCard) {
        shownCard = playingCard;
    }

    public PlayingCard getShownCard() {
        return shownCard;
    }

    public void provideAnswer(Player player, Item item) {
        answersGiven.add(new AnAnswer(player, item));
    }

    public List<AnAnswer> getAnswersGiven() {
        return Collections.unmodifiableList(answersGiven);
    }

    Player getWinner() {
        finishRoundIfNecessary();
        return winner;
    }

    public List<Player> getLosers() {
        finishRoundIfNecessary();
        return losers;
    }

    private void finishRoundIfNecessary() {
        if (losers == null && winner == null) {
            determineRoundWinnerAndLosers();
        }
    }

    void determineRoundWinnerAndLosers() {
        losers = new ArrayList<Player>();
        for (AnAnswer answer : getAnswersGiven()) {
            if (getShownCard().isDesiredItem(answer.getItem()) && winner == null) {
                winner = answer.getPlayer();
            } else {
                losers.add(answer.getPlayer());
            }
        }
    }

    class AnAnswer {
        private final Player player;
        private final Item item;

        public AnAnswer(Player player, Item item) {
            this.player = player;
            this.item = item;
        }

        public Item getItem() {
            return item;
        }

        public Player getPlayer() {
            return player;
        }
    }
}
