package geistesblitz.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ItemStepDefinitions {
   
    @Given("^a game of GeistesBlitz$")
    public void a_game_of_GeistesBlitz() {
    	// Nothing needs to happen here; we merely need the "material" -> the java classes
    }

    @Then("^there should be (\\d+) items present$")
    public void there_should_be_items_present(int number) {
        throw new PendingException();
    }

    @Then("^a ([^\" ]*) ([^\" ]*) should be present.$")
    public void colored_item_should_be_present(String color, String item) {
        throw new PendingException();
    }

}
