package com.bemach.legacy;

public class CreditValidator {
	public CreditValidator(IRGHConnection connection, CreditMaster master,
			String validatorID) {

	}

	Certificate validateCustomer(Customer customer) throws InvalidCredit {
		return new Certificate();
	}

	public double getValidationPercent() {
		return 100;
	}

}
