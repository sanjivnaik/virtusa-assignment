package com.virtusa.assignment;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for class NumberToWordconverToWorder
 * 
 * @author Sanjiv Naik
 *
 */
public class NumberToWordConverterTest extends EasyMockSupport {
	
	@TestSubject
    private NumberToWordConverter toTest;
	
	@Before
    public void setUp() throws Exception {
		toTest = new NumberToWordConverter();		
	}
	
	@After
    public void tearDown() throws Exception {
        verifyAll();
    }
	
	/**
     * <b>Pre-conditions:</b><br>
     * Number passed is within the range, i.e. [-999999999, 999999999]
     * <p>
     * <b>Test execution:</b><br>
     * converToWord()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * 0 -> "zero"
     * 5 -> "five"
     * 97 -> "ninety sevel"
     * 80 -> "eighty"
     * 367 -> "three hundred and sixty seven
     * 800 -> "eight hundred"
     * 999 -> "nine hundred and ninety nine"
     * 1359 -> "one thousand three hundred and fifty nine"
     * 99000 -> "ninety nine thousand"
     * 105000 -> "one hundred and five thousand"
     * 990000 -> "nine hundred and ninety thousand"
     * 999999 -> "nine hundred and ninety nine thousand nine hundred and ninety nine"
     * -0 -> "zero"
     * -5 -> "minus five"
     * -97 -> "minus ninety sevel"
     * -80 -> "minus eighty"
     * -367 -> "minus three hundred and sixty seven
     * -800 -> "minus eight hundred"
     * -999 -> "minus nine hundred and ninety nine"
     * -1359 -> "minus one thousand three hundred and fifty nine"
     * -99000 -> "minus ninety nine thousand"
     * -105000 -> "minus one hundred and five thousand"
     * -990000 -> "minus nine hundred and ninety thousand"
     * -999999 -> "minus nine hundred and ninety nine thousand nine hundred and ninety nine"
     * 
     * @author: Sanjiv Naik
     */
	@Test
	public void testconverToWord_HappyDay() throws Exception {
		assertEquals("zero", toTest.converToWord(0));
		assertEquals("five", toTest.converToWord(5));
		assertEquals("ninety seven", toTest.converToWord(97));
		assertEquals("eighty", toTest.converToWord(80));
    	assertEquals("three hundred and sixty seven", toTest.converToWord(367));
    	assertEquals("eight hundred", toTest.converToWord(800));
    	assertEquals("nine hundred and ninety nine", toTest.converToWord(999));
    	assertEquals("one thousand three hundred and fifty nine", toTest.converToWord(1359));
    	assertEquals("ninety nine thousand", toTest.converToWord(99000));
    	assertEquals("one hundred and five thousand", toTest.converToWord(105000));
    	assertEquals("nine hundred and ninety thousand", toTest.converToWord(990000));
    	assertEquals("nine hundred and ninety nine thousand nine hundred and ninety nine", toTest.converToWord(999999));
    	assertEquals("one hundred million", toTest.converToWord(100000000));
    	assertEquals("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine", toTest.converToWord(123456789));
    	assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", toTest.converToWord(999999999));
    	assertEquals("zero", toTest.converToWord(-0));
		assertEquals("minus five", toTest.converToWord(-5));
		assertEquals("minus ninety seven", toTest.converToWord(-97));
		assertEquals("minus eighty", toTest.converToWord(-80));
    	assertEquals("minus three hundred and sixty seven", toTest.converToWord(-367));
    	assertEquals("minus eight hundred", toTest.converToWord(-800));
    	assertEquals("minus nine hundred and ninety nine", toTest.converToWord(-999));
    	assertEquals("minus one thousand three hundred and fifty nine", toTest.converToWord(-1359));
    	assertEquals("minus ninety nine thousand", toTest.converToWord(-99000));
    	assertEquals("minus one hundred and five thousand", toTest.converToWord(-105000));
    	assertEquals("minus nine hundred and ninety thousand", toTest.converToWord(-990000));
    	assertEquals("minus nine hundred and ninety nine thousand nine hundred and ninety nine", toTest.converToWord(-999999));
    	assertEquals("minus one hundred million", toTest.converToWord(-100000000));
    	assertEquals("minus one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine", toTest.converToWord(-123456789));
    	assertEquals("minus nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", toTest.converToWord(-999999999));
	}
	
	/**
     * <b>Pre-conditions:</b><br>
     * Number passed is less then the applicable range of [-999999999, 999999999]
     * <p>
     * <b>Test execution:</b><br>
     * converToWord()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * Should throw IllegalArgumentException
     * 
     * @author: Sanjiv Naik
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvert_WhenNumIsLessThanTheRange() throws Exception {
    	replayAll();
    	
    	toTest.converToWord(-1000000000);
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is greater then the applicable range of [-999999999, 999999999]
     * <p>
     * <b>Test execution:</b><br>
     * converToWord()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * Should throw IllegalArgumentException
     * 
     * @author: Sanjiv Naik
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvert_WhenNumIsGreaterThanTheRange() throws Exception {
    	replayAll();
    	
    	toTest.converToWord(1000000000);
    }

}
