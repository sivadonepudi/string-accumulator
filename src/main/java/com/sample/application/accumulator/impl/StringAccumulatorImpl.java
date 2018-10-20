/**
 * 
 */
package com.sample.application.accumulator.impl;

import java.util.Arrays;

import com.sample.application.accumulator.Accumulator;
import com.sample.application.accumulator.exceptions.InvalidInputException;
import com.sample.application.accumulator.validator.Predicates;

/**
 * Implementation class for StringAccumulator
 * 
 * @author sidonepudi
 *
 */
public class StringAccumulatorImpl implements Accumulator<String> {

	/**
	 * computes the sum of given input(string format)
	 */
	@Override
	public int add(String numbers) throws InvalidInputException {
		if (Predicates.NULL.test(numbers)) {
			return 0;
		}
		if (Predicates.EMPTY.test(numbers)) {
			return 0;
		}
		if (Predicates.ENDS_WITH_NEW_LINE.test(numbers)) {
			throw new InvalidInputException("new lines at the end is NOT allowed");
		}

		return Arrays.stream(numbers.split(",")).mapToInt(n -> Integer.parseInt(n.trim())).sum();
	}

}
