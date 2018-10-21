/**
 * 
 */
package com.sample.application.accumulator.validator;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author sidonepudi
 *
 */
public class Predicates {
	public static final Predicate<Object> NULL = obj -> Objects.isNull(obj);
	public static final Predicate<String> EMPTY = s -> s.trim().isEmpty();
	public static final Predicate<String> ENDS_WITH_NEW_LINE = s -> s.endsWith("\n") || s.endsWith("\\n");
	public static final Predicate<Integer> BIGGER_THAN_1000 = i -> i > 1000;
	public static final Predicate<String> NEGATIVE_VALUE = s -> s.trim().contains("-");
	public static final Predicate<String> COLON = s -> s.contains("\'") || s.contains("\\''") || s.contains("\"")
			|| s.contains("\\\"");
}
