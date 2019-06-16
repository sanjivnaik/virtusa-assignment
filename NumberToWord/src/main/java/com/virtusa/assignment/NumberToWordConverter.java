package com.virtusa.assignment;

import javax.annotation.Nonnull;

/**
 * Class which converts numbers with the range [-999999999, 999999999] to "British English Words" 
 * 
 * @author Sanjiv Naik
 *
 */
public class NumberToWordConverter {
	private static final String MINUS = "minus ";
	public static final String ZERO = "zero";
	
	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);		
		NumberToWordConverter converter = new NumberToWordConverter();
		System.out.println(converter.converToWord(number));		
	}
	
	/**
	 * Converts from number to word
	 * 
	 * @param number - number to convert to word
	 * @return converted word - never null
	 */
	@Nonnull
	public String converToWord(int number) {
		if (number < -999999999 || number > 999999999) {
			throw new IllegalArgumentException("Number passed is not within the range of [-999999999, 999999999]");
		}

		if (number == 0) {
			return ZERO;
		}
		
		String word = "";
		if (number < 0) {
			word = MINUS;
			number = number * -1;
		}

		Converter lessThan20Converter = new NumberLessThan20Converter();	
		Converter lessThan100Converter = new NumberLessThan100Converter(lessThan20Converter);
		Converter lessThan1000Converter = new NumberLessThan1000Converter(lessThan100Converter);
		Converter lessThan1000000Converter = new NumberLessThan1000000Converter(lessThan1000Converter);
		Converter lessThan1000000000Converter = new NumberLessThan1000000000Converter(lessThan1000000Converter);
		
		return word + lessThan1000000000Converter.convert(number);		
	}

}
