package com.bemach.csd.guice.nodi;

public class FortuneServiceFactory {
	private FortuneServiceFactory() {
	}

	private static FortuneService fortuneService = new FortuneServiceImpl();

	public static FortuneService getFortuneService() {
		return fortuneService;
	}

	public static void setFortuneService(FortuneService mockFortuneService) {
		fortuneService = mockFortuneService;
	}
}
