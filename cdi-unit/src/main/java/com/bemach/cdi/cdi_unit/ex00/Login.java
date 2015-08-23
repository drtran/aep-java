package com.bemach.cdi.cdi_unit.ex00;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class Login {
	
	@Inject
	private AuthenticateService authenticateSvc;

	public Login() {
		
	}
	
	@PostConstruct
	public void startUp() {
		System.out.println ("result: " + authenticateSvc.authenticate());
	}
}
