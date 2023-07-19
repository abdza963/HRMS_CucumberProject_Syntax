package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy (id = "firstName")
    public WebElement firstnameTF;  //After creating the field, we don't need to initialize it. It's been initialized automatically using the framework

    @FindBy (id = "middleName")
    public WebElement middlenameTF;
    @FindBy (id = "lastName")
    public WebElement lastnameTF;

    @FindBy (id = "btnSave")
    public WebElement saveBtn;

    @FindBy (id = "photofile")
    public WebElement photograph;

    @FindBy (id = "employeeId")
    public WebElement employeeIdField;

    @FindBy (id = "chkLogin")
    public WebElement checkBoxLocator;

    @FindBy (id = "user_name")
    public WebElement usernameTextBox;

    @FindBy (id = "user_password")
    public WebElement passwordTextBox;

    @FindBy (id = "re_password")
    public WebElement confirmPasswordBox;



    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }

}
