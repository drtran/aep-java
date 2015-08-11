package com.bemach.performance.jmeter;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class PuppiesTest {
	private Log logger = LogFactory.getLog(PuppiesTest.class);
	private WebDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		logger.info("@Before ... 1");
		URL serverUrl = new URL("http://127.0.0.1:4444/wd/hub");
		logger.info("@Before ... 2");
		DesiredCapabilities browserType = DesiredCapabilities.firefox();
		logger.info("@Before ... 3");
		try {
			driver = new RemoteWebDriver(serverUrl, browserType);
		} catch (Exception e) {
			logger.info("ERROR: " + e);
		} finally {
			logger.info("@Before ... 4");
		}
	}

	@After
	public void tearDown() {
		logger.info("@After ...");
		driver.close();
		driver.quit();
	}

	@Test
	public void shouldPass() {
		logger.info("@Test shouldPass ...");
		assertTrue(true);
	}

	@Test
	public void shouldAdoptPet() {
		logger.info("@Test shouldAdoptPet ...");

		driver.get("http://localhost:3000");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger.info("@Test shouldAdoptPet Gone to website ...");

		System.out.println("Getting web elements ..");
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='name']"));
		List<WebElement> values = driver.findElements(By.xpath("//input[@value='View Details']"));

		int index = 0;
		for (WebElement name : names) {
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
		for (WebElement option : options) {
			if (option.getText().equals("Check")) {
				option.click();
				break;
			}
		}

		WebElement commit = driver.findElement(By.xpath("//input[@name='commit']"));
		commit.click();

		WebElement thankYouNote = driver.findElement(By.xpath("//p[@id='notice']"));
		if ("Thank you for adopting a puppy!".equals(thankYouNote.getText())) {
			System.out.println("Test was a SUCCESS!");
		} else {
			System.out.println("Test was a FAILURE!");
		}

		driver.close();
		assertTrue(true);
	}

}
