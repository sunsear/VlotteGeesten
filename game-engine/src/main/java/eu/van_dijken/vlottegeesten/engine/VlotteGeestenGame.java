package eu.van_dijken.vlottegeesten.engine;

import java.util.ArrayList;
import java.util.List;

public class VlotteGeestenGame {

    private final List<GameToken> tokens;
    private ArrayList<PlayingCard> playingCards;

    public VlotteGeestenGame() {
        tokens = new ArrayList<GameToken>();
        tokens.add(new GameToken(TokenColor.White, TokenType.Ghost));
        tokens.add(new GameToken(TokenColor.Red, TokenType.Chair));
        tokens.add(new GameToken(TokenColor.Blue, TokenType.Book));
        tokens.add(new GameToken(TokenColor.Green, TokenType.Bottle));
        tokens.add(new GameToken(TokenColor.Gray, TokenType.Mouse));
        playingCards = generateCards();
    }

    private ArrayList<PlayingCard> generateCards() {
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        for (int i = 0; i < 60; i++) {
            PlayingCard playingCard = new PlayingCard();
            List<CardImage> images = new ArrayList<CardImage>();
            images.add(new CardImage(TokenColor.Blue, TokenType.Book));
            images.add(new CardImage(TokenColor.Gray, TokenType.Chair));
            playingCard.addImages(images);
            cards.add(playingCard);
        }
        return cards;
    }

    public boolean isValid(PlayingCard cardToCheck) {
        if (!cardToCheck.colorAndTypeOnlyPresentOnce()) {
            return false;
        }
        if (exactlyOneGameTokenOnCard(cardToCheck)) {
            return true;
        }
        if (moreThanOneGameTokenMatchesBecauseNotShownOnCard(cardToCheck)) {
            return false;
        }
        return true;
    }

    private boolean exactlyOneGameTokenOnCard(PlayingCard cardToCheck) {
        boolean solutionFound = false;
        for (GameToken token : tokens) {
            boolean found = cardToCheck.imageIsExactly(token);
            if (found) {
                if (solutionFound) {
                    return false;
                }
                solutionFound = true;
            }
        }
        return solutionFound;
    }

    private boolean moreThanOneGameTokenMatchesBecauseNotShownOnCard(PlayingCard cardToCheck) {
        boolean solutionFound = false;
        for (GameToken token : tokens) {
            boolean found = !cardToCheck.tokenTypeOrColorOnAnImage(token);
            if (found) {
                if (solutionFound) {
                    return true;
                }
                solutionFound = true;
            }
        }
        return false;
    }

    public boolean contains(GameToken gameToken) {
        return tokens.contains(gameToken);
    }

    public List<PlayingCard> availableCards() {
        return playingCards;
    }

    public boolean isPresentOnce(PlayingCard cardToCheck) {
        int foundTimes = 0;
        for (int i=0;i<playingCards.size();i++) {
            if (playingCards.get(i).equals(cardToCheck)) {
                foundTimes++;
                System.out.println("Found the card:"+foundTimes+":"+i);
            }
        }
        return foundTimes == 1;
    }
}
