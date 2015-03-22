package geistesblitz.material;

public class Card {

    private final Item desiredItem;
    private Item item1;
    private Item item2;
    private Color color1;
    private Color color2;

    public Card(Item desiredItem, Item item1, Color color1, Item item2, Color color2) {
        if (desiredItem == null) {
            throw new IllegalArgumentException(
                    "Every card should lead to one desired item.");
        }
        this.desiredItem = desiredItem;
        this.item1 = item1;
        this.color1 = color1;
        this.item2 = item2;
        this.color2 = color2;
    }

    public boolean hasDesiredItem(Item desiredItem) {
        return this.desiredItem == desiredItem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + desiredItem.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        if (desiredItem != other.desiredItem) {
            return false;
        }
        return false;
    }

    public boolean depicts(Item item1, Item item2) {
        return depicts(item1) && depicts(item2);
    }

    public boolean depictsInColor(Item item, Color color) {
        return item1 == item && color1 == color || item2 == item && color2 == color;
    }

    private boolean depicts(Item item) {
        return this.item1 == item || this.item2 == item;
    }
}
