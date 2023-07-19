package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

import java.time.Duration;

public class Hooks extends CommonMethods {
    @Before
    public void start(){    //pre-condition
        openBrowser();
    }



    @After
    public void end(Scenario scenario){      //post-condition
        //here we are going to capture the screenshot and attaching it to the report
        //we need this variable because my ss returns array of byte
        byte[] pic;
        //here we are going to capture the screenshot and attaching it to the reporting
        //pic = takeScreenshot(scenario.getName());  // this line is take the screenshot and put it in the byte var
        //attach this screenshot in the report
        if (scenario.isFailed()){
            pic = takeScreenshot("failed/"+scenario.getName());
        } else {
            pic = takeScreenshot("passed/"+scenario.getName());  // this line is take the screenshot and put it in the byte var
        }
        scenario.attach(pic,"image/png", scenario.getName());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        closeBrowser();
    }
}
