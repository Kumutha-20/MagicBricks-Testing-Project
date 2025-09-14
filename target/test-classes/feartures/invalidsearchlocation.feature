@invalidsearch
Feature: Search Home Invalid Scenarios

# Ts_MB_05

  Scenario: Invalid location entered
    Given I am on the Magicbricks home page
    When I enter "Invalid Location" in the Search bar
    And I click on the Search button
    Then user should remain on the home page
# Ts_MB_05

  Scenario: No location entered
    Given I am on the Magicbricks home page
    When I enter "" in the Search bar
    And I click on the Search button
    Then user should remain on the home page