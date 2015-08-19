package com.bemach.cdi.cdi_unit.ex00;

import javax.enterprise.inject.Alternative;

import com.bemach.cdi.cdi_unit.ex00.AuthenticateService;

@Alternative
public class FakeAuthenticateServiceImpl implements AuthenticateService {

	public String authenticate() {
		return "FALSE";
	}

}
