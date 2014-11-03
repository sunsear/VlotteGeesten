package eu.van_dijken.geistesblitz.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayingCard {

    private final List<CardImage> cardImages = new ArrayList<CardImage>();

    public List<CardImage> images() {
        cardImages.add(new CardImage(ItemColor.Blue, ItemType.Book));
        cardImages.add(new CardImage(ItemColor.Red, ItemType.Bottle));
        return cardImages;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "with images=" + cardImages +
                '}';
    }

    public boolean isCorrectSolution(ObjectWithColourAndType itemToCheck) {
        if (imageIsExactly(itemToCheck)) {
            return true;
        }
        return !itemTypeOrColorOnAnImage(itemToCheck);
    }

    boolean itemTypeOrColorOnAnImage(ObjectWithColourAndType itemToCheck) {
        for (CardImage image : cardImages) {
            if (image.getColor().equals(itemToCheck.getColor())) {
                return true;
            }
            if (image.getType().equals(itemToCheck.getType())) {
                return true;
            }
        }
        return false;
    }

    boolean imageIsExactly(ObjectWithColourAndType itemToCheck) {
        for (CardImage image : cardImages) {
            if (image.matches(itemToCheck)) {
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
