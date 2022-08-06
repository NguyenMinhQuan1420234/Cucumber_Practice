@search
  Feature: search
    As an Admin, I would like to search project by the filter
  Scenario: search projects with any criteria successfully
    Given the user visits the TMS website
    And the user is logged into the system with admin account
    And the user navigate the Search Project page
    When the user applies some search criteria Name or Location or Type
    |projectName|location|type|
    |quan      |All     |All   |
    And the user clicks on Search button
    Then all projects matched with input criteria will be displayed