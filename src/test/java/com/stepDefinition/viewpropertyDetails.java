package com.stepDefinition;

import org.testng.Assert;

import com.pages.ViewPropertyDetailsPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class viewpropertyDetails extends BaseSteps {

    ViewPropertyDetailsPage viewPropertyDetailsPage;

    @Given("the user is on selected shortlisted property page")
    public void the_user_is_on_selected_shortlisted_property_page() {
        viewPropertyDetailsPage = new ViewPropertyDetailsPage(driver, Hooks.extTest);
    }
    
    @Given("I validate that the property details page is open")
    public void i_validate_that_the_property_details_page_is_open() {
        boolean actResult = viewPropertyDetailsPage.validateThirdTab();
        Assert.assertTrue(actResult, "Failed to navigate to the property details page.");
    }

    @When("I scroll down the page and click on view details")
    public void i_scroll_down_the_page_and_click_on_view_details() {
        boolean actResult = viewPropertyDetailsPage.scrollToViewDetailsAndClick();
        Assert.assertTrue(actResult, "Failed to scroll to view details and click.");
    }
    
    
}