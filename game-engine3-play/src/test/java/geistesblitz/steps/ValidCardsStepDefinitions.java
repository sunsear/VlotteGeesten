package geistesblitz.steps;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import geistesblitz.material.Card;
import geistesblitz.material.Color;
import geistesblitz.material.Deck;
import geistesblitz.material.Item;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ValidCardsStepDefinitions {

	private Item desiredItem;
	private Card card;

	@Given("^a card for which the desired item is the \"(.*?)\"$")
	public void a_card_for_which_the_desired_item_is_the_gray(Item desiredItem) {
		this.desiredItem = desiredItem;
	}

	@Given("^depicting the \"(.*?)\" and the \"(.*?)\"$")
	public void depicting_the_and_the(Item item1, Item item2) {
		Deck deck = new Deck();
		while (deck.hasNext()) {
			Card thisOne = deck.draw();
			if (thisOne.desiredItem() == desiredItem
					&& thisOne.depictsItem(item1) && thisOne.depictsItem(item2)) {
				card = thisOne;
			}
		}
	}

	@Then("^the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in neither \"(.*?)\" nor \"(.*?)\"$")
	public void the_is_depicted_in_and_the_in_neither_nor(Item item1,
			Color color1, Item item2, Color color2, Color color3) {
		assertThat(card.getImage(item1).getColor(), is(color1));
		Color colorOfItem2 = card.getImage(item2).getColor();
		assertThat(colorOfItem2, is(not(color2)));
		assertThat(colorOfItem2, is(not(color3)));
	}

	@Then("^the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in \"(.*?)\" or the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in \"(.*?)\"$")
	public void the_item1_is_depicted_in_color1_and_the_item2_in_color2_or_the_item1_is_depicted_in_color2_and_the_item2_in_color1(
			Item item1, Color color1, Item item2, Color color2, Item item3,
			Color color3, Item item4, Color color4) {
		Color colorOfItem1 = card.getImage(item1).getColor();
		Color colorOfItem2 = card.getImage(item2).getColor();
		assertThat(colorOfItem1, is(anyOf(is(color1), is(color3))));
		assertThat(colorOfItem2, is(anyOf(is(color2), is(color4))));
		assertThat(colorOfItem1, is(not(colorOfItem2)));
	}

}
