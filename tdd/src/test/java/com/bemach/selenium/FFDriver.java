package com.bemach.selenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FFDriver {
	@org.junit.Test
	public void Test () {
		FirefoxDriver ffd = new FirefoxDriver();
		ffd.get("http://www.bemach.com");
		System.out.println(ffd.toString());
	}
}
