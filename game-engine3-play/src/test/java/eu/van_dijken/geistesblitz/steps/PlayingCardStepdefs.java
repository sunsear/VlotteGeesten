package eu.van_dijken.geistesblitz.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import eu.van_dijken.geistesblitz.material.Color;
import eu.van_dijken.geistesblitz.material.Image;
import eu.van_dijken.geistesblitz.material.Item;
import eu.van_dijken.geistesblitz.material.PlayingCard;

import java.util.List;

import static org.junit.Assert.*;

public class PlayingCardStepdefs {
    private final GeistesBlitzTestContext context = GeistesBlitzTestContext.getInstance();

    @Given("^A random Playing Card$")
    public void A_random_Playing_Card() throws Throwable {
        context.setCard(new PlayingCard());
    }

    @Then("^it should contain (\\d+) images$")
    public void it_should_contain_images(int numImagesOnCard) throws Throwable {
        assertEquals(numImagesOnCard, context.getCard().images().size());
    }

    @Given("^a playing card with items displayed:$")
    public void a_playing_card_with_items_displayed(List<Image> imagesDisplayed) throws Throwable {
        context.setCard(new PlayingCard());
        context.getCard().addImages(imagesDisplayed);
    }

    @Then("^the correct solution should be the \"([^\" ]*) ([^\"]*)\"$")
    public void the_correct_solution_is_the(Color colour, Item item) throws Throwable {
        assertTrue(context.getCard().isDesiredItem(item));
    }    

    @Then("^\"([^\" ]*) ([^\"]*)\" should not be a correct solution$")
    public void should_not_be_a_correct_solution(Color colour, Item item) throws Throwable {
        assertFalse(context.getCard().isDesiredItem(item));
    }
    
    
}
