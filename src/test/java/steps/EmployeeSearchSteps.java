package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EmployeeSearchPage;
import utils.CommonMethods;

import java.time.Duration;

public class EmployeeSearchSteps extends CommonMethods {
//    public WebDriver driver;
    @When("user clicks on PIM option and Employee list option")
    public void user_clicks_on_pim_option_and_employee_list_option() {
        //we are clicking on the pim option and emp list option
//        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
//        pimOption.click();
//        click(pimOption);
        click(dashboardPage.pimOption);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
//        empListOption.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        click(empListOption);
        click(dashboardPage.empListOption);
    }


    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
//        WebElement searchIdTextBox = driver.findElement(By.id("empsearch_id"));
//        searchIdTextBox.sendKeys("26159631");
        sendText("26159631",employeeSearchPage.searchIdTextBox);
    }

    @When("user click on search button")
    public void user_click_on_search_button() {
//        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
//        searchBtn.click();
        click(employeeSearchPage.searchBtn);
    }

    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
        System.out.println("Employee is disabled");
    }
    @When("user enters valid employee name in name text box")
    public void user_enters_valid_employee_name_in_name_text_box() {
//        WebElement empNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
//        empNameField.sendKeys("David5 Anderson");
        sendText("David5 Anderson", employeeSearchPage.empNameField);
    }

}
