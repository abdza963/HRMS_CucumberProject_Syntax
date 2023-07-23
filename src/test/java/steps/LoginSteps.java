package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;
import utils.Log;

import java.sql.Driver;
import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {

        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowser();


       /*
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        */
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {

        //Creating the object of the class to access all the webElements from it
        //LoginPage loginPage = new LoginPage();   ***  we don't need this after adding the method to CommonMethods

//        WebElement usernameField = driver.findElement(By.id("txtUsername"));
//        WebElement passwordField = driver.findElement(By.id("txtPassword"));
//
//        usernameField.sendKeys(ConfigReader.getPropertyValue("username"));
//        passwordField.sendKeys(ConfigReader.getPropertyValue("password"));

        //we are calling DOM Configurator which is asking for the file which we used to integrate logs in our project
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My batch 16 test case starts here");
        sendText(ConfigReader.getPropertyValue("username"), loginPage.usernameField);
        Log.info("admin username has been entered");
        sendText(ConfigReader.getPropertyValue("password"), loginPage.passwordField);
        Log.info("My password has been entered");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //LoginPage loginPage = new LoginPage();
//        WebElement loginBtn = driver.findElement(By.name("Submit"));
//        loginBtn.click();
        click(loginPage.loginButton);
    }

    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        //System.out.println(10/0);
        System.out.println("My test case passed");
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {

    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        //LoginPage loginPage = new LoginPage();  ***  we don't need this after adding the method to CommonMethods

//        WebElement usernameField = driver.findElement(By.id("txtUsername"));
//        WebElement passwordField = driver.findElement(By.id("txtPassword"));

//        usernameField.sendKeys("admin");
//        passwordField.sendKeys("wrong");
        sendText(("admin"), loginPage.usernameField);
        sendText(("asd45fasd"), loginPage.passwordField);
    }

    @Then("error message is displayed")
    public void error_message_is_displayed() {
        System.out.println("Error message is displayed");
    }

    @When("user enters invalid {string} and {string} and verifying the {string} for the combination")
    public void user_enters_invalid_and_and_verifying_the_for_the_combination(String username, String password, String errorMessageExpected) {
        //we need to write the code here to match the errors
        sendText(username, loginPage.usernameField);
        sendText(password, loginPage.passwordField);
        click(loginPage.loginButton);
        //fetching the error message from the web element
        String errorMessageActual = loginPage.errorMessageField.getText();
        //error message coming from feature file to which we can compare

        Assert.assertEquals("value does not match",errorMessageExpected, errorMessageActual);



    }


}


