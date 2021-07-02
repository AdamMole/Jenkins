package pl.testeroprogramowania;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/",
plugin = {"pretty", "html:target/index.html", "json:target/cucumber.json"})
public class RunCucumberTest {
}
