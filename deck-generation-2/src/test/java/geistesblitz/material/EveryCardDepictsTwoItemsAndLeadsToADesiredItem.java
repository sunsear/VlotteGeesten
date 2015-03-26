package geistesblitz.material;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardDepictsTwoItemsAndLeadsToADesiredItem {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithDesiredItemMissing() throws Exception {
		new Card(null, new Image(Item.Mouse, Color.Gray), new Image(Item.Book,
				Color.Red));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithFirstImageMissing() throws Exception {
		new Card(Item.Mouse, null, new Image(Item.Book, Color.Red));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithSecondImageMissing() {
		new Card(Item.Mouse, new Image(Item.Book, Color.Red), null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantGetTheColorForAnItemNotDepicted() {
		new Card(Item.Mouse, new Image(Item.Mouse, Color.Gray), new Image(Item.Book,
				Color.Red)).colorDepictedFor(Item.Ghost);
	}

	@Test
	public void orderOfImagesShouldntMatter() {
		Image image1 = new Image(Item.Mouse, Color.Gray);
		Image image2 = new Image(Item.Book, Color.Red);
		assertThat(new Card(Item.Mouse, image1, image2).equals(new Card(Item.Mouse, image2,
				image1)), is(true));
	}

}
