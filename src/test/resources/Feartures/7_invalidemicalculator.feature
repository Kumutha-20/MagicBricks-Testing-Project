@InvalidEmiCalculator
Feature: Home Loan EMI Calculator Validation

  Background:
    Given the user is on the Home Loan EMI Calculator page

  Scenario:Validate invalid loan amount error
 
    When I enters loan amount "5000"
    And 	I enters interest rate "7"
    And I clicks on "Recalculate EMI"
    Then the user should see loan amount error message "LoanAmount should lie between 1,00,000 and 10,00,00,000"

    
      

  Scenario: Validate invalid interest rate error
    When I enters loan amount "500000"
    And I enters interest rate ""
    And I clicks on "Recalculate EMI"
    Then the user should see interest rate error message "Min interest starts from 0%"
    
    
