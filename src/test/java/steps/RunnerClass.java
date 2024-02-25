package steps;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"},
        tags = "@SmokeTest",
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"steps"})


public class RunnerClass {
}