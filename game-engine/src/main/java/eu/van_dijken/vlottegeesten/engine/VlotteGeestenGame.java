package eu.van_dijken.vlottegeesten.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VlotteGeestenGame {

    private final List<GameToken> tokens;
    private final List<PlayingCard> playingCards;
    private final List<String> players = new ArrayList<String>();

    public VlotteGeestenGame() {
        tokens = new ArrayList<GameToken>();
        tokens.add(new GameToken(TokenColor.White, TokenType.Ghost));
        tokens.add(new GameToken(TokenColor.Red, TokenType.Chair));
        tokens.add(new GameToken(TokenColor.Blue, TokenType.Book));
        tokens.add(new GameToken(TokenColor.Green, TokenType.Bottle));
        tokens.add(new GameToken(TokenColor.Gray, TokenType.Mouse));
        playingCards = generateCards();
    }

    private List<PlayingCard> generateCards() {
        List<CardImage> allImages = getAllPossibleCardImages();
        List<PlayingCard> cards = generateAllPotentialPlayingCards(allImages);
        cards = pruneAllNonValidCards(cards);
        shuffleAllCards(cards);
        return limitTo60Cards(cards);
    }

    private void shuffleAllCards(List<PlayingCard> cards) {
        Collections.shuffle(cards);
    }

    private List<PlayingCard> limitTo60Cards(List<PlayingCard> validCards) {
        List<PlayingCard> limitedTo60 = new ArrayList<PlayingCard>();
        for (int i = 0; i < 60; i++) {
            limitedTo60.add(validCards.get(i));
        }
        return limitedTo60;
    }

    private ArrayList<PlayingCard> pruneAllNonValidCards(List<PlayingCard> cards) {
        ArrayList<PlayingCard> validCards = new ArrayList<PlayingCard>();
        for (PlayingCard card : cards) {
            if (isValid(card) && !validCards.contains(card)) {
                validCards.add(card);
            }
        }
        return validCards;
    }

    private ArrayList<PlayingCard> generateAllPotentialPlayingCards(List<CardImage> allImages) {
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        for (CardImage image : allImages) {
            for (CardImage image2 : allImages) {
                PlayingCard playingCard = new PlayingCard();
                playingCard.addImages(image, image2);
                cards.add(playingCard);
            }
        }
        return cards;
    }

    private List<CardImage> getAllPossibleCardImages() {
        List<CardImage> allImages = new ArrayList<CardImage>();
        for (TokenType type : TokenType.values()) {
            for (TokenColor color : TokenColor.values()) {
                allImages.add(new CardImage(color, type));
            }
        }
        return allImages;
    }

    public boolean isValid(PlayingCard cardToCheck) {
        if (!cardToCheck.colorAndTypeOnlyPresentOnce()) {
            return false;
        }
        if (exactlyOneGameTokenOnCard(cardToCheck)) {
            return true;
        }
        return !moreThanOneGameTokenMatchesBecauseNotShownOnCard(cardToCheck);
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
        for (PlayingCard card : playingCards) {
            if (card.equals(cardToCheck)) {
                foundTimes++;
            }
        }
        return foundTimes == 1;
    }

    public void addPlayer(String name) {
        players.add(name);
    }

    public void start() throws NotEnoughPlayersException, TooManyPlayersException {
        if (players.size()<2) {
            throw new NotEnoughPlayersException();
        }
        if (players.size()>8) {
            throw new TooManyPlayersException();
        }
    }
}
