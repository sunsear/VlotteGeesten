package eu.van_dijken.geistesblitz.material;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard {

    private final List<Image> cardImages = new ArrayList<Image>();

    public List<Image> images() {
        return cardImages;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "with images=" + cardImages +
                '}';
    }

    public boolean isDesiredItem(Item item) {
        return false;
    }

    public void addImages(List<Image> imagesDisplayed) {

    }
}
