package geistesblitz.material;

public class Card {

	private final Item desiredItem;
	private final Image image1;
	private final Image image2;

	public Card(Item desiredItem, Image image1, Image image2) {
		this.desiredItem = desiredItem;
		this.image1 = image1;
		this.image2 = image2;
	}

	public boolean hasDesiredItem(Item item) {
		return item == desiredItem;
	}

	public boolean depicts(Item item) {
		return image1.depicts(item) || image2.depicts(item);
	}

	public Color colorDepictedFor(Item item) {
		if (image1.depicts(item)) return image1.depictedColor();
		if (image2.depicts(item)) return image2.depictedColor();
		throw new IllegalArgumentException("Item" + item + "is not depicted");
	}

}
