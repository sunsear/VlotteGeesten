package geistesblitz.steps;

import geistesblitz.material.Card;
import geistesblitz.material.Color;
import geistesblitz.material.Deck;
import geistesblitz.material.Item;

import java.util.ArrayList;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.fail;

public class ValidCardsStepDefinitions {

    private ArrayList<Card> cardsWithCorrectDesiredItem;
	private Card matchingCard;

    @Given("^a card for which the desired item is the \"(.*?)\"$")
    public void a_card_for_which_the_desired_item_is_the(Item desiredItem) {
        cardsWithCorrectDesiredItem = new ArrayList<Card>();
        Deck deck = new Deck();
        Card currentCard;
        while (deck.hasNext()) {
            currentCard = deck.draw();
            //TODO
        }
        if (cardsWithCorrectDesiredItem.size() == 0) {
            fail("No such card available");
        }
    }

    @Given("^depicting the \"(.*?)\" and the \"(.*?)\"$")
    public void depicting_the_and_the(Item item1, Item item2) {
        for (Card card : cardsWithCorrectDesiredItem) {
        	//TODO
        }
    }

	@Then("^the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in neither \"(.*?)\" nor \"(.*?)\"$")
	public void the_is_depicted_in_and_the_in_neither_nor(Item item1,
			Color color1, Item item2, Color color2, Color color3) {
		throw new PendingException();
	}

}
