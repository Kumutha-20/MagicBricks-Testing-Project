package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class EmiCalculatorPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public EmiCalculatorPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    /** Click EMI Calculator */
    public boolean clickEmiCalculator() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
        	    
        	WebElement emicalculator = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickEmi));
        	emicalculator.click();
            
            
          
            
            // Get all window handles
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            
            // Switch to the new tab (assuming it's the second one)
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size()-1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Emi calculator page: " );
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch Emi calculator page.");
                return false;
            }

            WebElement emiCalcBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.magicLoans));
            Reporter.generateReport(driver, extTest, Status.PASS, "view magicLoans");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to view magicLoans");
            return false;
        }
    }

    /** Enter Loan Amount */
    public boolean enterLoanAmount(String amount) {
        try {
            WebElement loanAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.clearAmount));
            loanAmountField.clear();
            WebElement loanAmountField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loanAmount));
            loanAmountField1.sendKeys(amount);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered Loan Amount: " + amount);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter Loan Amount: " + e.getMessage());
            return false;
        }
    }

    /** Select Loan Tenure from dropdown */
    public boolean selectLoanTenure() {
        try {
            WebElement tenureDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.loanTenure));
            tenureDropdown.click();
            WebElement tenureOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.dropdownloanTenure));
            tenureOption.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Selected Loan Tenure");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to select Loan Tenure: " + e.getMessage());
            return false;
        }
    }

    /** Enter Interest Rate */
    public boolean enterInterestRate(String rate) {
        try {
            WebElement interestRateField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.clearinterestRate));
            interestRateField.clear();
            WebElement interestRateField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.interestRate));
            interestRateField1.sendKeys(rate);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered Interest Rate: " + rate);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter Interest Rate: " + e.getMessage());
            return false;
        }
    }

    /** Click Recalculate EMI */
    public boolean clickRecalculate() {
        try {
            WebElement recalcBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.recalculateEmi));
            recalcBtn.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked Recalculate EMI button");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click Recalculate EMI: " + e.getMessage());
            return false;
        }
    }

    /** Validate Eligible EMI Amount */
    public String getEligibleEmiAmount() {
        try {
            WebElement emiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.eligibleEmiAmount));
            String emiText = emiAmount.getText();
            Reporter.generateReport(driver, extTest, Status.PASS, "Eligible EMI Amount displayed: " + emiText);
            return emiText;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to fetch Eligible EMI Amount: " + e.getMessage());
            return null;
        }
    }
}
