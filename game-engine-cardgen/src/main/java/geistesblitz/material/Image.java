package geistesblitz.material;

public class Image {

	private Item item;
	private Color color;

	public Image(Item item, Color color) {
		this.item = item;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	boolean depicts(Item item) {
		return this.item == item;
	}

}
