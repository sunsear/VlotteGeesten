package eu.van_dijken.vlottegeesten.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eu.van_dijken.vlottegeesten.engine.CardImage;
import eu.van_dijken.vlottegeesten.engine.Item;
import eu.van_dijken.vlottegeesten.engine.PlayingCard;

import java.util.List;

import static org.junit.Assert.*;

public class PlayingCardStepdefs {
    private final VlotteGeestenTestContext context = VlotteGeestenTestContext.getInstance();

    @Given("^A random Playing Card$")
    public void A_random_Playing_Card() throws Throwable {
        context.setCard(new PlayingCard());
    }

    @Then("^it should contain (\\d+) images$")
    public void it_should_contain_images(int numImagesOnCard) throws Throwable {
        assertEquals(numImagesOnCard, context.getCard().images().size());
    }

    @Given("^a playing card with items displayed:$")
    public void a_playing_card_with_items_displayed(List<CardImage> imagesDisplayed) throws Throwable {
        context.setCard(new PlayingCard());
        context.getCard().addImages(imagesDisplayed);
    }

    @When("^the player chooses game item:$")
    public void the_player_chooses_game_item(List<Item> objectsChosen) throws Throwable {
        context.getCard().chooseItem(objectsChosen.get(0));
    }

    @Then("^that is the correct solution$")
    public void that_is_the_correct_solution() throws Throwable {
        assertTrue(context.getCard().correctItemChosen());
    }

    @Then("^that is not the correct solution$")
    public void that_is_not_the_correct_solution() throws Throwable {
        assertFalse(context.getCard().correctItemChosen());
    }

}
