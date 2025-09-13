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

public class EmiCalculator_Page {
	
	public static By clickEmi = By.xpath("//*[@id=\"details\"]/div/div[1]/a[1]");
    public static By magicLoans = By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/div");
    public static By clearAmount = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
    public static By loanAmount = By.xpath("//*[@id=\"amountRequiredEmiCal\"]");
    public static By loanTenure = By.xpath("/html/body/div/div[4]/div[1]/div/div/div[1]/form/div[2]/div[1]/div");
    public static By dropdownloanTenure = By.xpath("//*[@id=\"loan-tenure_Emi\"]/li[6]");
    public static By clearinterestRate = By.xpath("//*[@id=\"interestRateEmiCal\"]");
    public static By interestRate = By.xpath("//*[@id=\"interestRateEmiCal\"]");
    public static By recalculateEmi = By.xpath("//*[@id=\"submitbuttonEmiCalid\"]");
    public static By eligibleEmiAmount = By.xpath("//*[@id=\"emiResultSection\"]/div/div[1]/div[1]");
    
    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public EmiCalculator_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    /** Click EMI Calculator */
    public boolean clickEmiCalculator() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
        	    
        	WebElement emicalculator = wait.until(ExpectedConditions.elementToBeClickable(clickEmi));
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

            WebElement emiCalcBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(magicLoans));
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

    /** Select Loan Tenure from dropdown */
    public boolean selectLoanTenure() {
        try {
            WebElement tenureDropdown = wait.until(ExpectedConditions.elementToBeClickable(loanTenure));
            tenureDropdown.click();
            WebElement tenureOption = wait.until(ExpectedConditions.elementToBeClickable(dropdownloanTenure));
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
            WebElement interestRateField = wait.until(ExpectedConditions.visibilityOfElementLocated(clearinterestRate));
            interestRateField.clear();
            WebElement interestRateField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(interestRate));
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
            WebElement recalcBtn = wait.until(ExpectedConditions.elementToBeClickable(recalculateEmi));
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
            WebElement emiAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(eligibleEmiAmount));
            String emiText = emiAmount.getText();
            Reporter.generateReport(driver, extTest, Status.PASS, "Eligible EMI Amount displayed: " + emiText);
            return emiText;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to fetch Eligible EMI Amount: " + e.getMessage());
            return null;
        }
    }
}
