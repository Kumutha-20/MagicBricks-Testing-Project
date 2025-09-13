package com.step_definition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.InvalidEmiCalculator_Page;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidEmiCalculatorSteps extends BaseSteps {

    InvalidEmiCalculator_Page invalidemicalculatorpage;
    ExtentTest extTest = Hooks.extTest;
    
    @Before("@invalidemicalculator")
    public void startBrowser() {
        launchBrowser();
        driver.get("https://www.magicbricks.com/");
        invalidemicalculatorpage = new InvalidEmiCalculator_Page(driver, extTest);
        System.out.println("Browser launched fresh for InvalidEmiCalculator scenario");
    }

    @After("@invalidemicalculator")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed after InvalidEmiCalculator scenario");
        }
    }
    @Given("the user is on the Home Loan EMI Calculator page")
    public void the_user_is_on_home_loan_emi_calculator_page() {
    	   invalidemicalculatorpage.clickEmiCalculator();
    }

    @When("I enters loan amount {string}")
    public void i_enters_loan_amount(String loanAmount) {
    	   invalidemicalculatorpage.enterLoanAmount(loanAmount);
    }

    @When("I enters interest rate {string}")
    public void i_enters_interest_rate(String interestRate) {
    	   invalidemicalculatorpage.enterInterestRate(interestRate);
    }

    @When("I clicks on {string}")
    public void the_user_clicks_on(String buttonName) {
        if (buttonName.equalsIgnoreCase("Recalculate EMI")) {
            invalidemicalculatorpage.clickRecalculate();
        }
    }


    @Then("the user should see loan amount error message {string}")
    public void the_user_should_see_loan_amount_error_message(String expectedMessage) {
        String actualMsg =invalidemicalculatorpage.getLoanAmountError();
        Assert.assertEquals(actualMsg, expectedMessage, 
            "Loan Amount Error Validation Failed!");
    }

    @Then("the user should see interest rate error message {string}")
    public void the_user_should_see_interest_rate_error_message(String expectedMessage) {
        String actualMsg =invalidemicalculatorpage.getInterestRateError();
        Assert.assertEquals(actualMsg, expectedMessage, 
            "Interest Rate Error Validation Failed!");
    }

    }
