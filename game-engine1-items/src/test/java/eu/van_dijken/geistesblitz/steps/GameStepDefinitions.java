package eu.van_dijken.geistesblitz.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameStepDefinitions {
    private final GeistesBlitzTestContext context = GeistesBlitzTestContext.getInstance();

    @Given("^a new game of GeistesBlitz$")
    public void a_new_game_of_GeistesBlitz() {
        //101: Do something here!
    }

    @Then("^there should be (\\d+) items present$")
    public void there_should_be_items_present(int number) {
        assertThat(101, is(number));
    }

    @Then("^the following items should be present:$")
    public void the_following_game_items_should_be_present(List<Your101ObjectName> entries) {
        for (Your101ObjectName name : entries) {
            assertThat("101", is(name.getColor()));
        }
    }

    @Then("^the deck should contain (\\d+) cards$")
    public void the_deck_should_contain_cards(int numCards) throws Throwable {
        assertEquals(numCards, 101);
    }

    public class Your101ObjectName {
        String color;
        String type;

        public Your101ObjectName(String type, String color) {
            this.type = type;
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public String getType() {
            return type;
        }
    }

}
