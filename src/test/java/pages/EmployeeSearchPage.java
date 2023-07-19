package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {

    //FindBy is annotation
    @FindBy (id = "empsearch_id")
    public  WebElement searchIdTextBox;

    @FindBy (id = "searchBtn")
    public  WebElement searchBtn;

    @FindBy (id = "empsearch_employee_name_empName")
    public  WebElement empNameField;


    public EmployeeSearchPage(){
        PageFactory.initElements(driver, this);
    }


}
