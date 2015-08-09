package com.bemach.bdd.serenity_cukes.steps.serenity;

import net.thucydides.core.annotations.Step;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.bemach.bdd.serenity_cukes.steps.PaymentInfo;
import com.bemach.bdd.serenity_cukes.steps.serenity.pages.HomePage;

public class AdopterSteps {
	
	private HomePage homePage;
	private com.bemach.bdd.serenity_cukes.steps.serenity.pages.AdoptionPage adoptionPage;

	@Step
	public void opens_puppies_home_page(String websiteUrl) {
		homePage.openAt(websiteUrl);
	}

	@Step
	public void adopts_the_puppy(String puppyName) {
		String websiteUrl = homePage.getWebsiteUrl();
		adoptionPage.openAt(websiteUrl);
		adoptionPage.adoptThePuppy(puppyName);
	}
	
	@Step
	public void completes_the_adoption() {
		adoptionPage.completeTheAdoption();
	}

	@Step
	public void adopts_another_pet() {
		adoptionPage.adoptAnotherPuppy();
	}
	
	@Step
	public void pays_for_the_adoption(PaymentInfo paymentInfo) {
		adoptionPage.payForAdoption(paymentInfo);
	}

	@Step
	public void sees_thank_you_message(String thankYouMessage) {
		Assert.assertTrue (String.format("Did not get %s", thankYouMessage), homePage.displayThankYouMessage(thankYouMessage));
	}
}
