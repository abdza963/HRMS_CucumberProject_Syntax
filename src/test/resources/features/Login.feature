Feature: Login related scenarios
  Background:
#  Given user is navigated to HRMS application

  @sprint1 @regression @smoke @newTestCase @newFeature @sprint1 @login1
  Scenario: Valid admin login
    #don't add anything in the step after creating step def
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @employee @sprint1
  Scenario: Valid ess login
    When user enters valid ess username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @invalid @sprint1
  Scenario: Invalid login
    When user enters invalid username and password
    And user clicks on login button
    Then error message is displayed

  @negative
  Scenario Outline: negative login test
    When user enters invalid "<username>" and "<password>" and verifying the "<error>" for the combination
    And user clicks on login button
    Then error message is displayed
    Examples:
    |username|password|error|
    |admin   |wrong   |Invalid credentials|
    |wrong   |Hum@nhrm123|Invalid credentials|
    |        |Hum@nhrm123|Username cannot be empty|
    |admin   |           |Password cannot be empty|
