package geistesblitz.material;

public class Image {

	private Item item;
	private Color color;

	public Image(Item item, Color color) {
		if (item == null || color == null) {
			throw new IllegalArgumentException("Every image should depict an item in a color");
		}
		this.item = item;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	boolean depicts(Item item) {
		return this.item == item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color.hashCode();
		result = prime * result + item.hashCode();
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
		if (!(obj instanceof Image)) {
			return false;
		}
		Image other = (Image) obj;
		if (color != other.color) {
			return false;
		}
		if (item != other.item) {
			return false;
		}
		return true;
	}
	
	

}
