package eu.van_dijken.vlottegeesten.engine;

import java.util.ArrayList;
import java.util.List;

public class VlotteGeestenGame {

    private final List<PlayingObject> objects;

    public VlotteGeestenGame() {
        objects = new ArrayList<PlayingObject>();
        objects.add(new PlayingObject("White", "Ghost"));
        objects.add(new PlayingObject("Red", "Chair"));
        objects.add(new PlayingObject("Blue", "Book"));
        objects.add(new PlayingObject("Green", "Bottle"));
        objects.add(new PlayingObject("Grey", "Mouse"));
    }

    public boolean contains(PlayingObject playingObject) {
        return objects.contains(playingObject);
    }
}
