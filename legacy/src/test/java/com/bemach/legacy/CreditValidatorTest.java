package com.bemach.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CreditValidatorTest {

	private static final int DEFAULT_PORT = 0;
	private static final double THRESHOLD = 0;
	private CreditMaster master;
	private FakeConnection connection;
	private CreditValidator validator;
	
	@Before
	public void setUp() {
		master = new CreditMaster("crm2.mas", true);
		connection = new FakeConnection("admin", "rii8ii9s");
		validator = new CreditValidator(connection, null, "a");
	}

	@Test
	public void testCreate() throws IOException {
		IRGHConnection connection = new RGHConnection(DEFAULT_PORT, "admin", "rii8ii9s");
		CreditMaster master = new CreditMaster("crm2.mas", true);
		CreditValidator validator = new CreditValidator(connection, master, "a");
		assertNotNull(validator);
	}
	
	@Test
	public void testNoSuccess() throws Exception {
		connection.setReport(new RFDIReport());
		Certificate result = validator.validateCustomer(new Customer());
		assertEquals(Certificate.VALID, result.getStatus());
	}

	@Test
	public void testAllPassed100Percent() throws Exception {
		connection.setReport(new RFDIReport());
		Certificate result = validator.validateCustomer(new Customer());
		assertEquals(100.0, validator.getValidationPercent(), THRESHOLD);
	}
}
