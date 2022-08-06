@search
  Feature: search
    As an Admin, I would like to search project by the filter
  Scenario: search projects with any criteria successfully
    Given the user visits the TMS website
    And the user navigate the Search Project page
    When the user applies some search criteria (Name/Location/Type)
    And the user clicks on Search button
    Then all projects matched with input criteria will be displayed