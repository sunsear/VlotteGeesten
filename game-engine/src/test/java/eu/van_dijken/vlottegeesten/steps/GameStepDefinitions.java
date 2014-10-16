package eu.van_dijken.vlottegeesten.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import eu.van_dijken.vlottegeesten.engine.GameToken;
import eu.van_dijken.vlottegeesten.engine.VlotteGeestenGame;

import java.util.List;

import static org.junit.Assert.*;

public class GameStepDefinitions {
    private VlotteGeestenTestContext context = VlotteGeestenTestContext.getInstance();

    @Given("^a new game of Vlotte Geesten$")
    public void a_new_game_of_Vlotte_Geesten() {
        context.setGame( new VlotteGeestenGame());
    }

    @Then("^the following game tokens should be present:$")
    public void the_following_game_tokens_should_be_present(List<GameToken> entries) throws Throwable {
        for (GameToken gameToken : entries) {
            assertTrue(context.getGame().contains(gameToken));
        }
    }

    @Then("^the following game tokens should not be present:$")
    public void the_following_game_tokens_should_not_be_present(List<GameToken> entries) throws Throwable {
        for (GameToken gameToken : entries) {
            assertFalse(context.getGame().contains(gameToken));
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
}