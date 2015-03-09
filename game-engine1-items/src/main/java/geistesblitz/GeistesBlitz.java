package geistesblitz;

import java.util.ArrayList;
import java.util.List;

import static geistesblitz.ItemType.*;
import static geistesblitz.Color.*;

/**
 * This class contains the game logic
 */
public class GeistesBlitz {

    public static List items() {
        ArrayList items = new ArrayList();
        items.add(new Item(White, Ghost));
        items.add(new Item(Red, Chair));
        items.add(new Item(Gray, Mouse));
        items.add(new Item(Blue, Book));
        items.add(new Item(Green, Bottle));
        return items;
    }
}
