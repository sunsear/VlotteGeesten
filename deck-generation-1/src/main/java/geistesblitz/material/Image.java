package geistesblitz.material;

public class Image {

	private final Item item;
	private final Color color;
	
	public Image(Item item, Color color) {
		this.item = item;
		this.color = color;
	}

	public boolean depicts(Item item) {
		return item == this.item;
	}

	public Color depictedColor() {
		return color;
	}

}
