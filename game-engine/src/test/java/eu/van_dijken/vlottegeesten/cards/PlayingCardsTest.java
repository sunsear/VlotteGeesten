package eu.van_dijken.vlottegeesten.cards;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "eu.van_dijken.vlottegeesten.steps",monochrome = true, format = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"})
public class PlayingCardsTest {

}