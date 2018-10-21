/**
 * 
 */
package com.sample.application.accumulator.exceptions;

/**
 * User defined exception, will be thrown for invalid input
 * 
 * @author sidonepudi
 *
 */
public class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2956821278366742170L;

	public InvalidInputException(String message) {
		super(message);
	}

}
