package com.bemach.cdi.cdi_unit.ex00;

public class AuthenticateServiceImpl implements AuthenticateService {
	public String authenticate() {
		System.out.println("authenticates ...");
		return "TRUE";
	}
}
