/**
 * 
 */
package com.sample.application.accumulator.impl;

import java.util.stream.IntStream;

import com.sample.application.accumulator.Accumulator;
import com.sample.application.accumulator.exceptions.InvalidInputException;
import com.sample.application.accumulator.utils.NumberExtractor;
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
		if ((Predicates.NULL.test(numbers)) || Predicates.EMPTY.test(numbers)) {
			return 0;
		}
		if (Predicates.ENDS_WITH_NEW_LINE.test(numbers)) {
			throw new InvalidInputException("new lines at the end is NOT allowed");
		}

		StringBuilder negativeValues = new StringBuilder();

		IntStream intStream = NumberExtractor.getNumbers(numbers).stream().mapToInt(n -> {
			// Negative input check
			if (Predicates.NEGATIVE_VALUE.test(n)) {
				negativeValues.append(n);
				negativeValues.append(", ");
				return 0;
			}
			// Numbers bigger than 1000 should be ignored,
			if (Predicates.BIGGER_THAN_1000.test(n)) {
				return 0;
			}
			return n;
		});

		int sum = intStream.sum();
		// If there is at least one negative number
		if (negativeValues.length() > 0) {
			throw new InvalidInputException("negatives not allowed: "
					+ negativeValues.deleteCharAt(negativeValues.lastIndexOf(",")).toString());
		}
		return sum;
	}

}
