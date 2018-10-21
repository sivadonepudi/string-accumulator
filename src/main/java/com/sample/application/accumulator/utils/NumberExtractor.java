/**
 * 
 */
package com.sample.application.accumulator.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class to identify the numbers present in the given input String
 * 
 * @author sidonepudi
 *
 */
public class NumberExtractor {
	private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

	/**
	 * Returns the list of all values present in the given input
	 * 
	 * @param input
	 * @return
	 */
	public static List<Integer> getNumbers(String input) {
		Matcher matcher = NUMBER_PATTERN.matcher(input);
		List<Integer> numbers = new LinkedList<Integer>();
		while (matcher.find()) {
			int number = Integer.parseInt(matcher.group());
			numbers.add(number);
		}
		return numbers;
	}
}
