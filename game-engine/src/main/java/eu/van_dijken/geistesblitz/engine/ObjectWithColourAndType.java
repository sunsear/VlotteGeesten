package eu.van_dijken.geistesblitz.engine;

public class ObjectWithColourAndType {
    ItemColor color;
    ItemType type;

    public ObjectWithColourAndType(ItemType type, ItemColor color) {
        this.type = type;
        this.color = color;
    }

    public ItemColor getColor() {
        return color;
    }

    public void setColor(ItemColor color) {
        this.color = color;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ObjectWithColourAndType that = (ObjectWithColourAndType) o;

        if (color != null ? !color.equals(that.color) : that.color != null) {
            return false;
        }
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }

        return true;
    }

    public boolean matches(ObjectWithColourAndType that) {
        if (this == that) {
            return true;
        }

        if (color != null ? !color.equals(that.color) : that.color != null) {
            return false;
        }
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + color + ", " + type + '}';
    }
}