package geistesblitz.material;

public class Card {

    public Item getDepictedItem1() {
        return depictedItem1;
    }

    public Color getDepictedColor1() {
        return depictedColor1;
    }

    public Item getDepictedItem2() {
        return depictedItem2;
    }

    public Color getDepictedColor2() {
        return depictedColor2;
    }

    private final Item depictedItem1 = Item.Mouse;
    private final Color depictedColor1 = Color.Gray;
    private final Item depictedItem2 = Item.Ghost;
    private final Color depictedColor2 = Color.Green;
    private final Item desiredItem;

    public Card(Item desiredItem) {
        if (desiredItem == null) {
            throw new IllegalArgumentException(
                    "Every card should lead to one desired item.");
        }
        this.desiredItem = desiredItem;
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

    public boolean depicts(Item item) {
        return depictedItem1 == item || depictedItem2 == item;
    }
}
