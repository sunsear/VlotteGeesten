package geistesblitz.material;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardDepictsTwoItems {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithFirstImageMissing() throws Exception {
        new Card(null, Item.Mouse);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithSecondImageMissing() {
        new Card(Item.Mouse, null);
	}
}
