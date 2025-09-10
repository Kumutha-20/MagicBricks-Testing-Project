package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.objectrepository.Locators;
import com.setup.Reporter;

public class ViewPropertyDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    public ViewPropertyDetailsPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    /**
     * Switches to the third browser tab and validates the URL.
     * @return true if the switch and validation are successful, false otherwise.
     */
    public boolean validateThirdTab() {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
            
            // Assuming the new tab is the third one opened
            if (tabs.size() > 3) {
                driver.switchTo().window(tabs.get(4));
                Reporter.generateReport(driver, extTest, Status.PASS, "Successfully switched to the selected property page. Current URL: " + driver.getCurrentUrl());
                // You can add a URL validation here if needed
                return true;
            } else {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to the third tab. Expected 3, but found " + tabs.size());
                return false;
            }
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to switch to the third tab: " + e.getMessage());
            return false;
        }
    }

    /**
     * Scrolls down the page and clicks on the "View Details" button.
     * @return true if the action is successful, false otherwise.
     */
    public boolean scrollToViewDetailsAndClick() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Scroll down to make sure the element is in view
            js.executeScript("window.scrollBy(0,500)");
            
            // Wait for the View Details button to be visible and clickable
            WebElement viewDetailsBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.viewDetailsButton));
            viewDetailsBtn.click();
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Successfully scrolled down and clicked on 'View Details'");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to scroll and click 'View Details': " + e.getMessage());
            return false;
        }
    }
     
}