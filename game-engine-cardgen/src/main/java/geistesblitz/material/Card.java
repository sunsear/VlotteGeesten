package geistesblitz.material;


public class Card {

	private final Item item1;
	private final Item item2;

	Card(Item item1, Item item2) {
		if (item1 == null || item2 == null) {
			throw new IllegalArgumentException(
					"Every card should contain two images");
		}
		this.item1 = item1;
		this.item2 = item2;
	}

	public boolean depictsItem(Item item) {
		return item1 == item || item2 == item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item1.hashCode() + item2.hashCode();
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
		if (!other.depictsItem(item1)) {
			return false;
		}
		if (!other.depictsItem(item2)) {
			return false;
		}
		return true;
	}

	
	
}
