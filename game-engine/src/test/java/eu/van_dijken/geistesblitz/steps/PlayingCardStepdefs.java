package eu.van_dijken.geistesblitz.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import eu.van_dijken.geistesblitz.engine.CardImage;
import eu.van_dijken.geistesblitz.engine.Colour;
import eu.van_dijken.geistesblitz.engine.Item;
import eu.van_dijken.geistesblitz.engine.PlayingCard;
import eu.van_dijken.geistesblitz.engine.Shape;

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
    public void a_playing_card_with_items_displayed(List<CardImage> imagesDisplayed) throws Throwable {
        context.setCard(new PlayingCard());
        context.getCard().addImages(imagesDisplayed);
    }

    @Then("^the correct solution should be the \"([^\" ]*) ([^\"]*)\"$")
    public void the_correct_solution_is_the(Colour colour, Shape type) throws Throwable {
        assertTrue(context.getCard().isDesiredItem(Item.valueOf(type.name())));
    }    

    @Then("^\"([^\" ]*) ([^\"]*)\" should not be a correct solution$")
    public void should_not_be_a_correct_solution(Colour colour, Item item) throws Throwable {
        assertFalse(context.getCard().isDesiredItem(item));
    }
    
    
}
