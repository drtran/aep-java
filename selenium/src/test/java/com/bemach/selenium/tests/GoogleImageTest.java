package com.bemach.selenium.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleImageTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void shouldGetImage() {
		WebElement searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.sendKeys("tdd\n");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement outerDiv = driver.findElement(By.id("hdtb-msb"));
		//List<WebElement> as = outerDiv.findElements(By.className("q qs"));
		List<WebElement> as = driver.findElements(By.xpath("//*[@id='hdtb-msb']//*[@class='q qs']"));
		as.get(2).click();
		
		List<WebElement> imageLinks = driver.findElements(By.className("rg_di"));
		imageLinks.get(6).click();
		assertTrue(true);
	}
}
