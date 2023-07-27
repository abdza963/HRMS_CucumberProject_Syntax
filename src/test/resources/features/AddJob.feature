Feature: Adding new jobs in HRMS

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    And user is successfully logged in the application

  @addJob
  Scenario: User adds a new job
    * user clicks on the admin button
    * user clicks on the job
    * user Clicks on Job Title
    * user clicks on the add button
    * user enters job "Java Instructor" title
    * user enters job description "Teaches Java"
    * user clicks on the save button
    * verify data is stored properly in database



