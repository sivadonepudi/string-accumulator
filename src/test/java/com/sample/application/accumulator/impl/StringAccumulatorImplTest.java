/**
 * 
 */
package com.sample.application.accumulator.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sample.application.accumulator.Accumulator;
import com.sample.application.accumulator.exceptions.InvalidInputException;

/**
 * @author sidonepudi
 *
 */
public class StringAccumulatorImplTest {
	private Accumulator<String> stringAccumulator;

	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

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
		stringAccumulator.add("2,4\\n");
	}

	/**
	 * Validates the input data ending with \n
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testAddEndsWithNewLineExceptionMessage() throws InvalidInputException {
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("delimiter, \n is NOT allowed at the end");
		stringAccumulator.add("4\n");
	}

	/**
	 * Validates single value input
	 */

	@Test
	public void testAddOneParameter() {
		try {
			assertThat(stringAccumulator.add("1"), is(1));
			assertThat(stringAccumulator.add("999"), is(999));
		} catch (InvalidInputException e) {
			fail();
		}
	}

	/**
	 * Validates sum, space included among values
	 */
	@Test
	public void testAdd() {
		try {
			assertThat(stringAccumulator.add("1,2,3"), is(6));
			assertThat(stringAccumulator.add("1, 2, 3"), is(6));
			assertThat(stringAccumulator.add("1, 2, 3, 1001"), is(6));
			assertThat(stringAccumulator.add("100100"), is(0));
			assertThat(stringAccumulator.add("1000"), is(1000));
		} catch (InvalidInputException e) {
			fail();
		}
	}

	/**
	 * Validates the negative input
	 * 
	 * @throws InvalidInputException
	 */
	@Test(expected = InvalidInputException.class)
	public void testAddNegativeInput() throws InvalidInputException {
		stringAccumulator.add("-1,2,3");
		stringAccumulator.add("1000,2,-3");
	}

	/**
	 * Validates the negative input exception message
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testAddNegativeInputExceptionMessage() throws InvalidInputException {
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("negatives not allowed: -5");
		stringAccumulator.add("-5,2,3");
	}

	/**
	 * Validates the negative input exception message
	 * 
	 * @throws InvalidInputException
	 */
	@Test
	public void testAddMultipleNegativeInputExceptionMessage() throws InvalidInputException {
		expectedException.expect(InvalidInputException.class);
		expectedException.expectMessage("negatives not allowed: -5, -1000");
		stringAccumulator.add("-5,2,3\n-1000");
	}

	/**
	 * Validates sum, space included among values
	 */
	@Test
	public void testDelimiters() {
		try {
			assertThat(stringAccumulator.add("1,2\n3"), is(6));
			assertThat(stringAccumulator.add("1, 2, 3"), is(6));
			assertThat(stringAccumulator.add("//***\\n1***2***3"), is(6));
			assertThat(stringAccumulator.add("//***\\n1***2***3***5555"), is(6));
			assertThat(stringAccumulator.add("//*|%\\n1*2%3"), is(6));
		} catch (InvalidInputException e) {
			fail();
		}
	}

}
