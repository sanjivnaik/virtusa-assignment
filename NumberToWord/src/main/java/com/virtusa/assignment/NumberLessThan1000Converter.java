package com.virtusa.assignment;

/**
 * Converts numbers with the range [0, 999] to word
 * 
 * @author Sanjiv Naik
 *
 */
class NumberLessThan1000Converter extends AbstractNumberToWordConverter {

	private static final String AND = " and ";
	private static final String HUNDRED = " hundred";

	NumberLessThan1000Converter(Converter chain) {
		super(chain);
	}

	@Override
	public String convert(int number) {
		if (number < 0 || number > 999) {
			throw new IllegalArgumentException("Number passed is not within the range of [0, 999]");
		}
		
		String word = chain.convert(number % 100);
		if (number < 100) {
			return word;
		}
		return NUM_LESS_THAN_20[number / 100] + HUNDRED + ((number % 100 != 0) ? AND : EMPTY_STRING) + word;
	}

}
