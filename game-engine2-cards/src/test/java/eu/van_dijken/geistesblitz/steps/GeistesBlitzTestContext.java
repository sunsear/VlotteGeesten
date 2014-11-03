package eu.van_dijken.geistesblitz.steps;

import eu.van_dijken.geistesblitz.engine.GeistesBlitz;
import eu.van_dijken.geistesblitz.material.PlayingCard;

public class GeistesBlitzTestContext {
    private static GeistesBlitzTestContext instance;
    private PlayingCard card;
    private GeistesBlitz game;

    public static GeistesBlitzTestContext getInstance() {
        if (instance==null){
            instance = new GeistesBlitzTestContext();
        }
        return instance;
    }

    public GeistesBlitz getGame() {
        return game;
    }

    public void setGame(GeistesBlitz game) {
        this.game = game;
    }

    public PlayingCard getCard() {
        return card;
    }

    public void setCard(PlayingCard card) {
        this.card = card;
    }

}
