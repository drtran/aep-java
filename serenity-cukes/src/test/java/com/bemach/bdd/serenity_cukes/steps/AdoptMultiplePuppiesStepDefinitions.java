package com.bemach.bdd.serenity_cukes.steps;

import java.util.ArrayList;
import java.util.List;

import com.bemach.bdd.serenity_cukes.steps.serenity.AdopterSteps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdoptMultiplePuppiesStepDefinitions {
	@Steps
	AdopterSteps adopter;
	
	@Given("^that I am at the website \"(.*?)\"$")
	public void that_I_am_at_the_website(String websiteUrl) throws Throwable {
	    adopter.opens_puppies_home_page(websiteUrl);
	}

	@When("^I adopt for these pets,$")
	public void i_adopt_for_these_pets(List<String> petNames) throws Throwable {
		for (int idx = 0; idx < petNames.size(); idx++) {
			adopter.adopts_the_puppy(petNames.get(idx));
			if (idx+1 == petNames.size()) {
				adopter.completes_the_adoption();
			} else {
				adopter.adopts_another_pet();
			}
		}
	}

	@When("^I adopt for these pets, \"(.*?)\", \"(.*?)\", and \"(.*?)\"$")
	public void i_adopt_for_these_pets_and(String pet1, String pet2, String pet3) throws Throwable {
		List<String> petNames = new ArrayList<String> ();
		petNames.add(pet1);
		petNames.add(pet2);
		petNames.add(pet3);
		this.i_adopt_for_these_pets(petNames);
	}
	
	@When("^I pay for the adoption using this type of payment:$")
	public void i_pay_for_the_adoption_using_this_type_of_payment(List<PaymentInfo> payments) throws Throwable {
	    adopter.pays_for_the_adoption(payments.get(0));
	}


	@Then("^I should be back at the main page with a thank you note, \"(.*?)\"$")
	public void i_should_be_back_at_the_main_page_with_a_thank_you_note(String thankYouMessage) throws Throwable {
	    adopter.sees_thank_you_message(thankYouMessage);
	}


}
