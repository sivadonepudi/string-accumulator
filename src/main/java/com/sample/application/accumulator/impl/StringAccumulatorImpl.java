/**
 * 
 */
package com.sample.application.accumulator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

		List<String> negativeValues = new ArrayList<String>();

		IntStream intStream = Arrays.stream(numbers.split(",")).mapToInt(n -> {
			// Negative input check
			if (Predicates.NEGATIVE_VALUE.test(n.trim())) {
				negativeValues.add(n);
				return 0;
			}
			// Numbers bigger than 1000 should be ignored,
			if (Predicates.BIGGER_THAN_1000.test(Integer.parseInt(n.trim()))) {
				return 0;
			}
			return Integer.parseInt(n.trim());
		});

		int sum = intStream.sum();
		if (negativeValues.size() > 0) {
			throw new InvalidInputException("negatives not allowed");
		}
		return sum;
	}

}
