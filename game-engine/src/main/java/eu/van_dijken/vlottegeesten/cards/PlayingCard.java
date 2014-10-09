package eu.van_dijken.vlottegeesten.cards;

import eu.van_dijken.vlottegeesten.engine.PlayingObject;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard {

    private List<CardImage> cardImages = new ArrayList<CardImage>();
    private PlayingObject chosenObject;

    public List<CardImage> images() {
        cardImages.add(new CardImage("Blue","Toilet"));
        cardImages.add(new CardImage("Red", "Violin"));
        return cardImages;
    }

    public boolean correctObjectChosen() {
        for(CardImage image:cardImages){
            if (image.matches(chosenObject)){
                return true;
            }
        }
        return false;
    }

    public void addImages(List<CardImage> imagesDisplayed) {
        cardImages.addAll(imagesDisplayed);
    }

    public void chooseObject(PlayingObject playingObject) {
        chosenObject = playingObject;
    }
}
