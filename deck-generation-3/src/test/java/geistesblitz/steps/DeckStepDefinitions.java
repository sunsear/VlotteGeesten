package geistesblitz.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
import geistesblitz.material.Card;
import geistesblitz.material.Deck;
import geistesblitz.material.Item;

import java.util.HashSet;
import java.util.Set;

import cucumber.api.java.en.Then;

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

	@Then("^there should be (\\d+) cards depicting ([^\" ]*) and ([^\" ]*)$")
	public void there_should_be_cards_depicting_item1_and_item2(
			int numberOfCards, Item item1, Item item2) {
		Deck deck = new Deck();
		int found = 0;
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.depicts(item1) && card.depicts(item2)) {
				found++;
			}
		}
		assertThat(found, is(numberOfCards));
	}

	@Then("^there should be (\\d+) card depicting ([^\" ]*) and ([^\" ]*) for which the desired item is ([^\" ]*)$")
	public void there_should_be_card_depicting_item1_and_item2_for_which_the_desired_item_is_item1(
			int numberOfCards, Item item1, Item item2, Item desiredItem) {
		Deck deck = new Deck();
		int found = 0;
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.depicts(item1) && card.depicts(item2)
					&& card.hasDesiredItem(desiredItem)) {
				found++;
			}
		}
		assertThat(found, is(numberOfCards));
	}

	@Then("^there should be at least (\\d+) card showing ([^\" ]*) and ([^\" ]*) for which the desired item is ([^\" ]*)$")
	public void there_should_be_at_least_card_showing_item1_and_item2_for_which_the_desired_item_is_item3(
			int numberOfCards, Item item1, Item item2, Item desiredItem) {
		Deck deck = new Deck();
		int found = 0;
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.depicts(item1) && card.depicts(item2)
					&& card.hasDesiredItem(desiredItem)) {
				found++;
			}
		}
		assertThat(found, is(greaterThanOrEqualTo(numberOfCards)));
	}

	@Then("^there should be (\\d+) cards for which the desired item is ([^\" ]*)$")
	public void there_should_be_cards_for_which_the_desired_item_is_item1(
			int numberOfCards, Item desiredItem) {
		Deck deck = new Deck();
		int found = 0;
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.hasDesiredItem(desiredItem)) {
				found++;
			}
		}
		assertThat(found, is(numberOfCards));
	}

}
