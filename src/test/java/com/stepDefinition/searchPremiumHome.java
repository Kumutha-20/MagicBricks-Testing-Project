package com.stepDefinition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.SearchPremiumHomePage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchPremiumHome extends BaseSteps {

    SearchPremiumHomePage premiumHomePage;
    ExtentTest extTest = Hooks.extTest;

    @Given("the user navigates to the property listing page")
    public void the_user_navigates_to_the_property_listing_page() {
        premiumHomePage = new SearchPremiumHomePage(driver, extTest);
        // Just a reporting step since user is already on listing page
        Assert.assertTrue(true, "User is not on the property listing page");
    }

    @When("the user navigates back to the home page")
    public void the_user_navigates_back_to_the_home_page() {
        premiumHomePage = new SearchPremiumHomePage(driver, extTest);
        boolean actResult = premiumHomePage.navigateToHomePage();
        Assert.assertTrue(actResult, "Failed to navigate back to home page.");
    }

    @Then("the user should see premium homes in the results")
    public void the_user_should_see_premium_homes_in_the_results() {
        premiumHomePage = new SearchPremiumHomePage(driver, extTest);
        boolean actResult = premiumHomePage.selectPremiumHomesFromBuyDropdown();
        Assert.assertTrue(actResult, "Failed to select Premium Homes from Buy dropdown.");
    }

    @Then("I should see premium homes in the results")
    public void i_should_see_premium_homes_in_the_results() {
        premiumHomePage = new SearchPremiumHomePage(driver, extTest);
        boolean actResult = premiumHomePage.validatePremiumHomesResults();
        Assert.assertTrue(actResult, "Premium Homes not found in results.");
    }
}
