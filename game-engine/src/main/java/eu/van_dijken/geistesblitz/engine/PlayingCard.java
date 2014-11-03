package eu.van_dijken.geistesblitz.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayingCard {

    private final List<CardImage> cardImages = new ArrayList<CardImage>();

    public List<CardImage> images() {
        cardImages.add(new CardImage(Colour.Blue, Shape.Book));
        cardImages.add(new CardImage(Colour.Red, Shape.Bottle));
        return cardImages;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "with images=" + cardImages +
                '}';
    }

    public boolean isDesiredItem(Item item) {
        if (imageIsExactly(item)) {
            return true;
        }
        return !itemTypeOrColorOnAnImage(item);
    }

    boolean itemTypeOrColorOnAnImage(Item item) {
        for (CardImage image : cardImages) {
            if (image.getColor().equals(item.getColor())) {
                return true;
            }
            if (image.getType().equals(item.getType())) {
                return true;
            }
        }
        return false;
    }

    boolean imageIsExactly(Item item) {
        for (CardImage image : cardImages) {
            if (image.getType() == item.getType() && image.getColor() == item.getColor()) {
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
