package eu.van_dijken.geistesblitz.engine;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "eu.van_dijken.geistesblitz.steps", monochrome = true,
        format = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"})
public class GameObjectsTest {

}