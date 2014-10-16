package eu.van_dijken.vlottegeesten.engine;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard {

    private List<CardImage> cardImages = new ArrayList<CardImage>();
    private GameToken chosenToken;

    public List<CardImage> images() {
        cardImages.add(new CardImage(TokenColor.Blue, TokenType.Book));
        cardImages.add(new CardImage(TokenColor.Red, TokenType.Bottle));
        return cardImages;
    }

    public boolean correctTokenChosen() {
        GameToken tokenToCheck = chosenToken;
        return isCorrectSolution(tokenToCheck);
    }

    boolean isCorrectSolution(ObjectWithColourAndType tokenToCheck) {
        if (contains(tokenToCheck)) {
            return true;
        }
        for (CardImage image : cardImages) {
            if (image.getColor().equals(tokenToCheck.getColor())) {
                return false;
            }
            if (image.getType().equals(tokenToCheck.getType())) {
                return false;
            }
        }
        return true;
    }

    boolean contains(ObjectWithColourAndType tokenToCheck) {
        for (CardImage image : cardImages) {
            if (image.matches(tokenToCheck)) {
                return true;
            }
        }
        return false;
    }

    public void addImages(List<CardImage> imagesDisplayed) {
        cardImages.addAll(imagesDisplayed);
    }

    public void chooseToken(GameToken gameToken) {
        chosenToken = gameToken;
    }

    public boolean isValid() {
        CardImage cardImage1 = cardImages.get(0);
        CardImage cardImage2 = cardImages.get(1);
        if (cardImage1.getColor().equals(cardImage2.getColor())) {
            return false;
        }
        if (cardImage1.getType().equals(cardImage2.getType())) {
            return false;
        }
        return true;
    }
}
