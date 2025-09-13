Feature: MB Advice – Rates & Trends search

  Background:
    Given the browser is open
    And the user is on the MagicBricks home page

  @InvalidCity
  Scenario: Search without entering a city
    When the user clicks on MB Advice
    And the user clicks on Rates & Trends
    And the user leaves the City field blank
    And the user clicks the search 
    Then an error message "Please enter a Location" should be displayed

  @ValidCity
  Scenario Outline: Search shows "Top 5 Localities" heading
    When the user clicks on MB Advice
    And the user clicks on Rates & Trends
    And the user enters "<City>" in the City field
    And the user clicks the search 
    Then the page should display the text "Top 5 Localities"

    Examples:
      | City   |
      | Mumbai |
