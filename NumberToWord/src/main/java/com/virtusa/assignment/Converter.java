package com.virtusa.assignment;

import javax.annotation.Nonnull;

/**
 * Converter to convert from number to word. Each converter delegates the
 * responsibility to its child converter
 * 
 * @author Sanjiv Naik
 *
 */
interface Converter {
	static final String SPACE = " ";
	static final String EMPTY_STRING = "";

	// Numbers in words which are less than 20
	static final String[] NUM_LESS_THAN_20 = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	// Tens in words
	static final String[] TENS = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	/**
	 * Method to convert the number to word
	 * 
	 * @param number - number to convert to word
	 * @return word after conversion - never be null
	 */
	@Nonnull
	String convert(int number);
}
