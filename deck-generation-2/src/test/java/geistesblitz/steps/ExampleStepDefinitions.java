package geistesblitz.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import geistesblitz.examples.ExampleGreeter;
import geistesblitz.examples.ExamplePerson;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleStepDefinitions {
    ExampleGreeter greeter = new ExampleGreeter();

    @Given("^there are (\\d+) people in the room$")
    public void there_are_people_in_the_room(int arg1) throws Throwable {
        greeter.peopleInRoom(arg1);
    }

    @Given("^the following people are in the room:$")
    public void the_following_people_are_in_the_room(List<ExamplePerson> people) throws Throwable {
        greeter.peopleInRoom(people);
    }

    @Given("^a person with firstname \"([^\"]*)\" and lastname \"([^\"]*)\" is alone in the room$")
    public void person_is_alone_in_the_room(String firstname, String lastname) throws Throwable {
        greeter.peopleInRoom(Collections.singletonList(new ExamplePerson(firstname, lastname)));
    }

    @Then("^correct greeting is \"([^\"]*)\"$")
    public void correct_greeting_is(String arg1) throws Throwable {
        assertEquals(arg1, greeter.greet());
    }
}
