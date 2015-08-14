package com.bemach.selenium.pages.puppies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.bemach.selenium.PaymentInfo;

public class PaymentPage {
	@FindBy (how = How.XPATH, using = "//*[@id='content']/div[2]/fieldset/legend")
	private WebElement paymentPageLabelElmt;
	
	@FindBy (how = How.XPATH, using = "//input[@id='order_name']")
	private WebElement orderNameElmt;
	
	@FindBy (how = How.XPATH, using = "//textarea[@id='order_address']")
	private WebElement orderAddressElmt;
	
	@FindBy (how = How.XPATH, using = "//input[@id='order_email']") 
	private WebElement orderEmailElmt;
	
	@FindBy (how = How.XPATH, using = "//select[@id='order_pay_type']")
	private WebElement payTypeElmt;
	
	@FindBy (how = How.XPATH, using = "//input[@name='commit']")
	private WebElement placeOrderButtonElmt;
	
	public Object getPageLabel() {
		return paymentPageLabelElmt.getText();
	}

	public void pay(PaymentInfo paymentInfo) {
		orderNameElmt.sendKeys(paymentInfo.getName());
		orderAddressElmt.sendKeys(paymentInfo.getAddress());
		orderEmailElmt.sendKeys(paymentInfo.getEmail());
		Select select = new Select(payTypeElmt);
		List<WebElement> options = select.getOptions();
		for (WebElement option: options) {
			if (option.getText().equals(paymentInfo.getPayType())) {
				option.click();
				break;
			}
		}
		
		placeOrderButtonElmt.click();
	}

}
