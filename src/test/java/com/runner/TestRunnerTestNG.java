package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src\\test\\resources\\Feartures",
	    glue = {"com.stepDefinition"},
	    tags = "@order1 or @order2 or @order3 or @order4",
	    plugin = {"pretty","html:reports/cucumber-html-report.html"}
	)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
