package eu.van_dijken.vlottegeesten.steps;

import eu.van_dijken.vlottegeesten.cards.PlayingCard;
import eu.van_dijken.vlottegeesten.engine.VlotteGeestenGame;

public class VlotteGeestenTestContext {
    private static VlotteGeestenTestContext instance;
    private PlayingCard card;
    private VlotteGeestenGame game;

    public static VlotteGeestenTestContext getInstance() {
        if (instance==null){
            instance = new VlotteGeestenTestContext();
        }
        return instance;
    }

    public VlotteGeestenGame getGame() {
        return game;
    }

    public void setGame(VlotteGeestenGame game) {
        this.game = game;
    }

    public PlayingCard getCard() {
        return card;
    }

    public void setCard(PlayingCard card) {
        this.card = card;
    }

}
