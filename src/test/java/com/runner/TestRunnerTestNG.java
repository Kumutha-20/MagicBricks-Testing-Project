package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/Feartures/3_invalidsearchlocation.feature",
	    		"src/test/resources/Feartures/1_invalidlogin.feature",
	    		"src/test/resources/Feartures/7_invalidemicalculator.feature"},
	    glue = {"com.stepDefinition"},
	    plugin = {"pretty","html:reports/cucumber-html-report.html"}
	)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{


}
