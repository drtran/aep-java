package com.bemach.selenium.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectTest {
	private WebDriver driver;
	private WebElement select;
	private List<WebElement> options;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("file:///C:/csd2015/sample-code/aep-java/selenium/src/main/webapp/select.html");
		select = driver.findElement(By.id("select1"));
		options = select.findElements(By.tagName("option"));
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void shouldGetOption() {
		boolean matched = false;
		for (WebElement option: options) {
			if (option.getText().equals("Joe")) {
				matched = true;
				break;
			}
		}
		assertTrue ("Option Joe should be found!", matched);
	}
	
	@Test
	public void shouldNotGetOption() {
		boolean matched = false;
		for (WebElement option: options) {
			if (option.getText().equals("John Doe")) {
				matched = true;
				break;
			}
		}
		assertFalse ("Option John Doe should not be found!", matched);
	}
	
	@Test
	public void shouldBeSelected() {
		boolean selected = false;
		for (WebElement option: options) {
			if (option.getText().equals("Tom")) {
				option.click();
				break;
			}
		}
		select = driver.findElement(By.id("select1"));
		options = select.findElements(By.tagName("option"));
		for (WebElement option: options) {
			if (option.getText().equals("Tom")) {
				selected = option.isSelected();
				break;
			}
		}
		assertTrue ("Option Tom should be selected!", selected);
	}
	
	@Test
	public void shouldNotBeSelected() {
		boolean selected = false;
		for (WebElement option: options) {
			if (option.getText().equals("Tom")) {
				option.click();
				break;
			}
		}
		select = driver.findElement(By.id("select1"));
		options = select.findElements(By.tagName("option"));
		for (WebElement option: options) {
			if (option.getText().equals("Joe")) {
				selected = option.isSelected();
				break;
			}
		}
		assertFalse ("Option Tom should not be selected!", selected);
	}
}
