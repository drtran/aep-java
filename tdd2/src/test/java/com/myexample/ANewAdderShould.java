package com.myexample;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ANewAdderShould {
	private Adder adder = new Adder();
	
	@Before
	public void init() {
		adder = new Adder();
	}
	
	@Test
	public void Have0InItsAccumulator() {

		assertEquals(BigDecimal.ZERO,adder.getAccumulator());
	}
	
	@Test
	public void AllowItsAccumulatorToBeSet() {
		BigDecimal value = new BigDecimal(55);
		adder.setAccumulator(value);
		assertEquals(value,adder.getAccumulator());		
	}
}
