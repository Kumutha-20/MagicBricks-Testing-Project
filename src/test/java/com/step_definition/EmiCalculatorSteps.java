package com.step_definition;

import com.aventstack.extentreports.ExtentTest;
import com.pages.EmiCalculator_Page;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.testng.Assert;

public class EmiCalculatorSteps extends BaseSteps {

    EmiCalculator_Page emiPage;
    ExtentTest extTest = Hooks.extTest;

    @Given("the user is on view propert details page")
    public void the_user_is_on_view_propert_details_page() {
        emiPage = new EmiCalculator_Page(driver, extTest);
        // Assuming you're already on property details page after previous steps
        // Otherwise, navigate here before EMI test
    }

    @When("the user clicks on emi calculator")
    public void the_user_clicks_on_emi_calculator() {
        Assert.assertTrue(emiPage.clickEmiCalculator(), "Failed to click EMI Calculator");
    }

    @When("the user enters loan amount {string}")
    public void the_user_enters_loan_amount(String loanAmount)  {
        Assert.assertTrue(emiPage.enterLoanAmount(loanAmount), "Failed to enter Loan Amount");
    }

    @When("the user selects loan tenure from the dropdown")
    public void the_user_selects_loan_tenure_from_the_dropdown() {
        Assert.assertTrue(emiPage.selectLoanTenure(), "Failed to select Loan Tenure");
    }

    @When("the user enters interest rate {string}")
    public void the_user_enters_interest_rate(String rate) {
        Assert.assertTrue(emiPage.enterInterestRate(rate), "Failed to enter Interest Rate");
    }

    @When("clicks on recalculate EMI")
    public void clicks_on_recalculate_emi() {
        Assert.assertTrue(emiPage.clickRecalculate(), "Failed to click Recalculate EMI");
    }

    @Then("the EMI amount should be displayed")
    public void the_EMI_amount_should_be_displayed() {
        String emiAmount = emiPage.getEligibleEmiAmount();
        Assert.assertNotNull(emiAmount, "Eligible EMI Amount not found");
        System.out.println("Calculated EMI: " + emiAmount);
    }
}
