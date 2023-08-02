package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class HardCodedExamples {
    //baseURI = baseURL + endpoint
    //given - preperation
    //when - hitting the endpoint
    //base URI = base URL
    //then - Assertion/ verification

    //we are assigning the URL to the static variable, and then assigning that static variable to the instance variable
    String baseURI = RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";

    //value of token should be same as postman
    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTA5MTExMDgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MDk1NDMwOCwidXNlcklkIjoiNTc4MyJ9.VkG_w0Vjs4qtsqKRd0gtnt3xgGmRHTKt2b-NRJYxBac";

    //in this method we are going to create an employee
    //we need headers, body to prepare the request

    @Test
    public void createEmployee(){
        //prepare the request
        RequestSpecification request = given().header("Content-Type","application/json").  //RequestSpecification coming from class
                header("Authorization",token).
                body("{\n" +
                        "  \"emp_firstname\": \"justin\",\n" +
                        "  \"emp_lastname\": \"AZ\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1992-07-29\",\n" +
                        "  \"emp_status\": \"happy single\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");

        //hitting the endPoint
        Response response = request.when().post("/createEmployee.php");

        //Verifying the response
        response.then().assertThat().statusCode(201);

        //System.out.println(response);
        //this method we use to print the response of API in console
        response.prettyPrint();

        // to execute the code, we need junit. add @Test before this method

    }
}
