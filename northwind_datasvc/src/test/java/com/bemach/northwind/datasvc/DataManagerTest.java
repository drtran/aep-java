package com.bemach.northwind.datasvc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

/**
 * List to do:
 * 
 * 1. get a customer by company name - with multiple names using parameters
 * 2. get a customer by customer id
 * 3. add a new customer
 * 4. update an existing customer
 * 5. delete an existing customer
 * 6. get all customers
 * 
 * @author ktran
 *
 */
@RunWith(Parameterized.class)
public class DataManagerTest {
	
	private String expectedComapnyName;
	private String expectedCustomerID;
	private DataService mockDataService;
	
	@Before
	public void setUp() {
		mockDataService = Mockito.mock(DataService.class);
		Customer cust = new Customer(expectedCustomerID, expectedComapnyName);
		Mockito.when(mockDataService.getCustomerByCompanyName(expectedComapnyName)).thenReturn (cust);
		Mockito.when(mockDataService.getCustomerByCustomerID(expectedCustomerID)).thenReturn (cust);
	}
	
	public DataManagerTest(String expectedCustomerID, String expectedCompanyName) {
		this.expectedCustomerID = expectedCustomerID;
		this.expectedComapnyName = expectedCompanyName;
	}
	
	@Parameters
	public static Collection<String[]> getTestParameters() {
		return Arrays.asList(new String[][] {
				{"ERNSH", "Ernst Handel"},
				{"ESTC", "Eastern Connection"}, 
				{"BLAUS", "Blauer See Delikatessen"},
				{"BOTTM", "Bottom-Dollar Markets"},
				{"BONAP", "Bon App"}
		});
	}
	
	@Test
	public void shouldAllowGetCustomerByCompanyName() {
		DataManager dataMgr = new DataManager(mockDataService);
		Customer customer = dataMgr.getCustomerByCompanyName(expectedComapnyName);
		String actualCompanyName = customer.getCompanyName();
		Assert.assertEquals(expectedComapnyName, actualCompanyName);
	}
	
	@Test
	public void shouldAllowGetCustomerByCustomerID() {
		DataManager dataMgr = new DataManager(mockDataService);
		Customer customer = dataMgr.getCustomerByCustomerID(expectedCustomerID);
		String actualCustomerID = customer.getCustomerID();
		Assert.assertEquals(expectedCustomerID, actualCustomerID);
	}
}
