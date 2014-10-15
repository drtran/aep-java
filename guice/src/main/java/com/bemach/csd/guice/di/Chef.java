package com.bemach.csd.guice.di;

import com.bemach.csd.guice.nodi.FortuneCookie;
import com.bemach.csd.guice.nodi.FortuneService;

public class Chef {
	private final FortuneService fortuneService;

	public Chef(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public void makeFortuneCookie() {
		new FortuneCookie(fortuneService.randomFortune());
	}
}
