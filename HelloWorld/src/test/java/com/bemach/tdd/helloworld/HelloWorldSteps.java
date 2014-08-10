package com.bemach.tdd.helloworld;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.bemach.tdd.helloworld.HelloWorld;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloWorldSteps {
	private String expectedMessage;
	private HelloWorld helloWorld;
	
		@Given("^I want to display \"([^\"]*)\"$")
	public void I_want_to_display(String arg1) throws Throwable {
		expectedMessage = arg1;
	}

	@When("^I execute the application$")
	public void I_execute_the_application() throws Throwable {
		helloWorld = new HelloWorld();
	}

	@Then("^I should see the \"([^\"]*)\"$")
	public void I_should_see_the(String arg1) throws Throwable {
		assertEquals(arg1, helloWorld.getMessage());
	}

	@Then("^I should not see the \"([^\"]*)\"$")
	public void I_should_not_see_the(String arg1) throws Throwable {
		assertNotEquals(arg1, helloWorld.getMessage());
	}

}
