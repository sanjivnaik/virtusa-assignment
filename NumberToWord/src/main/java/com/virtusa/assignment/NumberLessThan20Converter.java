package com.virtusa.assignment;

/**
 * Converts numbers with the range [0, 19] to word
 * 
 * @author Sanjiv Naik
 *
 */
class NumberLessThan20Converter implements Converter {

	@Override
	public String convert(int number) {
		if (number < 0 || number > 19) {
			throw new IllegalArgumentException("Number passed is not within the range of [0, 19]");
		}
		return NUM_LESS_THAN_20[number];
	}

}
