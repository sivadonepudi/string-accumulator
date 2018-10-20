/**
 * 
 */
package com.sample.application.accumulator;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation class for StringAccumulator
 * 
 * @author sidonepudi
 *
 */
public class StringAccumulator {
	private static final List<String> exitCommands = Arrays.asList("q", "Q", "quit", "QUIT", "exit", "EXIT");

	public static void main(String[] args) {
		out.println("*** Welcome to String Accumulator ***");
		out.print("Enter the input:");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();

		// as long as there is NO exit command
		while (!exitCommands.contains(input)) {

		}
		inputScanner.close();
		out.println("*** String Accumulator shutdown ***");
	}

}
