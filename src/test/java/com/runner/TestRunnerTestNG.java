package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/feartures",
	    glue = {"com.step_definition"},
	    plugin = {"pretty","html:reports/cucumber-html-report.html"}
	)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{


}
