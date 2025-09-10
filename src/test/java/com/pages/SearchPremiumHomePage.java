package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class SearchPremiumHomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public SearchPremiumHomePage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    // Navigate back to Home Page
    public boolean navigateToHomePage() {
        try {
            WebElement homeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.gobacktoHomepage));
            homeBtn.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Navigated back to Home Page");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to navigate back to Home Page: " + e.getMessage());
            return false;
        }
    }

  // Select "Premium Homes" from the Buy dropdown
    public boolean selectPremiumHomesFromBuyDropdown() {
        try {
            // Click on Buy dropdown
            WebElement buyDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickBuy));
            buyDropdown.click();

            // Select Premium Homes option
            WebElement premiumHomes = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickPremiumHomes));
            premiumHomes.click();

            Reporter.generateReport(driver, extTest, Status.PASS, "Selected Premium Homes from Buy dropdown");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to select Premium Homes from Buy dropdown: " + e.getMessage());
            return false;
        }
    }

    // Select property type
    public boolean selectPropertyType() {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickPropertyTypepremium));
            dropdown.click();

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(Locators.selectPropertyTypepremium));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

            WebElement close = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickPropertyTypepremium));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);

            Reporter.generateReport(driver, extTest, Status.PASS, "Selected property type");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to select property type: " + e.getMessage());
            return false;
        }
    }

    // Select budget
    public boolean selectBudgetRange(String min, String max) {
        try {
            WebElement dropdownSection = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickBudgetPremium));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownSection);

            WebElement minOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.mindropdownPremium));
            minOption.sendKeys("20000000");
            minOption.click();

            WebElement maxOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.maxdropdownPremium));
            maxOption.sendKeys("40000000");
            maxOption.click();

            WebElement closeOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.closeBudgetPremium));
            closeOption.click();

            Reporter.generateReport(driver, extTest, Status.PASS,
                    "Selected Budget Range: Min = " + min + ", Max = " + max);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to select budget range: " + e.getMessage());
            return false;
        }
    }

    // Click Search
    public boolean clickSearchButton() {
        try {
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.searchButtonPremium));
            searchBtn.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Search button");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to click Search button: " + e.getMessage());
            return false;
        }
    }

 // Validate that "Top Agents" tab is visible on Premium Homes results page
    public boolean validatePremiumHomesResults() {
        try {
            WebElement topAgentsTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.topAgentsTab)
            );

            if (topAgentsTab.isDisplayed()) {
                Reporter.generateReport(driver, extTest, Status.PASS, 
                    "\"Top Agents\" tab is displayed in Premium Homes results");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "\"Top Agents\" tab is NOT displayed in Premium Homes results");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to validate Premium Homes results (Top Agents tab): " + e.getMessage());
            return false;
        }
    }

}
