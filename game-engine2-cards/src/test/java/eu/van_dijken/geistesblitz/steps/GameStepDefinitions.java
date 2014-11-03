package eu.van_dijken.geistesblitz.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import eu.van_dijken.geistesblitz.engine.GeistesBlitz;
import eu.van_dijken.geistesblitz.material.Color;
import eu.van_dijken.geistesblitz.material.Item;
import eu.van_dijken.geistesblitz.material.PlayingCard;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GameStepDefinitions {
    private final GeistesBlitzTestContext context = GeistesBlitzTestContext.getInstance();
    GeistesBlitz anotherGame;
    private PlayingCard shownCard;

    @Given("^a new game of GeistesBlitz$")
    public void a_new_game_of_GeistesBlitz() {
        context.setGame(new GeistesBlitz());
    }

    @Then("^there should be (\\d+) items present$")
    public void there_should_be_items_present(int number) {
        assertThat(Item.values().length, is(number));
    }

    @Then("^the following items should be present:$")
    public void the_following_game_items_should_be_present(List<ItemDescription> entries) {
        for (ItemDescription itemDescription : entries) {
            assertThat(Item.valueOf(itemDescription.getType()).color(), is(itemDescription.getColor()));
        }
    }

    @Then("^the deck should contain (\\d+) cards$")
    public void the_deck_should_contain_cards(int numCards) throws Throwable {
        assertEquals(numCards, context.getGame().availableCards().size());
    }

    @Then("^that card is not valid according to game rules$")
    public void that_card_is_not_valid_according_to_game_rules() throws Throwable {
        assertFalse(context.getGame().isValid(context.getCard()));
    }

    @Then("^that card is valid according to game rules$")
    public void that_card_is_valid_according_to_game_rules() throws Throwable {
        assertTrue(context.getGame().isValid(context.getCard()));
    }

    @Then("^the deck should contain (\\d+) valid cards$")
    public void the_deck_should_contain_valid_cards(int arg1) throws Throwable {
        for (PlayingCard card : context.getGame().availableCards()) {
            assertTrue("Playing Card " + card + " is not valid.", context.getGame().isValid(card));
        }
    }

    @Then("^the deck should contain (\\d+) unique cards$")
    public void the_deck_should_contain_unique_cards(int arg1) throws Throwable {
        for (PlayingCard card : context.getGame().availableCards()) {
            assertTrue(card + " is present in the deck more than once.", context.getGame().isPresentOnce(card));
        }
    }

    @Given("^another new game$")
    public void another_new_game() throws Throwable {
        anotherGame = new GeistesBlitz();
    }

    @Then("^the decks of the two games should contain cards in a different order$")
    public void the_decks_of_the_two_games_should_contain_cards_in_a_different_order() throws Throwable {
        assertNotEquals(context.getGame().availableCards(), anotherGame.availableCards());
    }

    public class ItemDescription {
        Color color;
        String type;

        public ItemDescription(String type, Color color) {
            this.type = type;
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public String getType() {
            return type;
        }
    }

}
