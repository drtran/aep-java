package com.bemach.tdd.tools.mortgage.solutions.ex1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.bemach.tdd.tools.mortgage.solutions.ex1.Calculator;

/**
 * Exercise #1:
 * 
 * Solution to Calculator as a mortgage tool:
 * 1. Create a CalculatorTest class.
 * ----
 * 2. Create a test method called, canCreateCalculatorObject().
 * 2.1. Get a compilation error for new Calculator()
 * 2.2. Resolve the compilation error by creating a new Calculator class in the 
 *      src/main/java folder.
 * 2.3. assert that the object is not null (assertNotNull).
 * 2.4. run JUnit.
 * 2.5. Expect Green
 * ---
 * 3. Create a test method called, canComputeMonthlyInterest.
 * 3.1. create a Calculator object.
 * 3.2. call setPrinciple () method. DONOT enter code yet. Just make it compiled.
 * 3.3. call setInterestRate () method. HARDCODE the values for now.
 * 3.4. call getMonthlyInterest() method.
 * 3.5. Resolve compilation errors for the three new method.
 *      use principle 100000 interestRate .05 and expected value of 
 *      100000 * (0.05/12.0).
 * 3.6. assert that the returned monthlyInterest is correct.
 * 3.7. Run Junit & expect Red.
 * 3.8. Go to Calculator class and fill in necessary code for computing
 *      monthlyInterest (save principle, interestRate and compute the monthly
 *      interest using this formula = principle * interestRate/12.0).
 * 3.9. Run Junit Test and expect green.
 * ---
 * Stop and ponder a little bit.
 * Refactor time:
 * 
 * 4. Move calculator object as a class member as opposed to local variable.
 * 4.1 Add @Before and @After although @After is not used. Have the object creation
 *    done in @Before method.
 * 4.2 Run Junit test to make sure the tests are still good.
 * ----
 * Ponder a little more.
 * Can we make this thing runs with more than one set of test cases?
 * Consider use Parameterized test case.
 * 5. Introduce Parameterized technique to test more than one set of test cases.
 * 5.1. Write new CalculatorTest constructor to take in principle and interestRate
 *      value. Calculated expectedValue as well in the constructor.
 * 5.2. Use @Parameters to code a new collection of the same-size objects.
 * 5.3. Make sure to add @RunWith (Parameterized.class) annotation.
 * 5.4. Refactor the canComputeMonthlyInterest to use class member variables.
 * 5.5. Run Junit test and expect Green.
 * ----
 * Ponder a little more.
 * Can we test a negative interest rate? Let's fix the getMonthlyInterest()
 * method to throw an exception when the interestRate is negative.
 * 6. Create a cannotComputeMonthlyInterestWithNegativeInterestRate()
 * 6.1. make sure to include (expected = Exception.class) so that the
 *      test can go Green.
 * 6.2. Make sure to use -.05 as a negative interest rate.
 * 6.3. Run Junit test and expected Green.
 *
 * 
 * @author ktran
 *
 */
@RunWith(Parameterized.class) 
public class CalculatorTest {

	private Calculator calculator;
	private Double principle;
	private Double interestRate;
	private Double expectedMonthlyInterest;
	
	public CalculatorTest(Double principle, Double interestRate) {
		this.principle = principle;
		this.interestRate = interestRate;
		this.expectedMonthlyInterest = principle * (interestRate/12.0);
	}
	
	@Parameters
	public static Collection<Double[]> parameterList () {
		return Arrays.asList(new Double[][] {
				{new Double (100000.00), new Double(0.05)},
				{new Double (300000.00), new Double(0.065)},
				{new Double (100000.00), new Double(0.00)}
		});
	}
	
	@Before 
	public void setUp () {
		calculator = new Calculator();
	}
	
	@Test
	public void canCreateCalculatorObject() {
		assertNotNull(calculator);
	}

	@Test 
	public void canComputeMonthlyInterest() throws Exception {
		calculator.setPrinciple (principle);
		calculator.setInterestRate (interestRate);
		Double monthlyInterest = calculator.getMonthlyInterest();
		assertEquals(expectedMonthlyInterest, monthlyInterest);
	}
	
	@Test (expected = Exception.class)
	public void cannotComputeMonthlyInterestWithNegativeInterestRate() throws Exception {
		calculator.setPrinciple (new Double (100000));
		calculator.setInterestRate (new Double (-.05));
		Double monthlyInterest = calculator.getMonthlyInterest();
		assertEquals(expectedMonthlyInterest, monthlyInterest);
	}
	
	@After 
	public void tearDown () {
		
	}
}
