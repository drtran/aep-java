package com.bemach.cdi.cdi_unit.ex02;

import javax.enterprise.inject.Alternative;

import com.bemach.cdi.cdi_unit.ex02.AuthenticateService;

@Alternative
public class FakeAuthenticateServiceImpl implements AuthenticateService {

	public String authenticate() {
		return "FALSE";
	}

}
