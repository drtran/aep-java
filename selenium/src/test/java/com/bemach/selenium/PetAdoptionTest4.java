package com.bemach.selenium;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.bemach.selenium.pages.puppies.AdoptingPetsPage;
import com.bemach.selenium.pages.puppies.HomePage;
import com.bemach.selenium.pages.puppies.PaymentPage4;
import com.bemach.selenium.pages.puppies.ViewDetailsPage;

public class PetAdoptionTest4 {
	private static final String ONLINE_PUPPIES_ADOPTION_SITE = "http://puppies.herokuapp.com";
	private static final String LOCAL_PUPPIES_ADOPTION_SITE = "http://localhost:3000";

	private static WebDriver driver;
	private HomePage homePage;
	private ViewDetailsPage viewDetailsPage;
	private AdoptingPetsPage adoptingPetsPage;
	private PaymentPage4 paymentPage;
	
	@Test 
	public void shouldGetCorrectNumberOfErrorMessages() {
		PaymentInfo paymentInfo = new PaymentInfo("", "",	"", "");
		pay_for_one_pet(paymentInfo);
		List<String> errorMessages = paymentPage.getErrorMessages();
		assertEquals(5, errorMessages.size());
	}

	@Test
	public void shouldGetCorrectErrorMessageTitle() {
		PaymentInfo paymentInfo = new PaymentInfo("", "",	"", "");
		pay_for_one_pet(paymentInfo);
		List<String> errorMessages = paymentPage.getErrorMessages();
		String expected = String.format("%d errors", errorMessages.size());
		String errorMessagesTitle = paymentPage.getErrorMessagesTitle();
		Assert.assertThat(errorMessagesTitle, CoreMatchers.containsString(expected));
	}
	
	@Test
	public void shouldGetCorrectErrorMessageText() {
		PaymentInfo paymentInfo = new PaymentInfo("", "",	"", "");
		pay_for_one_pet(paymentInfo);
		List<String> errorMessages = paymentPage.getErrorMessages();
		Assert.assertThat(errorMessages, CoreMatchers.hasItem("Email can't be blank"));
	}

	@Test
	public void shouldGetTwoCorrectErrorMessageText() {
		PaymentInfo paymentInfo = new PaymentInfo("William Shakespeare", "", 
				"", "Purchase order");
		pay_for_one_pet(paymentInfo);
		String[] expectedErrorMessages = {"Email can't be blank", "Address can't be blank"};
		List<String> errorMessages = paymentPage.getErrorMessages();
		Assert.assertThat(errorMessages, CoreMatchers.hasItems(expectedErrorMessages));
		// Also:
		String expectedErrorMessagesTitle = String.format("%d errors", errorMessages.size());
		String errorMessagesTitle = paymentPage.getErrorMessagesTitle();
		Assert.assertThat(errorMessagesTitle, CoreMatchers.containsString(expectedErrorMessagesTitle));
	}
	
	@Test
	public void shouldGetCorrectErrorFieldDisplayed() {
		PaymentInfo paymentInfo = new PaymentInfo("William Shakespeare", "", 
				"", "Purchase order");
		pay_for_one_pet(paymentInfo);
		String[] expectedErrorFields = {"Email", "Address"};
		List<String> errorFields = paymentPage.getErrorFields ();
		Assert.assertThat(errorFields, CoreMatchers.hasItems(expectedErrorFields));
	}
	/** steps **/
	private void select_a_pet(String petName) {
		homePage.select_a_pet(petName);
		viewDetailsPage = PageFactory.initElements(driver, ViewDetailsPage.class);
	}
	
	private void adopt_a_pet(String petName) {
		select_a_pet(petName);
		viewDetailsPage.adopt_the_pet();
		adoptingPetsPage = PageFactory.initElements(driver, AdoptingPetsPage.class);
	}
	
	private void complete_the_adoption(String petName) {
		adopt_a_pet(petName);
		adoptingPetsPage.complete_the_adoption();
		paymentPage = PageFactory.initElements(driver, PaymentPage4.class);
	}
	
	private void pay_for_one_pet(PaymentInfo paymentInfo) {
		complete_the_adoption("Ruby Sue");
		paymentPage.pay(paymentInfo);
	}
	
	/** ---- Setup/Teardown **/
	
	@BeforeClass
	public static void setupGlobal() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownGlobal() {
		driver.close();
	}
	
	@Before
	public void setUp() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.visit(LOCAL_PUPPIES_ADOPTION_SITE);
	}
	
	@After 
	public void tearDown() {
		
	}
	
}
