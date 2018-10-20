/**
 * 
 */
package com.sample.application.accumulator;

import com.sample.application.accumulator.exceptions.InvalidInputException;

/**
 * @author sidonepudi
 *
 */

/**
 * computes the sum of given input
 * 
 * @author sidonepudi
 *
 * @param <T>
 */
public interface Accumulator<T> {
	int add(T numbers) throws InvalidInputException;
}
