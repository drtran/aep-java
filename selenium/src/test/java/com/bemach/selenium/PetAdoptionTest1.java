package com.bemach.selenium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class PetAdoptionTest1 {
	private static final String ONLINE_PUPPIES_ADOPTION_SITE = "http://puppies.herokuapp.com";
	private static final String LOCAL_PUPPIES_ADOPTION_SITE = "http://localhost:3000";
	private static final String PHANTOMJS_DRIVER_URL = "http://localhost:8910";
	private static final String REMOTE_DRIVER_URL = "http://localhost:4444/wd/hub";
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
	}
	
	@After 
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void shouldAdoptWithGhostDriver() throws MalformedURLException {
		getGhostDriver();
		adopt_a_pet();
	}

	@Test
	public void shouldAdoptWithFirefoxDriver() {
		driver = new FirefoxDriver();
		adopt_a_pet();
	}
	
	@Test
	public void shouldAdoptWithChromeDriver() {
		driver = new ChromeDriver();
		adopt_a_pet();
	}
		
	@Test
	public void shouldAdoptWithRemoteChromeDriver() throws MalformedURLException {
		// See instruction on how to start a Selenium Standalone Server ...
		getRemoteDriver(DesiredCapabilities.chrome());
		adopt_a_pet();
	}
	
	@Test
	public void shouldAdoptWithRemoteFirefoxDriver() throws MalformedURLException {
		// See instruction on how to start a Selenium Standalone Server ...
		getRemoteDriver(DesiredCapabilities.firefox());
		adopt_a_pet();
	}
	
	private void getRemoteDriver(DesiredCapabilities browserType) throws MalformedURLException {
		URL serverUrl = new URL(REMOTE_DRIVER_URL);
		driver = new RemoteWebDriver(serverUrl, browserType);
	}
	
	private void getGhostDriver() throws MalformedURLException {
		// See instruction on how to start a PhantomJS Remote Driver ...
		URL serverUrl = new URL(PHANTOMJS_DRIVER_URL);
		DesiredCapabilities browserType = DesiredCapabilities.phantomjs();
		driver = new RemoteWebDriver(serverUrl, browserType);
	}

	private void adopt_a_pet() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(ONLINE_PUPPIES_ADOPTION_SITE);
		
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='name']"));
		List<WebElement> values = driver.findElements(By.xpath("//input[@value='View Details']"));
		
		int index = 0;
		for (WebElement name: names) {
			if (name.getText().equals("Brook")) {
				values.get(index).click();
				break;
			}
			index++;
		}

		WebElement adoptMe = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
		adoptMe.click();
		
		WebElement completeTheAdoption = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
		completeTheAdoption.click();

		WebElement orderName = driver.findElement(By.xpath("//input[@id='order_name']"));
		orderName.sendKeys("Cheezy");
		 
		WebElement orderAddr = driver.findElement(By.xpath("//textarea[@id='order_address']"));
		orderAddr.sendKeys("123 Main Street");

		WebElement orderEmail = driver.findElement(By.xpath("//input[@id='order_email']"));
		orderEmail.sendKeys("cheezy@example.com");

		WebElement select = driver.findElement(By.xpath("//select[@id='order_pay_type']"));
		Select dropDown = new Select(select);
		List<WebElement> options = dropDown.getOptions();
		for (WebElement option: options) {
			if (option.getText().equals("Check")) {
				option.click();
				break;
			}
		}
		
		WebElement commit = driver.findElement(By.xpath("//input[@name='commit']"));
		commit.click();
		
		WebElement thankYouNote = driver.findElement(By.xpath("//p[@id='notice']"));
		assertEquals ("", "Thank you for adopting a puppy!", thankYouNote.getText());
	}
}
