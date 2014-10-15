package com.bemach.csd.guice.withguice;

import com.bemach.csd.guice.nodi.FortuneService;
import com.bemach.csd.guice.nodi.FortuneServiceImpl;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

public class ChefModule implements Module {
	public void configure(Binder binder) {
		binder.bind(FortuneService.class)
		.to(FortuneServiceImpl.class)
		.in(Scopes.SINGLETON);
		}
}
