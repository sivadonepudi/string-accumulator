/**
 * 
 */
package com.sample.application.accumulator.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author sidonepudi
 *
 */
public class NumberExtractorTest {

	/**
	 * Validates the numbers of integers present in the given input
	 */
	@Test
	public void testGetNumbers() {
		assertThat(NumberExtractor.getNumbers("1,2,3").size(), is(3));
		assertThat(NumberExtractor.getNumbers("1\n2,3").size(), is(3));
		assertThat(NumberExtractor.getNumbers("//*|%\\n1*2%3").size(), is(3));
		assertThat(NumberExtractor.getNumbers("1\n\t2\n   3").size(), is(3));
		assertThat(NumberExtractor.getNumbers("//***\\n1***2***3").size(), is(3));
		assertThat(NumberExtractor.getNumbers("1\n2,-3").size(), is(3));
		assertThat(NumberExtractor.getNumbers("//;\\n1;2").size(), is(2));
	}

	@Test
	public void testGetNumbersInvalidScenarios() {
		assertThat(NumberExtractor.getNumbers("1,2,3").size(), is(not(5)));
		assertThat(NumberExtractor.getNumbers("1\n2,3").size(), is(not(5)));
		assertThat(NumberExtractor.getNumbers("//*|%\\n1*2%3").size(), is(not(5)));
		assertThat(NumberExtractor.getNumbers("1\n\t2\n   3").size(), is(not(5)));
		assertThat(NumberExtractor.getNumbers("//***\\n1***2***3").size(), is(not(5)));
		assertThat(NumberExtractor.getNumbers("1\n2,-3").size(), is(not(5)));
		assertThat(NumberExtractor.getNumbers("//;\\n1;2").size(), is(not(5)));
	}

}
