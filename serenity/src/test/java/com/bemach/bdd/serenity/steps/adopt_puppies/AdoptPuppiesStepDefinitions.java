package com.bemach.bdd.serenity.steps.adopt_puppies;

import java.util.List;

import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Narrative(text={"As a puppy lover",
		  "I want to adopt a puppy",
		  "So they can chew my furniture"})
public class AdoptPuppiesStepDefinitions {
	@Steps
	AdopterSteps adopter;
	
	private String theSite;
	
	@Before
	public void setUp() {
		theSite = System.getProperty("PET_URL");
	}
	
	@Given("^I want to adopt a pet named \"(.*?)\"$")
	public void i_want_to_adopt_a_pet_named(String petName) throws Throwable {
	    adopter.visits_the_site(theSite);
	    adopter.chooses_a_pet(petName);
	    adopter.adopts_the_pet();
	}

	@When("^I completed the purchase with the following information:$")
	public void i_completed_the_purchase_with_the_following_information(List<PaymentInfoVO> payments) throws Throwable {
		adopter.completes_the_adoption(payments.get(0));
	}

	@Then("^I should see this message \"(.*?)\"$")
	public void i_should_see_this_message(String successMessage) throws Throwable {
		adopter.verifies_the_purchase(successMessage);
	}
}
