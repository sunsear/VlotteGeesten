package eu.van_dijken.vlottegeesten.cards;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eu.van_dijken.vlottegeesten.engine.GameToken;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayingCardStepdefs {
    private PlayingCard card;

    @Given("^A random Playing Card$")
    public void A_random_Playing_Card() throws Throwable {
        this.card = new PlayingCard();
    }

    @Then("^it should contain (\\d+) images$")
    public void it_should_contain_images(int numImagesOnCard) throws Throwable {
        assertEquals(numImagesOnCard, card.images().size());
    }

    @Given("^a playing card with tokens displayed:$")
    public void a_playing_card_with_tokens_displayed(List<CardImage> imagesDisplayed) throws Throwable {
        this.card = new PlayingCard();
        card.addImages(imagesDisplayed);
    }

    @When("^the player chooses game token:$")
    public void the_player_chooses_game_token(List<GameToken> objectsChosen) throws Throwable {
        card.chooseToken(objectsChosen.get(0));
    }

    @Then("^that is the correct solution$")
    public void that_is_the_correct_solution() throws Throwable {
        assertTrue(card.correctTokenChosen());
    }

    @Then("^that is not the correct solution$")
    public void that_is_not_the_correct_solution() throws Throwable {
        assertFalse(card.correctTokenChosen());
    }
}
