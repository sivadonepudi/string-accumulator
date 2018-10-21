/**
 * 
 */
package com.sample.application.accumulator;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sample.application.accumulator.exceptions.InvalidInputException;
import com.sample.application.accumulator.impl.StringAccumulatorImpl;

/**
 * Main application class, accepts the input from command line and computes the
 * sum
 * 
 * @author sidonepudi
 *
 */
public class StringAccumulator {
	private static final List<String> exitCommands = Arrays.asList("q", "Q", "quit", "QUIT", "exit", "EXIT");
	private Scanner inputScanner;

	public static void main(String[] args) {
		StringAccumulator mySelf = new StringAccumulator(new Scanner(System.in));
		mySelf.execute();
	}

	StringAccumulator(Scanner scanner) {
		this.inputScanner = scanner;
	}

	public void execute() {
		Accumulator<String> accumulator = new StringAccumulatorImpl();
		out.print("Enter the input:");

		String input = inputScanner.nextLine();

		// as long as there is NO exit command
		while (!exitCommands.contains(input)) {
			try {
				out.println("Sum:" + accumulator.add(input));
				out.print("Enter the input:");
				input = inputScanner.nextLine();
			} catch (InvalidInputException e) {
				err.println(e.getMessage());
				out.print("Enter the input:");
				input = inputScanner.nextLine();
			}
		}
		if (inputScanner != null) {
			inputScanner.close();
		}
		out.println("*** String Accumulator shutdown ***");
	}

}
