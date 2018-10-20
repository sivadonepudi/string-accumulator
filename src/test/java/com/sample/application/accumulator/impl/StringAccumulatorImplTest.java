/**
 * 
 */
package com.sample.application.accumulator.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.sample.application.accumulator.Accumulator;
import com.sample.application.accumulator.exceptions.InvalidInputException;
import com.sample.application.accumulator.impl.StringAccumulatorImpl;

/**
 * @author sidonepudi
 *
 */
public class StringAccumulatorImplTest {
	private Accumulator<String> stringAccumulator;

	@Before
	public void init() {
		stringAccumulator = new StringAccumulatorImpl();
	}

	/**
	 * Validates the behavior for empty input
	 */
	@Test
	public void testAddEmpty() {
		try {
			assertThat(stringAccumulator.add(null), is(0));
			assertThat(stringAccumulator.add(""), is(0));
			assertThat(stringAccumulator.add("       "), is(0));
			assertThat(stringAccumulator.add("	"), is(0));
			assertThat(stringAccumulator.add(" \t"), is(0));
			assertThat(stringAccumulator.add(" \n\t\n"), is(0));
		} catch (InvalidInputException e) {
			fail();
		}
	}

	/**
	 * Validates the input data ending with \n
	 * 
	 * @throws InvalidInputException
	 */
	@Test(expected = InvalidInputException.class)
	public void testAddEndsWithNewLine() throws InvalidInputException {
		stringAccumulator.add("4\n");
		stringAccumulator.add("4, 3, 4\n");
		stringAccumulator.add("		\n");
	}

	// @Test
	public void testAddOneParameter() {
		try {
			assertThat(stringAccumulator.add("1"), is(1));
			assertThat(stringAccumulator.add("999"), is(999));
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}

}
