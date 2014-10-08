package eu.van_dijken.vlottegeesten.cards;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

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
}
