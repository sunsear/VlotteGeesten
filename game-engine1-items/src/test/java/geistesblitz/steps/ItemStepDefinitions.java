package geistesblitz.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import geistesblitz.GeistesBlitz;
import geistesblitz.Item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemStepDefinitions {
   
    @Given("^a game of GeistesBlitz$")
    public void a_game_of_GeistesBlitz() {
    	// Nothing needs to happen here; we merely need the "material" -> the java classes
    }

    @Then("^there should be (\\d+) items present$")
    public void there_should_be_items_present(int number) {
        assertEquals(GeistesBlitz.items().size(), number);
    }

    @Then("^a ([^\" ]*) ([^\" ]*) should be present.$")
    public void colored_item_should_be_present(String color, String item) {
        assertTrue(GeistesBlitz.items().contains(new Item(color, item)));
    }

}
