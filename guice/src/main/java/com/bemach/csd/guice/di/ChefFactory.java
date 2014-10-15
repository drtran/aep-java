package com.bemach.csd.guice.di;

import com.bemach.csd.guice.nodi.FortuneServiceFactory;

public class ChefFactory {
	public Chef newChef() {
		return new Chef(FortuneServiceFactory.getFortuneService());
	}
}
