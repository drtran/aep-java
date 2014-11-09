package com.bemach.java_cukes;

import java.util.Hashtable;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuyBooksAtBnSteps {

	private Browser browser;
	private String url;
	private String search_text;
	

	@Before
	public void setup() {
		browser = new Browser();
	}
	
	@After
	public void tearDown() {
		browser.close();
	}
	
	@Given("^that I am on bn website url:$")
	public void that_I_am_on_bn_website_url(String url) throws Throwable {
		this.url = url;
	    browser.goTo (url);
	}

	@Given("^I search for a \"([^\"]*)\" book$")
	public void I_search_for_a_book(String search_text) throws Throwable {
		browser.input("id", "keyword").sendKeys(search_text);
		browser.button("class", "branded").click();
		this.search_text = search_text;
	}

	@Given("^I choose \"([^\"]*)\"$")
	public void I_choose(String book_name) throws Throwable {
		browser.span("title", book_name).click();
	}

	@When("^I click Add to Cart button$")
	public void I_click_Add_to_Cart_button() throws Throwable {
		browser.button("class", "primary primary add-to-cart").click();
	}

	@Then("^I should see \"([^\"]*)\" item in my shopping cart$")
	public void I_should_see_item_in_my_shopping_cart(String count) throws Throwable {
		WebElement cart = browser.span("class", "standard");
		if (cart == null) {
			cart = browser.span("class", "cartQty");
		}
		Assert.assertEquals(count, cart.getText());
	}
	
	@Given("^I choose these books:$")
	public void I_choose_these_books(List<List<String>> table) throws Throwable {
		TableUtil tableUtil = new TableUtil();
		List<Hashtable<String,String>> listOfBookNames = tableUtil.symbolicHash(table);
		for (Hashtable<String,String> bookName: listOfBookNames) {
			browser.span("title", bookName.get("book_title")).click();
			browser.button("class", "primary primary add-to-cart").click();
			browser.goTo(url);
			browser.input("id", "keyword").sendKeys(search_text);
			browser.button("class", "branded").click();
		}
	}

}
