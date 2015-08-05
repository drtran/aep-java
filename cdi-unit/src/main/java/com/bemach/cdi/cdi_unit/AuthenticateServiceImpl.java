package com.bemach.cdi.cdi_unit;

public class AuthenticateServiceImpl implements AuthenticateService {
	public String authenticate() {
		System.out.println("authenticates ...");
		return "TRUE";
	}
}
