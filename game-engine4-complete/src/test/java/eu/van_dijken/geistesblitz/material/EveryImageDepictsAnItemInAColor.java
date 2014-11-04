package eu.van_dijken.geistesblitz.material;

import org.junit.Test;

public class EveryImageDepictsAnItemInAColor {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateImageWithoutItem() {
		new Image(null, Color.Red);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateImageWithoutColor() throws Exception {
		new Image(Item.Book, null);
	}

}
