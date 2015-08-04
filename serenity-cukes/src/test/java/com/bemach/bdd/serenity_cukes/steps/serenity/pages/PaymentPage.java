package com.bemach.bdd.serenity_cukes.steps.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bemach.bdd.serenity_cukes.steps.PaymentInfo;

public class PaymentPage extends PageObject {
	@FindBy (tagName = "legend", timeoutInSeconds="1")
	WebElement legend;
	
	@FindBy (id = "order_name", timeoutInSeconds="1")
	WebElement orderName;
	
	@FindBy (id = "order_address", timeoutInSeconds="1") 
	WebElement orderAddress;
	
	@FindBy (id = "order_email", timeoutInSeconds="1") 
	WebElement orderEmail;
	
	@FindBy (id = "order_pay_type", timeoutInSeconds="1") 
	WebElement orderPayType;
	
	@FindBy (xpath = "//input[@value='Place Order']", timeoutInSeconds="1") 
	WebElement placeOrder;

	public void payForAdoption(PaymentInfo payment) {
		orderName.sendKeys(payment.getOrderName());
		orderAddress.sendKeys(payment.getOrderAddress());
		orderEmail.sendKeys(payment.getOrderEmail());
		Select select = new Select(orderPayType);
		for (WebElement option: select.getOptions()) {
			if (payment.getPaymentType().equals(option.getText())) {
				option.click();
				break;
			}
		}
		placeOrder.click();
	}
	
}
