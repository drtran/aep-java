package com.bemach.csd.guice.nodi;

public class Chef {
	private FortuneService fortuneService;

	public Chef() {
		this.fortuneService = FortuneServiceFactory.getFortuneService();
	}

	public void makeFortuneCookie() {
		new FortuneCookie(fortuneService.randomFortune());
	}
}
