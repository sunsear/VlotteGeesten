package eu.van_dijken.vlottegeesten.engine;

public class ObjectWithColourAndType {
    String color;
    String type;

    public ObjectWithColourAndType(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
}
