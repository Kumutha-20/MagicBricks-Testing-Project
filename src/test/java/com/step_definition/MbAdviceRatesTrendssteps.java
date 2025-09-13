package com.step_definition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.MbAdviceRatesTrends_Page;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MbAdviceRatesTrendssteps extends BaseSteps{
	
	MbAdviceRatesTrends_Page mbPage;
	ExtentTest extTest = Hooks.extTest;
    @Before("@InvalidCity or @ValidCity")
    public void startBrowser() {
        launchBrowser();
        driver.get("https://www.magicbricks.com/");
        mbPage = new MbAdviceRatesTrends_Page(driver, extTest);
        System.out.println("Browser launched ");
    }

    @After("@InvalidCity or @ValidCity")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed ");
        }
    }
    
    @Given("the browser is open")
    public void the_browser_is_open() {
        
    }
    @Given("the user is on the MagicBricks home page")
    public void the_user_is_on_the_magicbricks_home_page() {
        driver.get("https://www.magicbricks.com/");
    }

    @When("the user clicks on MB Advice")
    public void the_user_clicks_on_mb_advice() {
        mbPage.clickMbAdviceMenu();
    }

    @When("the user clicks on Rates & Trends")
    public void the_user_clicks_on_rates_and_trends() {
        mbPage.clickRatesTrendsLink();
    }

    @When("the user leaves the City field blank")
    public void the_user_leaves_the_city_field_blank() {
        mbPage.clearCity();
    }

    @When("the user enters {string} in the City field")
    public void the_user_enters_in_the_city_field(String city) {
        mbPage.enterCity(city);
    }

    @When("the user clicks the search")
    public void the_user_clicks_the_search_button() {
        mbPage.clickSearch();
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        String actual = mbPage.getErrorMessage();
        Assert.assertEquals(actual, expectedMessage, "Error message mismatch");
    }

    @Then("the page should display the text {string}")
    public void the_page_should_display_the_text(String expectedText) {
        String actual = mbPage.getTop5LocalitiesHeading();
        Assert.assertEquals(actual, expectedText, "Heading text mismatch");
    }
}
