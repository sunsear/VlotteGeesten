package material;

public class Image {
    Color color;
    Item item;

    public Image(Item item, Color color) {
        this.item = item;
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

        if (color != null ? !color.equals(that.color) : that.color != null) {
            return false;
        }
        if (item != null ? !item.equals(that.item) : that.item != null) {
            return false;
        }

        return true;
    }

    public boolean matches(Image that) {
        if (this == that) {
            return true;
        }

        if (color != null ? !color.equals(that.color) : that.color != null) {
            return false;
        }
        if (item != null ? !item.equals(that.item) : that.item != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + color + ", " + item + '}';
    }
}
