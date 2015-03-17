package geistesblitz.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import geistesblitz.material.Card;
import geistesblitz.material.Color;
import geistesblitz.material.Deck;
import geistesblitz.material.Item;

import java.util.ArrayList;

public class ValidCardsStepDefinitions {

    private ArrayList<Card> cardsWithCorrectDesiredItem;

    @Given("^a card for which the desired item is the \"(.*?)\"$")
    public void a_card_for_which_the_desired_item_is_the(Item desiredItem) {
        cardsWithCorrectDesiredItem = new ArrayList<Card>();
        Deck deck = new Deck();
        Card currentCard;
        while (deck.hasNext()) {
            currentCard = deck.draw();
            if (currentCard.hasDesiredItem(desiredItem)) {
                cardsWithCorrectDesiredItem.add(currentCard);
            }
        }
        if (cardsWithCorrectDesiredItem.size() == 0) {
            throw new Error("No such card available");
        }
    }

    @Given("^depicting the \"(.*?)\" and the \"(.*?)\"$")
    public void depicting_the_and_the(Item item1, Item item2) {
        throw new PendingException();
    }

    @Then("^the \"(.*?)\" is depicted in \"(.*?)\" and the \"(.*?)\" in neither \"(.*?)\" nor \"(.*?)\"$")
    public void the_is_depicted_in_and_the_in_neither_nor(Item item1,
                                                          Color color1, Item item2, Color color2, Color color3) {
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
