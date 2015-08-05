package com.bemach.cdi.cdi_unit;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
@ActivatedAlternatives(FakeAuthenticateServiceImpl.class)
public class LoginBeanTest {
	@Inject
	private LoginBean loginBean;
	
//	@Produces  
//	@Mock
//	private AuthenticateServiceImpl authenticateSvc;
	
	@Before 
	public void setUp() {
//		Mockito.when(authenticateSvc.authenticate()).thenReturn("FALSE");
	}
	
	@Test
	public void shouldCreateInstance() {
		
		assertNotNull("", loginBean);
	}
}
