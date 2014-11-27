package geistesblitz.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import geistesblitz.material.Color;
import geistesblitz.material.Item;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ItemStepDefinitions {
   
    @Given("^a game of GeistesBlitz$")
    public void a_game_of_GeistesBlitz() {
    	// Nothing needs to happen here; we merely need the "material" -> the java classes
    }

    @Then("^there should be (\\d+) items present$")
    public void there_should_be_items_present(int number) {
        assertThat(Item.values().length, is(number));
    }

    @Then("^a ([^\" ]*) ([^\" ]*) should be present.$")
    public void colored_item_should_be_present(String color, String item) throws Throwable {
        assertThat(Item.valueOf(item).color(), is(Color.valueOf(color)));
    }

}
