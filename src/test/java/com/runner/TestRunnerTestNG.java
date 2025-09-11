package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/Feartures/2_Profile.feature", 
	    		"src/test/resources/Feartures/4_searchHome.feature", 
	    		"src/test/resources/Feartures/5_shortlistProperty.feature", 
	    		"src/test/resources/Feartures/6_emiCalculator.feature"},
	    glue = {"com.stepDefinition"},
	    plugin = {"pretty","html:reports/cucumber-html-report.html"}
	)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{


}
