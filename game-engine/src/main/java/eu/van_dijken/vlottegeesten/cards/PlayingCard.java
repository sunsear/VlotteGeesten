package eu.van_dijken.vlottegeesten.cards;

import eu.van_dijken.vlottegeesten.engine.GameToken;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard {

    private List<CardImage> cardImages = new ArrayList<CardImage>();
    private GameToken chosenToken;

    public List<CardImage> images() {
        cardImages.add(new CardImage("Blue","Toilet"));
        cardImages.add(new CardImage("Red", "Violin"));
        return cardImages;
    }

    public boolean correctTokenChosen() {
        for(CardImage image:cardImages){
            if (image.matches(chosenToken)){
                return true;
            }
        }
        for(CardImage image:cardImages){
            if (image.getColor().equals(chosenToken.getColor())){
                return false;
            }
            if (image.getType().equals(chosenToken.getType())){
                return false;
            }
        }
        return true;
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
        if (cardImage1.getColor().equals(cardImage2.getColor())){
            return false;
        }
        if (cardImage1.getType().equals(cardImage2.getType())){
            return false;
        }
        return true;
    }
}
