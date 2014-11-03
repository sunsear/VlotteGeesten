package eu.van_dijken.geistesblitz.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayingCard {

    private final List<ObjectWithColourAndType> cardImages = new ArrayList<ObjectWithColourAndType>();

    public List<ObjectWithColourAndType> images() {
        cardImages.add(new ObjectWithColourAndType(Shape.Book, Colour.Blue));
        cardImages.add(new ObjectWithColourAndType(Shape.Bottle, Colour.Red));
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
        for (ObjectWithColourAndType image : cardImages) {
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
        for (ObjectWithColourAndType image : cardImages) {
            if (image.getType() == item.getType() && image.getColor() == item.getColor()) {
                return true;
            }
        }
        return false;
    }

    public void addImages(List<ObjectWithColourAndType> imagesDisplayed) {
        cardImages.addAll(imagesDisplayed);
    }

    public void addImages(ObjectWithColourAndType... imagesDisplayed) {
        cardImages.addAll(Arrays.asList(imagesDisplayed));
    }

    public boolean colorAndTypeOnlyPresentOnce() {
        ObjectWithColourAndType cardImage1 = cardImages.get(0);
        ObjectWithColourAndType cardImage2 = cardImages.get(1);
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

        for (ObjectWithColourAndType image:cardImages){
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
