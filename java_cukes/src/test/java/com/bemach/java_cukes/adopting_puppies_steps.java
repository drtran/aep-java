package com.bemach.java_cukes;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class adopting_puppies_steps {
	WebDriver driver;
	private Browser browser;
	
	@Before
	public void setup() {
		browser = new Browser();
		driver = browser.getDriver();
	}
	
	@After
	public void tearDown() {
		browser.close();
	}
	
	@Given("^I am on the puppy adoption site$")
	public void I_am_on_the_puppy_adoption_site() throws Throwable {
		driver.get("http://puppies.herokuapp.com");
		
		WebElement mainPage = driver.findElement(By.xpath("//*[@id='intro']/div/h1/span"));
		//Assert.assertTrue("Home of theddd".equals(mainPage.getText()));
		Assert.assertEquals("Home of the", mainPage.getText());
	}
	
	@When("^I click the View Details button for \"([^\"]*)\"$")
	public void I_click_the_View_Details_button_for(String petName) throws Throwable {
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='name']"));
		List<WebElement> values = driver.findElements(By.xpath("//input[@value='View Details']"));
		
		int index = 0;
		for (WebElement name: names) {
			if (name.getText().equals(petName)) {
				values.get(index).click();
				break;
			}
			index++;
		}
	}

	@When("^I click the Adopt Me! button$")
	public void I_click_the_Adopt_Me_button() throws Throwable {
		WebElement adoptMe = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
		adoptMe.click();
	}

	private void I_click_the_Adopt_Another_Puppy_button() throws Throwable {
		WebElement adoptMore = driver.findElement(By.xpath("//input[@value='Adopt Another Puppy']"));
		adoptMore.click();
	}

	
	private boolean isLastPuppy(List<String> puppies, int index) {
		return index == puppies.size()-1;
	}
	
	@When("^I adopt multiple puppies$")
	public void I_adopt_multiple_puppies(List<String> puppies) throws Throwable {
		for (int index = 0; index < puppies.size(); index++) {
			I_click_the_View_Details_button_for(puppies.get(index));
			I_click_the_Adopt_Me_button();
			if (!isLastPuppy(puppies, index)) {
				I_click_the_Adopt_Another_Puppy_button();
			}
		}
	}

	
	@When("^I click the Complete the Adoption button$")
	public void I_click_the_Complete_the_Adoption_button() throws Throwable {
		WebElement completeTheAdoption = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
		completeTheAdoption.click();
	}

	@When("^I complete the adoption with$")
	public void I_complete_the_adoption_with(List<PaymentInfo> piList) throws Throwable {
		PaymentInfo pi = piList.get(0);
		WebElement orderName = driver.findElement(By.xpath("//input[@id='order_name']"));
		orderName.sendKeys(pi.getName());
		 
		WebElement orderAddr = driver.findElement(By.xpath("//textarea[@id='order_address']"));
		orderAddr.sendKeys(pi.getAddress());

		WebElement orderEmail = driver.findElement(By.xpath("//input[@id='order_email']"));
		orderEmail.sendKeys(pi.getEmail());

		WebElement select = driver.findElement(By.xpath("//select[@id='order_pay_type']"));
		Select dropDown = new Select(select);
		List<WebElement> options = dropDown.getOptions();
		for (WebElement option: options) {
			if (option.getText().equals(pi.getPay_type())) {
				option.click();
				break;
			}
		}
		
		WebElement commit = driver.findElement(By.xpath("//input[@name='commit']"));
		commit.click();
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void I_should_see(String note) throws Throwable {
		WebElement thankYouNote = driver.findElement(By.xpath("//p[@id='notice']"));
		Assert.assertTrue(note.equals(thankYouNote.getText()));
		if (note.equals(thankYouNote.getText())) {
			System.out.println("Test was a SUCCESS!");
		} else {
			System.out.println("Test was a FAILURE!");
		}
	}
	
	
	@Then("^I should see \"([^\"]*)\" error message$")
	public void I_should_see_error_message(String errMsg) throws Throwable {
		WebElement errMsgElem = driver.findElement(By.xpath("//*[@id='error_explanation']/ul/li[1]"));
		Assert.assertTrue(errMsg.equals(errMsgElem.getText()));
	}

}
