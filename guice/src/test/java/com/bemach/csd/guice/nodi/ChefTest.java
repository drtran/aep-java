package com.bemach.csd.guice.nodi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bemach.csd.guice.nodi.Chef;
import com.bemach.csd.guice.nodi.FortuneService;
import com.bemach.csd.guice.nodi.FortuneServiceFactory;

public class ChefTest {
	@Test
	public void makeFortuneCookie() {
		final FortuneService original = FortuneServiceFactory
				.getFortuneService();
		try {
			FortuneServiceMock mock = new FortuneServiceMock();
			FortuneServiceFactory.setFortuneService(mock);
			Chef chef = new Chef();
			chef.makeFortuneCookie();
			assertTrue(mock.calledOnce());
		} finally {
			FortuneServiceFactory.setFortuneService(original);
		}
	}

	class FortuneServiceMock implements FortuneService {
		private int invocationCount;

		public String randomFortune() {
			invocationCount++;
			return "MOCK";
		}

		public boolean calledOnce() {
			return invocationCount == 1;
		}
	}
}
