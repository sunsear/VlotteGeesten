package eu.van_dijken.geistesblitz.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayingCard {

    private final List<Image> cardImages = new ArrayList<Image>();

    public List<Image> images() {
        cardImages.add(new Image(Item.Book, Colour.Blue));
        cardImages.add(new Image(Item.Bottle, Colour.Red));
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
        for (Image image : cardImages) {
            if (image.getColor().equals(item.getColor())) {
                return true;
            }
            if (image.getItem().equals(item)) {
                return true;
            }
        }
        return false;
    }

    boolean imageIsExactly(Item item) {
        for (Image image : cardImages) {
            if (image.getItem() == item && image.getColor() == item.getColor()) {
                return true;
            }
        }
        return false;
    }

    public void addImages(List<Image> imagesDisplayed) {
        cardImages.addAll(imagesDisplayed);
    }

    public void addImages(Image... imagesDisplayed) {
        cardImages.addAll(Arrays.asList(imagesDisplayed));
    }

    public boolean colorAndTypeOnlyPresentOnce() {
        Image cardImage1 = cardImages.get(0);
        Image cardImage2 = cardImages.get(1);
        if (cardImage1.getColor().equals(cardImage2.getColor())) {
            return false;
        }
        if (cardImage1.getItem().equals(cardImage2.getItem())) {
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

        for (Image image:cardImages){
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
