package com.bemach.cdi.cdi_unit;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class LoginBean {
	
	@Inject
	private AuthenticateService authenticateSvc;

	public LoginBean() {
		
	}
	
	@PostConstruct
	public void startUp() {
		System.out.println ("result: " + authenticateSvc.authenticate());
	}
}
