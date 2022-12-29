package Test_runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/OrangeHRM.feature",glue = "step_Defnitions",dryRun =true,plugin = {"pretty","html:test-output"})
public class TestRunner {

}
