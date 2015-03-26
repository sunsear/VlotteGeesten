package geistesblitz.material;

public class Card {

	private final Item desiredItem;
	private final Image image1;
	private final Image image2;

	public Card(Item desiredItem, Image image1, Image image2) {
		if (desiredItem == null || image1 == null || image2 == null) {
			throw new IllegalArgumentException(
					"Every card should depict two items and lead to one desired item.");
		}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + desiredItem.hashCode();
		result = prime * result + image1.hashCode() + image2.hashCode();
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
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		if (desiredItem != other.desiredItem) {
			return false;
		}
		if (image1.equals(other.image1) && image2.equals(other.image2)) {
			return true;
		}
		if (image1.equals(other.image2) && image2.equals(other.image1)) {
			return true;
		}
		return false;
	}

}
