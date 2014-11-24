package geistesblitz.material;

public class Image {
    Color color;
    Item item;

    public Image(Item item, Color color) {
		if (item == null || color == null) {
			throw new IllegalArgumentException("Every image should depict an item in a color");
		}        this.item = item;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Item getItem() {
        return item;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Image that = (Image) o;

        if (!color.equals(that.color)) {
            return false;
        }
        if (!item.equals(that.item)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * color.hashCode() + item.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + color + ", " + item + '}';
    }
}
