@order4

Feature: Magicbricks Premium Homes Search

  Scenario: Go back to home page and search Premium Homes
    Given the user navigates to the property listing page
    When the user navigates back to the home page
    Then the user should see premium homes in the results
    And the user selects Property Type from the dropdown
    And the user selects a budget range from the dropdown
    And the user clicks on the Search button
    Then the user should be redirected to the property listing page
    And the user should see premium homes in the results
