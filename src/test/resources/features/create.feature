Feature: create project
  As an admin, I would like to create a new project
  @create_project
  Scenario: create projects with all field successfully
    Given the user visits the TMS website
    And the user is logged into the system with admin account
    And the user navigates to create Project Page
    When the user fills all project information
    And the user clicks Create button
    Then all the information of project is shown