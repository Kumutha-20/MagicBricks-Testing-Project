Feature:Home loan EMI Calculator

Scenario:Calculating EMI Amount

Given the user is on view propert details page
When the user clicks on emi calculator
And the user enters loan amount "9000000"
And the user selects loan tenure from the dropdown
And the user enters interest rate "7.4" 
And clicks on recalculate EMI
Then user validates the eligible EMI Amount



