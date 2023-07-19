package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    //This is object repository of POM Page Object Model
    @FindBy(id = "txtUsername")
    public WebElement usernameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy (id = "spanMessage")
    public WebElement errorMessageField;
    //After writing those elements, we need to initialize them and then call them
    //To initialize all the elements of this page, we have to call them inside a constructor
    public LoginPage (){
        PageFactory.initElements(driver, this); //pageFactory.initElement is to initilaize all the element inside the current page

        //After writing the above code we need to use in steps def
        //So we need to go to loginSteps and add(create) the object of that particular class


    }
}
