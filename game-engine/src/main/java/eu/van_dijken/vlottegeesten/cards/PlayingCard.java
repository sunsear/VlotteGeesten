package eu.van_dijken.vlottegeesten.cards;

import eu.van_dijken.vlottegeesten.engine.GameToken;
import eu.van_dijken.vlottegeesten.engine.ObjectWithColourAndType;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard {

    private List<CardImage> cardImages = new ArrayList<CardImage>();
    private GameToken chosenToken;

    public List<CardImage> images() {
        cardImages.add(new CardImage("Blue", "Toilet"));
        cardImages.add(new CardImage("Red", "Violin"));
        return cardImages;
    }

    public boolean correctTokenChosen() {
        GameToken tokenToCheck = chosenToken;
        return isCorrectSolution(tokenToCheck);
    }

    //TODO: Move to engine and make package protected
    public boolean isCorrectSolution(ObjectWithColourAndType tokenToCheck) {
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

    //TODO: Move to engine and make package protected
    public boolean contains(ObjectWithColourAndType tokenToCheck) {
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
