package geistesblitz.material;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardLeadsToADesiredItem {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithDesiredItemMissing() throws Exception {
		new Card(null);
	}
}
