package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

public class InvalidEmiCalculator_Page {
	
	public static By clickHomenloan = By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[4]/a");
    public static By clickEmicalculator = By.xpath("//*[@id=\"homeloanDrop\"]/div/div[3]/ul/li[1]/a");
    public static By clearAmount = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
    public static By loanAmount = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
    public static By loanAmountError = By.xpath("//*[@id=\"amountRequiredEmiCalError\"]");
    public static By interestRate = By.xpath("//*[@id=\"interestRateEmiCal\"]");
    public static By interestRateError = By.xpath("//*[@id=\"interestRateEmiCalError\"]");
    public static By recalculateEmi = By.xpath("//*[@id=\"submitbuttonEmiCalid\"]");
    
	private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public InvalidEmiCalculator_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }
    
    /** Navigate to EMI Calculator */
    public boolean clickEmiCalculator() {
        try {
        	    
          	WebElement homeloan = wait.until(ExpectedConditions.elementToBeClickable(clickHomenloan));
            homeloan.click();
            WebElement emiCalcLink = wait.until(ExpectedConditions.elementToBeClickable(clickEmicalculator));
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
            WebElement loanAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(clearAmount));
            loanAmountField.clear();
            WebElement loanAmountField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(loanAmount));
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
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(loanAmountError));
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
            WebElement interestRateField = wait.until(ExpectedConditions.visibilityOfElementLocated(interestRate));
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
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(interestRateError));
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
            WebElement recalcBtn = wait.until(ExpectedConditions.elementToBeClickable(recalculateEmi));
            recalcBtn.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked Recalculate EMI button");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click Recalculate EMI: " + e.getMessage());
            return false;
        }
    }
}
