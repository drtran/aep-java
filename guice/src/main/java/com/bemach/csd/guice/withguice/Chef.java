package com.bemach.csd.guice.withguice;

import com.bemach.csd.guice.nodi.FortuneCookie;
import com.bemach.csd.guice.nodi.FortuneService;
import com.google.inject.Inject;

public class Chef {
	private final FortuneService fortuneService;

	@Inject
	public Chef(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public void makeFortuneCookie() {
		new FortuneCookie(fortuneService.randomFortune());
	}
}
