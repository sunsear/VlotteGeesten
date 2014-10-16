package eu.van_dijken.vlottegeesten.engine;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public String toString() {
        return "PlayingCard{" +
                "with images=" + cardImages +
                '}';
    }

    boolean isCorrectSolution(ObjectWithColourAndType tokenToCheck) {
        if (imageIsExactly(tokenToCheck)) {
            return true;
        }
        if (tokenTypeOrColorOnAnImage(tokenToCheck)) {
            return false;
        }
        return true;
    }

    boolean tokenTypeOrColorOnAnImage(ObjectWithColourAndType tokenToCheck) {
        for (CardImage image : cardImages) {
            if (image.getColor().equals(tokenToCheck.getColor())) {
                return true;
            }
            if (image.getType().equals(tokenToCheck.getType())) {
                return true;
            }
        }
        return false;
    }

    boolean imageIsExactly(ObjectWithColourAndType tokenToCheck) {
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

    public void addImages(CardImage... imagesDisplayed) {
        cardImages.addAll(Arrays.asList(imagesDisplayed));
    }

    public void chooseToken(GameToken gameToken) {
        chosenToken = gameToken;
    }

    public boolean colorAndTypeOnlyPresentOnce() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayingCard that = (PlayingCard) o;

        for (CardImage image:cardImages){
            if (!that.cardImages.contains(image)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return cardImages.hashCode();
    }
}
