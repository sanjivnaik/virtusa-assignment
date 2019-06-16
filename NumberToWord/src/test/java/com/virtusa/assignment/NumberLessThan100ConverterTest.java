package com.virtusa.assignment;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for class NumberLessThan100Converter
 * 
 * @author Sanjiv Naik
 *
 */
public class NumberLessThan100ConverterTest extends EasyMockSupport {
	
	@TestSubject
    private NumberLessThan100Converter toTest;
	
	@Mock
	Converter chain;
	
	@Before
    public void setUp() throws Exception {
		chain = createMock(Converter.class);
		toTest = new NumberLessThan100Converter(chain);
		
		expect(chain.convert(7)).andStubReturn("seven");
		expect(chain.convert(0)).andStubReturn("");
	}
	
	@After
    public void tearDown() throws Exception {
        verifyAll();
    }
	
	/**
     * <b>Pre-conditions:</b><br>
     * Number passed is within the range, i.e. [0, 99]
     * <p>
     * <b>Test execution:</b><br>
     * convert()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * 0 -> ""
     * 7 -> "seven
     * 97 -> "ninety seven"
     * 80 -> "eighty"
     * 
     * @author: Sanjiv Naik
     */
    @Test
    public void testConvert_HappyDay() throws Exception {
    	replayAll();    	
    	
    	assertEquals("", toTest.convert(0));
    	assertEquals("seven", toTest.convert(7));
    	assertEquals("ninety seven", toTest.convert(97));
    	assertEquals("eighty", toTest.convert(80));
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is less then the applicable range of [0, 99]
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
    	replayAll();
    	
    	toTest.convert(-1);
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is greater then the applicable range of [0, 99]
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
    	replayAll();
    	
    	toTest.convert(100);
    }

}
