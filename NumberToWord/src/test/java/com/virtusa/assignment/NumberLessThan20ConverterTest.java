package com.virtusa.assignment;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for class NumberLessThan20Converter
 * 
 * @author Sanjiv Naik
 *
 */
public class NumberLessThan20ConverterTest extends EasyMockSupport {
	
	@TestSubject
    private NumberLessThan20Converter toTest;
	
	@Before
    public void setUp() throws Exception {
		toTest = new NumberLessThan20Converter();		
	}
	
	@After
    public void tearDown() throws Exception {
        verifyAll();
    }
	
	/**
     * <b>Pre-conditions:</b><br>
     * Number passed is within the range, i.e. [0, 19]
     * <p>
     * <b>Test execution:</b><br>
     * convert()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * Should return the index value for the number passed according to the constant declared in Converter.NUM_LESS_THAN_20
     * 
     * @author: Sanjiv Naik
     */
    @Test
    public void testConvert_HappyDay() throws Exception {
    	assertEquals("", toTest.convert(0));
    	assertEquals("one", toTest.convert(1));
    	assertEquals("two", toTest.convert(2));
    	assertEquals("three", toTest.convert(3));
    	assertEquals("four", toTest.convert(4));
    	assertEquals("five", toTest.convert(5));
    	assertEquals("six", toTest.convert(6));
    	assertEquals("seven", toTest.convert(7));
    	assertEquals("eight", toTest.convert(8));
    	assertEquals("nine", toTest.convert(9));
    	assertEquals("ten", toTest.convert(10));
    	assertEquals("eleven", toTest.convert(11));
    	assertEquals("twelve", toTest.convert(12));
    	assertEquals("thirteen", toTest.convert(13));
    	assertEquals("fourteen", toTest.convert(14));
    	assertEquals("fifteen", toTest.convert(15));
    	assertEquals("sixteen", toTest.convert(16));
    	assertEquals("seventeen", toTest.convert(17));
    	assertEquals("eighteen", toTest.convert(18));
    	assertEquals("nineteen", toTest.convert(19));
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is less then the applicable range of [0, 19]
     * <p>
     * <b>Test execution:</b><br>
     * convert()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * Should throw IllegalArgumentException
     * 
     * @author: Sanjiv Naik
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvert_WhenNumIsLessThanTheRange() throws Exception {
    	toTest.convert(-1);
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is greater then the applicable range of [0, 19]
     * <p>
     * <b>Test execution:</b><br>
     * convert()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * Should throw IllegalArgumentException
     * 
     * @author: Sanjiv Naik
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvert_WhenNumIsGreaterThanTheRange() throws Exception {
    	toTest.convert(20);
    }

}
