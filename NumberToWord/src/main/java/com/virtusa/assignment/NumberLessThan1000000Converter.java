package com.virtusa.assignment;

/**
 * Converts numbers with the range [0, 999999] to word
 * 
 * @author Sanjiv Naik
 *
 */
class NumberLessThan1000000Converter extends AbstractNumberToWordConverter {

	private static final String THOUSAND = " thousand";

	NumberLessThan1000000Converter(Converter chain) {
		super(chain);
	}

	@Override
	public String convert(int number) {
		if (number < 0 || number > 999999) {
			throw new IllegalArgumentException("Number passed is not within the range of [0, 999999]");
		}
		
		String word = chain.convert(number % 1000);
		if (number < 1000) {
			return word;
		}		
		return chain.convert(number / 1000) + THOUSAND + ((number % 1000 != 0) ? SPACE : EMPTY_STRING) + word;
	}

}
