package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all feature file
        features = "src/test/resources/features/",
        //glue keyword used to provide the path of the package where step defs are available
        glue = "steps",
        //when dryRun is true; it stops actual execution,
        // it quickly scans all the steps, and it will provide the missing step definition
        //When dryRun is true, it will generate all the steps def
        dryRun = false,

        //tags = "@smoke"
        tags = "@regression",

        // it means sometimes the console output for cucumber test is having some irrelevant,
        // when you set it to true, it removes all that irrelevant information from the console and will give you simple output
        monochrome = true,

        //it used to print all the steps in console
        //html plugin is generating the report, this report will be generated under target folder
        plugin = {"pretty","html:target/cucumber.html", "json:target/cucumber.json"}
)
public class RegressionRunner {

}
