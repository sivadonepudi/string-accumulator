/**
 * 
 */
package com.sample.application.accumulator;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sample.application.accumulator.exceptions.InvalidInputException;
import com.sample.application.accumulator.impl.StringAccumulatorImpl;

/**
 * Implementation class for StringAccumulator
 * 
 * @author sidonepudi
 *
 */
public class StringAccumulator {
	private static final List<String> exitCommands = Arrays.asList("q", "Q", "quit", "QUIT", "exit", "EXIT");

	public static void main(String[] args) {
		Accumulator<String> accumulator = new StringAccumulatorImpl();
		out.println("*** Welcome to String Accumulator ***");
		out.print("Enter the input:");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();

		// as long as there is NO exit command
		while (!exitCommands.contains(input)) {
			try {
				out.println("Sum:" + accumulator.add(input));
				input = inputScanner.nextLine();
			} catch (InvalidInputException e) {
				out.println(e.getMessage());
			}
		}
		inputScanner.close();
		out.println("*** String Accumulator shutdown ***");
	}

}
