package com.bemach.selenium;

import static org.junit.Assert.assertEquals;

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
import com.bemach.selenium.pages.puppies.PaymentPage3;
import com.bemach.selenium.pages.puppies.ViewDetailsPage;

public class PetAdoptionTest3 {
	private static final String ONLINE_PUPPIES_ADOPTION_SITE = "http://puppies.herokuapp.com";
	private static final String LOCAL_PUPPIES_ADOPTION_SITE = "http://localhost:3000";

	private static WebDriver driver;
	private HomePage homePage;
	private ViewDetailsPage viewDetailsPage;
	private AdoptingPetsPage adoptingPetsPage;
	private PaymentPage3 paymentPage;
	
	@Test
	public void shouldSelectPetByName() {

		select_a_pet("Brook"); 
		Assert.assertThat (viewDetailsPage.getPetImageName(), CoreMatchers.containsString("Brook.jpg"));
	}

	@Test
	public void shouldAdoptPetByName() {
		adopt_a_pet("Ruby Sue");
		Assert.assertThat (adoptingPetsPage.getPrices(), CoreMatchers.hasItem("$52.50"));
	}
	
	@Test
	public void shouldCompleteAdoptingOnePet() {
		complete_the_adoption("Ruby Sue");
		assertEquals("Please Enter Your Details", paymentPage.getPageLabel());
	}
	
	@Test 
	public void shouldPlaceOrderForOnePet() {
		PaymentInfo paymentInfo = new PaymentInfo(
				"William Shakespeare", "Stratford-upon-Avon, England", 
				"william_shakespeare@england.com", "Credit card");
		pay_for_one_pet(paymentInfo);
		assertEquals("Thank you for adopting a puppy!", homePage.getNotice());
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
		paymentPage = PageFactory.initElements(driver, PaymentPage3.class);
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
