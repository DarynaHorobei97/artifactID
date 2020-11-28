package runner;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = "stepDefs",
        plugin = {"json:target/cucumber-reports/Cucumber.json"},
        tags = {"@XXXX"}

)

public class TestRunner {
}
