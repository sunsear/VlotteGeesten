package eu.van_dijken.vlottegeesten.engine;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameStartStepDefinitions {

    private VlotteGeestenGame game;

    @Given("^A new game of Vlotte Geesten$")
    public void A_new_game_of_Vlotte_Geesten() {
        game = new VlotteGeestenGame();
    }

    @Then("^the following game tokens should be present:$")
    public void the_following_game_tokens_should_be_present(List<GameToken> entries) throws Throwable {
        for (GameToken gameToken : entries) {
            assertTrue(game.contains(gameToken));
        }
    }

    @Then("^the following game tokens should not be present:$")
    public void the_following_game_tokens_should_not_be_present(List<GameToken> entries) throws Throwable {
        for (GameToken gameToken : entries) {
            assertFalse(game.contains(gameToken));
        }
    }

    @Then("^the deck should contain (\\d+) cards$")
    public void the_deck_should_contain_cards(int numCards) throws Throwable {
        assertEquals(numCards, game.availableCards().size());
    }

}
