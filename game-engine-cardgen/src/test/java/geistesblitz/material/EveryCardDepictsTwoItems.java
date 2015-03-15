package geistesblitz.material;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardDepictsTwoItems {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithFirstImageMissing() throws Exception {
        new Card(null, Item.Mouse, Item.Book);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithSecondImageMissing() {
        new Card(Item.Mouse, null, Item.Book);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithDesiredItemMissing() {
        new Card(Item.Mouse, Item.Book, null);
	}
}
