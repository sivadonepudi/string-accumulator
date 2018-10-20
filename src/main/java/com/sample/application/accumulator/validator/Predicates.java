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
	public static final Predicate<String> ENDS_WITH_NEW_LINE = s -> s.endsWith("\n");
}
