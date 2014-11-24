package geistesblitz;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "geistesblitz.steps", monochrome = true,
        format = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"})
public class RunAllCucumberFeaturesTest {

}