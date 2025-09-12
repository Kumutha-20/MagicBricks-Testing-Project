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

public class InvalidEmiCalculatorPage {
	
	private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public InvalidEmiCalculatorPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }
    
    /** Navigate to EMI Calculator */
    public boolean clickEmiCalculator() {
        try {
        	    
          	WebElement homeloan = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickHomenloan));
            homeloan.click();
            WebElement emiCalcLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.clickEmicalculator));
            emiCalcLink.click();

            Set<String> allWindows = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindows);
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size() - 1));
                Reporter.generateReport(driver, extTest, Status.PASS, "Navigated to EMI Calculator page");
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to EMI Calculator tab");
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to open EMI Calculator: " + e.getMessage());
            return false;
        }
    }

    /** Enter Loan Amount (Triggers Loan Amount Error) */
    public boolean enterLoanAmount(String amount) {
        try {
            WebElement loanAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.clearAmount1));
            loanAmountField.clear();
            WebElement loanAmountField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loanAmount1));
            loanAmountField1.sendKeys(amount);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered Loan Amount: " + amount);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter Loan Amount: " + e.getMessage());
            return false;
        }
    }

    /** Get Loan Amount Error */
    public String getLoanAmountError() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loanAmountError));
            String msg = errorMsg.getText();
            Reporter.generateReport(driver, extTest, Status.PASS, "Loan Amount Error displayed: " + msg);
            return msg;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Loan Amount Error not visible: " + e.getMessage());
            return null;
        }
    }

    /** Enter Interest Rate (Triggers Interest Rate Error) */
    public boolean enterInterestRate(String rate) {
        try {
            WebElement interestRateField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.interestRate1));
            interestRateField.clear();
            interestRateField.sendKeys(rate);
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered Interest Rate: " + rate);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter Interest Rate: " + e.getMessage());
            return false;
        }
    }

    /** Get Interest Rate Error */
    public String getInterestRateError() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.interestRateError));
            String msg = errorMsg.getText();
            Reporter.generateReport(driver, extTest, Status.PASS, "Interest Rate Error displayed: " + msg);
            return msg;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Interest Rate Error not visible: " + e.getMessage());
            return null;
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
}
