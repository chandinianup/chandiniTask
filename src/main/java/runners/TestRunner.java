package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to your feature files
    glue = "stepDefinitions", // Path to your step definition classes
    plugin = {"pretty", "html:target/cucumber-reports.html"} // Cucumber report
)
public class TestRunner {
    public static void main(String[] args) {
        // Initialize WebDriverManager for Chrome
    	
        WebDriverManager.chromedriver().setup();
    }
}