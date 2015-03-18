package geistesblitz.material;

public class Card {

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

}
