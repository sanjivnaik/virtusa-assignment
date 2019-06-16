package com.virtusa.assignment;

/**
 * 
 * @author Sanjiv Naik
 *
 */
abstract class AbstractNumberToWordConverter implements Converter {
	
	Converter chain;
	
	AbstractNumberToWordConverter(Converter chain) {
		this.chain = chain;
	}

}
