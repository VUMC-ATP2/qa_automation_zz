package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import utils.WebDriverManager;

@CucumberOptions(features = "src/test/resources/features", glue = {"step_defs"}, plugin = {"pretty", "html:target/cucumber-reports/report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterMethod(alwaysRun = true)
    public void after() {
        WebDriverManager.closeBrowser();
    }

}
