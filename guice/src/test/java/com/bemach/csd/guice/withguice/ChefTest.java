package com.bemach.csd.guice.withguice;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bemach.csd.guice.nodi.FortuneService;

public class ChefTest {
	@Test
	public void makeFortuneCookie() {
		FortuneServiceMock mock = new FortuneServiceMock();
		Chef chef = new Chef(mock);
		chef.makeFortuneCookie();
		assertTrue(mock.calledOnce());
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
