package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.DBUtils;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    String fnFirstName;
    String fnMiddleName;
    String fnLastName;
    String empId;
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
//        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
//        pimOption.click();
//        click(pimOption);
        click(dashboardPage.pimOption);
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
//        WebElement addEmployeeBtn = driver.findElement(By.id("menu_pim_addEmployee"));
//        addEmployeeBtn.click();
//        click(addEmployeeBtn);
        click(dashboardPage.addEmpButton);
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
//        WebElement firstnameTF = driver.findElement(By.id("firstName"));
//        firstnameTF.sendKeys("Andro");
        sendText("Andro", addEmployeePage.firstnameTF);
//        WebElement lastnameTF = driver.findElement(By.id("lastName"));
//        lastnameTF.sendKeys("lastAndro");
        sendText("lasetAndro", addEmployeePage.lastnameTF);
    }
    @When("clicks on save button")
    public void clicks_on_save_button() {
//        WebElement saveBtn = driver.findElement(By.id("btnSave"));
//        saveBtn.click();
//        click(saveBtn);
        click(addEmployeePage.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee was successfully added");
    }

    @When("user enters {string} and {string} and {string}") //<- this is the linking       and whole thing is step def
    public void user_enters_and_and(String firstName, String middleName, String lastName) {  // <-- the linking is passing
        // ^ parameters and the argument is coming from the feature file

        sendText(firstName, addEmployeePage.firstnameTF); //the string (firstname) is coming from the feature file
                                                          //the webElement firstnameTF is coming from addEmployeePage
        sendText(lastName, addEmployeePage.lastnameTF);
        sendText(middleName, addEmployeePage.middlenameTF);
        empId = addEmployeePage.employeeIdField.getAttribute("value");

    }
    @When("user enters {string} and {string} and {string} in data driven format")
    public void user_enters_and_and_in_data_driven_format(String firstName, String middleName, String lastName) {
        this.fnFirstName = firstName;
        this.fnMiddleName = middleName;
        this.fnLastName = lastName;
        sendText(firstName, addEmployeePage.firstnameTF);
        sendText(middleName, addEmployeePage.middlenameTF);
        sendText(lastName, addEmployeePage.lastnameTF);
        empId = addEmployeePage.employeeIdField.getAttribute("value");

    }

    @When("user enters firstname and middlename and lastname and verify employee has been added")
    public void user_enters_firstname_and_middlename_and_lastname_and_verify_employee_has_been_added
            (io.cucumber.datatable.DataTable dataTable) { //the data that is coming from the feature file is stored in variable: dataTabel
        //we need list of maps to get multiple values from datatable which is coming
        //from feature file
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String,String> employee: employeeNames) { //Map<String, String> :::: is the datatype
            //getting the values against the key   in map
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");

            sendText(firstNameValue, addEmployeePage.firstnameTF);
            sendText(middleNameValue, addEmployeePage.middlenameTF);
            sendText(lastNameValue, addEmployeePage.lastnameTF);

            click(addEmployeePage.saveBtn);
            //after adding one employee, we will add another employee
            //for this, we are clicking on add employee button inthe loop itself
            click(dashboardPage.addEmpButton);

        }

    }

    @When("user adds multiple employees using excel from {string} and verify it")
    public void user_adds_multiple_employees_using_excel_from_and_verify_it(String sheetName) throws InterruptedException {
        //Here we are getting the data from Excel file using parameter
        //ExcelReader.read method will return the data in the form of list of map
        List<Map<String, String>> newEmployees =  ExcelReader.read(sheetName, Constants.EXCEL_READE_PATH);
        Iterator<Map<String, String>> itr = newEmployees.iterator();

        //it will check whether we have new element/ value or not
        while(itr.hasNext()){
            //in this map, we have data from every single employee one be one it will give us that data
            Map<String, String> mapNewEmp = itr.next();
            //Filling the employee data now using mapNewEmp variable
            sendText(mapNewEmp.get("firstName"),addEmployeePage.firstnameTF);
            sendText(mapNewEmp.get("lastName"), addEmployeePage.lastnameTF);
            sendText(mapNewEmp.get("middleName"), addEmployeePage.middlenameTF);
            sendText(mapNewEmp.get("photograph"), addEmployeePage.photograph);

            //we can enter username and password only after selecting the checkbox
            if(!addEmployeePage.checkBoxLocator.isSelected()){
                click(addEmployeePage.checkBoxLocator);
            }
            sendText(mapNewEmp.get("username"),addEmployeePage.usernameTextBox);
            sendText(mapNewEmp.get("password"),addEmployeePage.passwordTextBox);
            sendText(mapNewEmp.get("confirmPassword"),addEmployeePage.confirmPasswordBox);



            //we are fetching the employee id from the UI using get attribute method
            String empIdValue = addEmployeePage.employeeIdField.getAttribute("value");

            click(addEmployeePage.saveBtn);
            Thread.sleep(2500);
            click(dashboardPage.empListOption);
            //Searching the employee using emp id which we just got
            sendText(empIdValue,employeeSearchPage.searchIdTextBox);
            click(employeeSearchPage.searchBtn);

            //print the value from the table row
            List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < rowData.size(); i++) {   //we used .size() to get all the elements (Size of the list)
                System.out.println("I am inside the loop");
                //it will return one by one all the data from the row
                String rowText = rowData.get(i).getText();
                //it will print the complete row data
                //output of this will be : empid firstname middlename lastname
                System.out.println(rowText);
                //we have to verity this data against the data coming from excel
                String expectedData = empIdValue + " "+mapNewEmp.get("firstName")+" "+
                        mapNewEmp.get("middleName")+" "+mapNewEmp.get("lastName");
                Assert.assertEquals(rowText, expectedData);

                // you can use below code too to verify the data
                //Assert.assertTrue(expectedData.equals(rowText));
            }

            //click(addEmployeePage.saveBtn);
            //After clicking save, we have to verity that the employee has been added


            //to add more employees we need to click on add employee button
            click(dashboardPage.addEmpButton);

        }
    }

    @Then("verify employee is stored in database")
    public void verify_employee_is_stored_in_database() {
        String query = "select emp_firstName,emp_middle_name,emp_lastname from hs_hr_employees where employee_id=" + empId + ";";
        System.out.println(query);

        List<Map<String, String>> mapList = DBUtils.fetch(query);
        Map<String, String> firstRow = mapList.get(0);
        String dbFirstName=firstRow.get("emp_firstName");
        String dbMiddleName=firstRow.get("emp_middle_name");
        String dbLastName=firstRow.get("emp_lastname");

        Assert.assertEquals("FirstName from frontend does not match the firstname from database", "Abdul",dbFirstName);
        Assert.assertEquals("MiddleName from frontend does not match the MiddleName from database", "Rahman",dbMiddleName);
        Assert.assertEquals("LastName from frontend does not match the LastName from database", "Zarli",dbLastName);


    }

}

