package com.bemach.selenium;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumTest {
	
	@Test
	public void ChromeDriverTest() {
		FirefoxDriver ffDriver = new FirefoxDriver();
		ffDriver.get("http://www.google.com");
		System.out.println(ffDriver.toString());
		System.out.println(ffDriver.getSessionId());
		List<WebElement> we = ffDriver.findElementsByName("q");
		for (WebElement webE : we) {
			System.out.println("tagName="+webE.getTagName());
			System.out.println("tagName="+webE.getText());
		}
		ffDriver.quit();
	}
}
