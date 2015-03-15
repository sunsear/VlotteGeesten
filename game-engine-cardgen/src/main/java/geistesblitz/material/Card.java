package geistesblitz.material;

public class Card {

	private final Image image1;
	private final Image image2;
	private final Item desiredItem;

	public Card(Image image1, Image image2, Item desiredItem) {
		this.image1 = image1;
		this.image2 = image2;
		this.desiredItem = desiredItem;	}

	public boolean hasDesiredItem(Item desiredItem) {
		return this.desiredItem == desiredItem;
	}

	public boolean depicts(Item item) {
		return (image1.depicts(item) || image2.depicts(item));
	}

	public Image getImage(Item item) {
		if (image1.depicts(item)) {
			return image1;
		}
		if (image2.depicts(item)) {
			return image2;
		}
		throw new IllegalArgumentException("Item " + item + " is not depicted on this card");
	}

}
