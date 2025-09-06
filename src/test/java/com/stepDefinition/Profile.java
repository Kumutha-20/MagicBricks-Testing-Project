package com.stepDefinition;

import com.setup.BaseSteps;

import io.cucumber.java.en.Given;

public class Profile extends BaseSteps{
	
	@Given("the user is on login page")
	public void the_user_is_on_login_page() {
	    launchBrowser();
	    
	}
}
