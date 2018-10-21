/**
 * 
 */
package com.sample.application.accumulator.validator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author sidonepudi
 *
 */
public class PredicatesTest {
	@Test
	public void testNullCheck() {
		assertThat(Predicates.NULL.test(null), is(Boolean.TRUE));
		assertThat(Predicates.NULL.test(""), is(Boolean.FALSE));
		assertThat(Predicates.NULL.test("2,3"), is(Boolean.FALSE));
	}

	@Test
	public void testEmptyCheck() {
		assertThat(Predicates.EMPTY.test(""), is(Boolean.TRUE));
		assertThat(Predicates.EMPTY.test("\t"), is(Boolean.TRUE));
		assertThat(Predicates.EMPTY.test("  "), is(Boolean.TRUE));
		assertThat(Predicates.EMPTY.test("				"), is(Boolean.TRUE));
		assertThat(Predicates.EMPTY.test("\n\n\t\t"), is(Boolean.TRUE));
		assertThat(Predicates.EMPTY.test("2,33"), is(Boolean.FALSE));
	}

	@Test
	public void testBiggerThan1000() {
		assertThat(Predicates.BIGGER_THAN_1000.test(1001), is(Boolean.TRUE));
		assertThat(Predicates.BIGGER_THAN_1000.test(1000), is(Boolean.FALSE));
	}

	@Test
	public void testNegativeValue() {
		assertThat(Predicates.NEGATIVE_VALUE.test(1001), is(Boolean.FALSE));
		assertThat(Predicates.NEGATIVE_VALUE.test(-1001), is(Boolean.TRUE));
	}

	@Test
	public void testEndsWithNewLine() {
		assertThat(Predicates.ENDS_WITH_NEW_LINE.test("1001\n"), is(Boolean.TRUE));
		assertThat(Predicates.ENDS_WITH_NEW_LINE.test("1001\n\n\n"), is(Boolean.TRUE));
		assertThat(Predicates.ENDS_WITH_NEW_LINE.test("1001\\n"), is(Boolean.TRUE));
	}

}
