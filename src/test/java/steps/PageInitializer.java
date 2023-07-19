package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {
    //in this PageInitializer, we don't need any WebDriver
    //We are just creating the object
    // We don't need any methods
    public static LoginPage loginPage;
//    public static EmpSearchPage emp;    ***Example only

    public static DashboardPage dashboardPage;
//  here we are declaring the object
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static void initializePageObjects(){
        loginPage = new LoginPage();
//        emp = new EmpSearchPage();    ***Example only

        //After writing the above code, we need to initialize this object at the beginning at the starting point of the execution (Common Mehods)
        dashboardPage = new DashboardPage();

        // and here where we initialize it
        addEmployeePage = new AddEmployeePage();

        employeeSearchPage = new EmployeeSearchPage();

    }


}
