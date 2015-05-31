package com.bemach.bdd.serenity_cukes.steps.serenity.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class ViewDetailPage extends PageObject {

	@FindBy (xpath = "//input[@value='Adopt Me!']")
	WebElement adoptMe;
	
	public void adoptPuppy() {
		adoptMe.click();
	}

}
