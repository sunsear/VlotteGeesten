package geistesblitz.steps;

import geistesblitz.material.Item;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class DeckStepDefinitions {

	@Then("^there should be a deck of (\\d+) different valid cards$")
	public void there_should_be_a_deck_of_different_valid_cards(int numberOfCards) {
	    throw new PendingException();
	}

	@Then("^there should be (\\d+) cards showing ([^\" ]*) and ([^\" ]*)$")
	public void there_should_be_cards_showing_item1_and_item2(
			int numberOfCards, Item item1, Item item2) {
	    throw new PendingException();
	}

	@Then("^there should be (\\d+) card showing ([^\" ]*) and ([^\" ]*) for which the desired item is ([^\" ]*)$")
	public void there_should_be_card_showing_item1_and_item2_for_which_the_desired_item_is_item1(
			int numberOfCards, Item item1, Item item2, Item desiredItem) {
	    throw new PendingException();
	}

	@Then("^there should be at least (\\d+) card showing ([^\" ]*) and ([^\" ]*) for which the desired item is ([^\" ]*)$")
	public void there_should_be_at_least_card_showing_item1_and_item2_for_which_the_desired_item_is_item3(
			int numberOfCards, Item item1, Item item2, Item desiredItem) {
	    throw new PendingException();
	}

	@Then("^there should be (\\d+) cards for which the desired item is ([^\" ]*)$")
	public void there_should_be_cards_for_which_the_desired_item_is_item1(
			int numberOfCards, Item desiredItem) {
	    throw new PendingException();
	}

}
