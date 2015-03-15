package geistesblitz.steps;

import geistesblitz.material.Color;
import geistesblitz.material.Item;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ValidCardsStepDefinitions {


	@Given("^a card for which the desired item is the \"(.*?)\"$")
	public void a_card_for_which_the_desired_item_is_the_gray(Item desiredItem) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^depicting the \"(.*?)\" and the \"(.*?)\"$")
	public void depicting_the_and_the(Item item1, Item item2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in neither \"(.*?)\" nor \"(.*?)\"$")
	public void the_is_depicted_in_and_the_in_neither_nor(Item item1,
			Color color1, Item item2, Color color2, Color color3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in \"(.*?)\" or the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in \"(.*?)\"$")
	public void the_item1_is_depicted_in_color1_and_the_item2_in_color2_or_the_item1_is_depicted_in_color2_and_the_item2_in_color1(
			Item item1, Color color1, Item item2, Color color2, Item item3,
			Color color3, Item item4, Color color4) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
