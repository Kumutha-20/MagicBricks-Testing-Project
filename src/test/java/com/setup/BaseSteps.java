package com.setup;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSteps {
    
    public static WebDriver driver;  // shared driver
    public final static int TIME = 3000;

    public static void launchBrowser() {
        if (driver == null) {   // avoid multiple launches
            Properties prop = PropertyReader.readProperties();
            // ChromeOptions setup
            ChromeOptions chromeOptions = new ChromeOptions();
            Map<String, Object> chromePrefs = new HashMap<>();
            
           
            
            // disable popups
            chromeOptions.addArguments("--disable-popup-blocking");
            
            // Disable password manager prompts
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_leak_detection", false);
            
            // Disable geolocation
            chromePrefs.put("profile.default_content_setting_values.geolocation", 2);
            
            chromeOptions.setExperimentalOption("prefs", chromePrefs);

            // Launch Chrome with options
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.get(prop.getProperty("URL"));
        }
    }
        
    public static void sleep() {
        try {
            Thread.sleep(TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
