Feature: Adding employee in HRM application

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM option
    And user clicks on add employee button
  @test
  Scenario: adding one employee
    When user enters firstname and lastname
    And clicks on save button
    Then employee added successfully


  @sample
  Scenario: Adding one employee from feature file
    When user enters "Abdul" and "Rahman" and "Zarli"
    And clicks on save button
    Then employee added successfully

  @outline
  Scenario Outline:adding multiple employees using scenario outline
    When user enters "<firstName>" and "<middleName>" and "<lastName>" in data driven format
    And clicks on save button
    Then employee added successfully
    Examples:
      #these below are the keys (firstName, middleName, lastName) //
      |firstName| middleName|lastName|
      |poster   |Ya         |Lou     |
      |Moe      |M          |Zar     |
      |John     |T          |Sena    |
      |Mark     |E          |Cooper  |

  @datatable
  Scenario: adding multiple employees using data table
    When user enters firstname and middlename and lastname and verify employee has been added
    |firstName|middleName|lastName|
    |Zara     |ms        |McClave |
    |Geo      |ms        |Django  |
    |Mary     |ms        |Zaca    |

  @excel
  Scenario: adding multiple employees using excel file
    When user adds multiple employees using excel from "EmployeeDataBatch16" and verify it

  @Db
  Scenario: Adding one employee from feature file
    When user enters "Abdul" and "Rahman" and "Zarli"
    And clicks on save button
    Then employee added successfully
    Then verify employee is stored in database