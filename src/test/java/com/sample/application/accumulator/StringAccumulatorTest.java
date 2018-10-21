/**
 * 
 */
package com.sample.application.accumulator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the generated output format for the given input
 * 
 * @author sidonepudi
 *
 */
public class StringAccumulatorTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void init() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tierDown() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	public void testExecute() {
		Scanner mockScanner = mock(Scanner.class);
		when(mockScanner.nextLine()).thenReturn("exit");
		StringAccumulator stringAccumulator = new StringAccumulator(mockScanner);
		stringAccumulator.execute();
		assertEquals("Enter the input:*** String Accumulator shutdown ***\n", outContent.toString());
	}

	@Test
	public void testExecuteSum() {
		Scanner mockScanner = mock(Scanner.class);
		when(mockScanner.nextLine()).thenReturn("9999").thenReturn("exit");
		StringAccumulator stringAccumulator = new StringAccumulator(mockScanner);
		stringAccumulator.execute();
		StringBuilder expectedOut = new StringBuilder();
		expectedOut.append("Enter the input:");
		expectedOut.append("Sum:0\n");
		expectedOut.append("Enter the input:");
		expectedOut.append("*** String Accumulator shutdown ***\n");
		assertEquals(expectedOut.toString(), outContent.toString());
	}

	@Test
	public void testExecuteMultiple() {
		Scanner mockScanner = mock(Scanner.class);
		when(mockScanner.nextLine()).thenReturn("1\\n2,3").thenReturn("//;\n1;2").thenReturn("//***\n1***2***3")
				.thenReturn("//*|%\n1*2%3").thenReturn("exit");
		StringAccumulator stringAccumulator = new StringAccumulator(mockScanner);
		stringAccumulator.execute();
		StringBuilder expectedOut = new StringBuilder();
		expectedOut.append("Enter the input:");
		expectedOut.append("Sum:6\n");
		expectedOut.append("Enter the input:");
		expectedOut.append("Sum:3\n");
		expectedOut.append("Enter the input:");
		expectedOut.append("Sum:6\n");
		expectedOut.append("Enter the input:");
		expectedOut.append("Sum:6\n");
		expectedOut.append("Enter the input:");
		expectedOut.append("*** String Accumulator shutdown ***\n");
		assertEquals(expectedOut.toString(), outContent.toString());
	}

	@Test
	public void testExecuteSumExceptionMessage() {
		Scanner mockScanner = mock(Scanner.class);
		when(mockScanner.nextLine()).thenReturn("2,-3,-4").thenReturn("exit");
		StringAccumulator stringAccumulator = new StringAccumulator(mockScanner);
		stringAccumulator.execute();
		StringBuilder expectedOut = new StringBuilder();
		expectedOut.append("Enter the input:");
		expectedOut.append("Enter the input:");
		expectedOut.append("*** String Accumulator shutdown ***\n");
		assertEquals(expectedOut.toString(), outContent.toString());
		assertEquals("negatives not allowed: -3, -4\n", errContent.toString());
	}

}
