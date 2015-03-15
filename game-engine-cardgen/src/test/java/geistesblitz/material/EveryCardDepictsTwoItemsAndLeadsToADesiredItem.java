package geistesblitz.material;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardDepictsTwoItemsAndLeadsToADesiredItem {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithDesiredItemMissing() throws Exception {
		new Card(new Image(Item.Mouse, Color.Gray), new Image(Item.Book, Color.Red), null);
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithFirstImageMissing() throws Exception {
		new Card(null, new Image(Item.Book, Color.Red), Item.Mouse);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithSecondImageMissing() {
		new Card(new Image(Item.Book, Color.Red), null, Item.Mouse);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantGetAnImageForAnItemNotDepicted() {
		new Card(new Image(Item.Mouse, Color.Gray), 
				new Image(Item.Book, Color.Red), Item.Mouse).getImage(Item.Ghost);
		
	}	
}
