package com.bemach.java_cukes;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseScenario {

	protected static Browser browser = null;

	public static Browser getBrowser() {
		return browser;
	}

	public static void setBrowser(Browser browser) {
		BaseScenario.browser = browser;
	}

	public BaseScenario() {
		super();
	}

	@Before
	public void setup() {
		if (browser == null) {
			browser = new Browser();
		}
	}

	@After
	public void destroy() {
		if (browser != null) {
			browser.close();
			browser = null;
		}
	}
	
}