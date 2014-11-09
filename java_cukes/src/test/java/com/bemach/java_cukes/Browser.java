package com.bemach.java_cukes;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	private static ChromeDriver driver = null;
	
	public Browser() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
	}

	public void close() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

	public static ChromeDriver getDriver() {
		return driver;
	}

	public void goTo(String url) {
		driver.get(url);
	}

	public WebElement input(String attr, String using) {
		wait_for_ajax();
		return find ("input", attr.toLowerCase(), using);
	}

	private void wait_for_ajax() {
	}

	public WebElement button(String attr , String using) {
		wait_for_ajax();
		return find ("button", attr.toLowerCase(), using);
	}

	private WebElement find(String tagName, String attribute, String using) {
		List<WebElement> weList = driver.findElementsByTagName(tagName);
		for (WebElement we: weList) {
			if (we.getAttribute(attribute).equals(using))
				return we;
		}
		return null;
	}

	public WebElement span(String attr, String using) {
		wait_for_ajax();
		return find ("span", attr.toString().toLowerCase(), using);
	}
}
