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
import com.bemach.selenium.pages.puppies.PaymentPage2;
import com.bemach.selenium.pages.puppies.ViewDetailsPage;

public class PetAdoptionTest2 {
	private static final String ONLINE_PUPPIES_ADOPTION_SITE = "http://puppies.herokuapp.com";
	private static final String LOCAL_PUPPIES_ADOPTION_SITE = "http://localhost:3000";

	private static WebDriver driver;
	private HomePage homePage;
	private ViewDetailsPage viewDetailsPage;
	private AdoptingPetsPage adoptingPetsPage;
	private PaymentPage2 paymentPage;
	
	@Test
	public void shouldSelectPetByName() {

		homePage.select_a_pet("Brook");
		viewDetailsPage = PageFactory.initElements(driver, ViewDetailsPage.class); 
		Assert.assertThat (viewDetailsPage.getPetImageName(), CoreMatchers.containsString("Brook.jpg"));
	}
	
	@Test
	public void shouldAdoptPetByName() {
		homePage.select_a_pet("Ruby Sue");
		viewDetailsPage = PageFactory.initElements(driver, ViewDetailsPage.class); 
		viewDetailsPage.adopt_the_pet();
		adoptingPetsPage = PageFactory.initElements(driver, AdoptingPetsPage.class);
		Assert.assertThat (adoptingPetsPage.getPrices(), CoreMatchers.hasItem("$52.50"));
	}
	
	@Test
	public void shouldCompleteAdoptingOnePet() {
		homePage.select_a_pet("Ruby Sue");
		viewDetailsPage = PageFactory.initElements(driver, ViewDetailsPage.class); 
		viewDetailsPage.adopt_the_pet();
		adoptingPetsPage = PageFactory.initElements(driver, AdoptingPetsPage.class);
		adoptingPetsPage.complete_the_adoption();
		paymentPage = PageFactory.initElements(driver, PaymentPage2.class);
		assertEquals("Please Enter Your Details", paymentPage.getPageLabel());
	}
	
	@Test 
	public void shouldPlaceOrderForOnePet() {
		homePage.select_a_pet("Ruby Sue");
		viewDetailsPage = PageFactory.initElements(driver, ViewDetailsPage.class); 
		viewDetailsPage.adopt_the_pet();
		adoptingPetsPage = PageFactory.initElements(driver, AdoptingPetsPage.class);
		adoptingPetsPage.complete_the_adoption();
		paymentPage = PageFactory.initElements(driver, PaymentPage2.class);
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentPage.pay(paymentInfo);
		assertEquals("Thank you for adopting a puppy!", homePage.getNotice());
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
		driver.quit();
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
