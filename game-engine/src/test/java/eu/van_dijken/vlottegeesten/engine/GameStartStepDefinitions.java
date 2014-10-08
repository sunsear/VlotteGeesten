package eu.van_dijken.vlottegeesten.engine;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GameStartStepDefinitions {

    private VlotteGeestenGame game;

    @Given("^A new game of Vlotte Geesten$")
    public void A_new_game_of_Vlotte_Geesten() {
        game = new VlotteGeestenGame();
    }

    @Then("^the following playing objects should be present:$")
    public void the_following_playing_objects_should_be_present(List<PlayingObject> entries) throws Throwable {
        for (PlayingObject playingObject : entries) {
            assertTrue(game.contains(playingObject));
        }
    }
}
