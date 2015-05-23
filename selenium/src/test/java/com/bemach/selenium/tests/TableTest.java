package com.bemach.selenium.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("file:///C:/csd2015/sample-code/aep-java/selenium/src/main/webapp/table.html");
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void shouldGetRowFromTable() {
		WebElement outerTable = driver.findElement(By.tagName("table"));
		WebElement innerTable = outerTable.findElement(By.tagName("table"));
		List<WebElement> rows = innerTable.findElements(By.tagName("td"));
		String expectedText = "Table 2 Row 2";
		assertEquals(String.format("Second row of inner table should contain %s", expectedText), 
				expectedText , rows.get(1).getText());
	}
	
	@Test
	public void shouldGetRowFromTableUsingXpath() {
		WebElement row = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
		String expectedText = "Table 2 Row 2";
		assertEquals(String.format("Second row of inner table should contain %s", expectedText), 
				expectedText , row.getText());
	}
	
	
}
