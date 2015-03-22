package geistesblitz.material;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardDepictsTwoItemsAndLeadsToADesiredItem {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithDesiredItemMissing() throws Exception {
		new Card(null, new Image(Item.Mouse, Color.Gray), new Image(Item.Book, Color.Red));
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
	public void cantGetAnImageForAnItemNotDepicted() {
		new Card(Item.Mouse, new Image(Item.Mouse, Color.Gray), 
				new Image(Item.Book, Color.Red)).getImage(Item.Ghost);
		
	}	
}
