package com.bemach.selenium.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bemach.selenium.tests.DriverUtil.DRIVER_TYPE;

public class SelectElementTest {
	private WebDriver driver;
	private WebElement selectElement;
	private List<WebElement> options;
	private Select select;

	@Before
	public void setUp() throws MalformedURLException {
		System.setProperty("REMOTE_BROWSER", "TRUE");
		if (Boolean.valueOf(System.getProperty("REMOTE_BROWSER"))) {
			driver = DriverUtil.getDriver(DRIVER_TYPE.REMOTE);
		} else {
			driver = DriverUtil.getDriver(DRIVER_TYPE.LOCAL);
		}
		
		driver.get("file:///C:/csd2015/sample-code/aep-java/selenium/src/main/webapp/select.html");
		selectElement = driver.findElement(By.id("select1"));
		options = selectElement.findElements(By.tagName("option"));
		select = new Select (selectElement);
	}
	
	@After
	public void tearDown () {
		DriverUtil.quit(driver);
	}

	
	@Test 
	public void shouldSelectOption() {
		select.selectByValue("frank");
		boolean selected = false;
		selectElement = driver.findElement(By.id("select1"));
		select = new Select (selectElement);
		selected = select.getFirstSelectedOption().getAttribute("value").equals("frank");
		assertTrue ("Option Frank should be selected!", selected);
	}
	
	@Test 
	public void shouldNotSelectOption() {
		select.selectByValue("frank");
		boolean selected = false;
		selectElement = driver.findElement(By.id("select1"));
		select = new Select (selectElement);
		selected = select.getFirstSelectedOption().getAttribute("value").equals("joe");
		assertFalse ("Option Joe should not be selected!", selected);
	}
}
