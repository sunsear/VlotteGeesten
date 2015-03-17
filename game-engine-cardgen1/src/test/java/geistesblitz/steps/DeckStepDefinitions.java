package geistesblitz.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import geistesblitz.material.Card;
import geistesblitz.material.Deck;
import geistesblitz.material.Item;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeckStepDefinitions {

	@Then("^there should be a deck of (\\d+) different valid cards$")
	public void there_should_be_a_deck_of_different_valid_cards(int numberOfCards) {
		Deck deck = new Deck();
		Set<Card> cards = new HashSet<Card>();
		while (deck.hasNext()) {
			cards.add(deck.draw());
		}
		assertThat(cards.size(), is(numberOfCards));
	}

	@Then("^there should be (\\d+) cards showing ([^\" ]*) and ([^\" ]*)$")
	public void there_should_be_cards_showing_item1_and_item2(
			int numberOfCards, Item item1, Item item2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^there should be (\\d+) card showing ([^\" ]*) and ([^\" ]*) for which the desired item is ([^\" ]*)$")
	public void there_should_be_card_showing_item1_and_item2_for_which_the_desired_item_is_item1(
			int numberOfCards, Item item1, Item item2, Item desiredItem) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^there should be at least (\\d+) card showing ([^\" ]*) and ([^\" ]*) for which the desired item is ([^\" ]*)$")
	public void there_should_be_at_least_card_showing_item1_and_item2_for_which_the_desired_item_is_item3(
			int numberOfCards, Item item1, Item item2, Item desiredItem) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^there should be (\\d+) cards for which the desired item is ([^\" ]*)$")
	public void there_should_be_cards_for_which_the_desired_item_is_item1(
			int numberOfCards, Item desiredItem) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
