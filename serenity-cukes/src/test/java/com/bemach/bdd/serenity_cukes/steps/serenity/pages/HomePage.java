package com.bemach.bdd.serenity_cukes.steps.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:3000")
public class HomePage extends PageObject {

	@FindBy (id = "notice")
	WebElement notice;
	
	public String getWebsiteUrl() {
		return this.getDriver().getCurrentUrl();
	}

	public Boolean displayThankYouMessage(String thankYouMessage) {
	  return thankYouMessage.equals(notice.getText());
	}
	
}
