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

public class MbAdviceRatesTrends_Page {
	
	public static By clickMbAdvice = By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/a");
	public static By clickRatesTrends = By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[6]/div/div/div[2]/ul/li[2]/a");
	public static By entercity = By.xpath("//*[@id=\"keyword\"]");
	public static By dropdowncity = By.xpath("//*[@id=\"keyword_suggest\"]/div[2]");
	public static By showtrends = By.xpath("//*[@id=\"showTrendsId\"]");
	public static By toplocalities = By.xpath("//*[@id=\"avgPriceData\"]/div[2]/div/div[1]");
	public static By errormessage = By.xpath("//*[@id=\"onlyLocation\"]");
	
	private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public MbAdviceRatesTrends_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }
	
	
    /** Click MB Advice menu */
    public boolean clickMbAdviceMenu() {
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(clickMbAdvice));
            menu.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked MB Advice menu");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click MB Advice: " + e.getMessage());
            return false;
        }
    }

    /** Click Rates & Trends link */
    public boolean clickRatesTrendsLink() {
        try {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(clickRatesTrends));
            link.click();

            // handle new tab if it opens
            Set<String> allWindows = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindows);
            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(tabs.size() - 1));
            }

            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked Rates & Trends link");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click Rates & Trends: " + e.getMessage());
            return false;
        }
    }

    /** Clear City field */
    public boolean clearCity() {
        try {
            WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(entercity));
            cityField.clear();
            Reporter.generateReport(driver, extTest, Status.PASS, "Cleared City field");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to clear City field: " + e.getMessage());
            return false;
        }
    }

    /** Enter City */
    public boolean enterCity(String city) {
        try {
            WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(entercity));
            cityField.clear();
            cityField.sendKeys(city);

            // optional: select from dropdown if visible
            try {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdowncity));
                dropdown.click();
            } catch (Exception ignored) {}

            Reporter.generateReport(driver, extTest, Status.PASS, "Entered City: " + city);
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to enter City: " + e.getMessage());
            return false;
        }
    }

    /** Click Search / Show Trends */
    public boolean clickSearch() {
        try {
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(showtrends));
            searchBtn.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked Show Trends button");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click Show Trends: " + e.getMessage());
            return false;
        }
    }

    /** Get Top 5 Localities text */
    public String getTop5LocalitiesHeading() {
        try {
            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(toplocalities));
            String text = heading.getText();
            Reporter.generateReport(driver, extTest, Status.PASS, "Top 5 Localities heading: " + text);
            return text;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to get Top 5 Localities heading: " + e.getMessage());
            return null;
        }
    }

    /** Get Error message when City is blank */
    public String getErrorMessage() {
        try {
            // update this XPath to match the actual error message on the site
            
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errormessage));
            String text = errorMsg.getText();
            Reporter.generateReport(driver, extTest, Status.PASS, "Error message displayed: " + text);
            return text;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Error message not displayed: " + e.getMessage());
            return null;
        }
    }
}
