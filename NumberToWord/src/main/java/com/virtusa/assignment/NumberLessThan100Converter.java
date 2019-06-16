package com.virtusa.assignment;

/**
 * Converts numbers with the range [0, 99] to word
 * 
 * @author Sanjiv Naik
 *
 */
class NumberLessThan100Converter extends AbstractNumberToWordConverter {

	NumberLessThan100Converter(Converter chain) {
		super(chain);
	}

	@Override
	public String convert(int number) {
		if (number < 0 || number > 99) {
			throw new IllegalArgumentException("Number passed is not within the range of [0, 99]");
		}
		
		if (number < 20) {
			return chain.convert(number);
		} else {
			return TENS[number / 10] + ((number % 10 != 0) ? SPACE : EMPTY_STRING) + chain.convert(number % 10);
		}
	}

}
