/**
 * 
 */
package com.sample.application.accumulator.exceptions;

/**
 * @author sidonepudi
 *
 */
public class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2956821278366742170L;
	private String message;

	public InvalidInputException(String message) {
		super(message);
		this.message = message;
	}

}
