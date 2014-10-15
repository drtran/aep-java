package com.bemach.northwind.datasvc;

public class Customer {

	private String companyName;
	private String customerID;
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Customer (String customerID, String companyName) {
		this.customerID = customerID;
		this.companyName = companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCustomerID() {
		return customerID;
	}

}
