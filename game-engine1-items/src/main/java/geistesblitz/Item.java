package geistesblitz;

/**
 * Implementation after 13 minutes
 */
public class Item {
    private final Color color;

    private final ItemType item;

    public Item(Color color, ItemType item) {

        this.color = color;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item1 = (Item) o;

        if (color != null ? !color.equals(item1.color) : item1.color != null) return false;
        if (item != null ? !item.equals(item1.item) : item1.item != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }

}
