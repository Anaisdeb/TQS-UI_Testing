import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/offers.feature", glue = "steps")
public class Runner extends AbstractTestNGCucumberTests {

}