package geistesblitz;

/**
 * Created by sunsear on 09-03-15.
 */
public class Card {
    private ItemType item1;
    private ItemType item2;

    public Card(ItemType item1, ItemType item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public boolean shows(ItemType item1, ItemType item2) {
        return item1 == this.item1 || item1 == this.item2 || item2 == this.item1 || item2 == this.item2;
    }
}
