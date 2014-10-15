package com.bemach.northwind.datasvc;

public interface DataService {
	public Customer getCustomerByCompanyName(String companyName);
	public Customer getCustomerByCustomerID(String expectedCustomerID);
}
