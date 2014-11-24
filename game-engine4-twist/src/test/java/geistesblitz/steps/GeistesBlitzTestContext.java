package geistesblitz.steps;

import geistesblitz.engine.GeistesBlitz;
import geistesblitz.material.PlayingCard;

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
