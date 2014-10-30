package eu.van_dijken.vlottegeesten.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRound {
    private final PlayingCard shownCard;
    private final List<Solution> solutions = new ArrayList<Solution>();
    private Player winner;
    private List<Player> losers;

    public GameRound(PlayingCard playingCard) {
        shownCard = playingCard;
    }

    public PlayingCard getShownCard() {
        return shownCard;
    }

    public void provideSolution(Player player, GameToken gameToken) {
        solutions.add(new Solution(player, gameToken));
    }

    public List<Solution> getSolutions() {
        return Collections.unmodifiableList(solutions);
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
        for (Solution solution : getSolutions()) {
            if (getShownCard().isCorrectSolution(solution.getGameToken()) && winner == null) {
                winner = solution.getPlayer();
            } else {
                losers.add(solution.getPlayer());
            }
        }
    }

    class Solution {
        private final Player player;
        private final GameToken gameToken;

        public Solution(Player player, GameToken gameToken) {
            this.player = player;
            this.gameToken = gameToken;
        }

        public GameToken getGameToken() {
            return gameToken;
        }

        public Player getPlayer() {
            return player;
        }
    }
}
