package com.bemach.northwind.datasvc;

public class DataManager {

	private DataService dataSvc;
	
	public DataManager(DataService dataSvc) {
		this.dataSvc = dataSvc;
	}

	public Customer getCustomerByCompanyName(String companyName) {
		return dataSvc.getCustomerByCompanyName(companyName);
	}

	public Customer getCustomerByCustomerID(String expectedCustomerID) {
		return dataSvc.getCustomerByCustomerID(expectedCustomerID);
	}

}
