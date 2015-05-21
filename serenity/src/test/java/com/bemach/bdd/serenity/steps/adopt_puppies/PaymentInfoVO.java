package com.bemach.bdd.serenity.steps.adopt_puppies;

public class PaymentInfoVO {
	private String orderName = "Pet Lover";
	private String orderAddress = "123 Main Street\nBrooklyn, NY 10101";
	private String orderEmail = "petlover@email.com";
	private String orderPaymentType = "Check";
	
	public PaymentInfoVO (String orderName, String orderAddress, String orderEmail, 
			String orderPaymentType) {
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderEmail = orderEmail;
		this.orderPaymentType = orderPaymentType;
	}
	
	private String getOrderName() {
		return orderName;
	}
	
	public String getOrderAddress() {
		return orderAddress;
	}
	public String getOrderEmail() {
		return orderEmail;
	}
	public String getOrderPaymentType() {
		return orderPaymentType;
	}
	
	
}
