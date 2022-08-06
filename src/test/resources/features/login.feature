@login
Feature: login
  As valid user, I would like to log into the application

  @SuccessfullyLogin
  Scenario: login with valid account successfully
    Given the user visits the TMS website
    When the user inputs an account
      | username | password |
      | Admin2   | qp$#tGu^ |
    And the user clicks on Login button
    Then the user is logged into the system successfully

  @UnsuccessfullyLogin
  Scenario: login unsuccessfully without password
    Given the user visits the TMS website
    When the user inputs an account
      | username | password |
      | Admin2   |          |
    And the user clicks on Login button
    Then an error message "This is a required field." is displayed below password field

  Scenario: login unsuccessfully without username
    Given the user visits the TMS website
    When the user inputs an account
      | username | password |
      |          | qp$#tGu^ |
    And the user clicks on Login button
    Then an error message "This is a required field." is displayed below username field

  Scenario: login unsuccessfully without username and password
    Given the user visits the TMS website
    When the user inputs an account
      | username | password |
      |          |          |
    And the user clicks on Login button
    Then an error message "This is a required field." is displayed below password field
    And an error message "This is a required field." is displayed below username field

  Scenario: login unsuccessfully with wrong username and password
    Given the user visits the TMS website
    When the user inputs an account
      | username | password |
      | Admin1   | qp$#tGu3 |
    And the user clicks on Login button
    Then an error message "The Username or Password you entered is incorrect" is displayed