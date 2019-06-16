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
 * Unit test for class NumberLessThan1000Converter
 * 
 * @author Sanjiv Naik
 *
 */
public class NumberLessThan1000ConverterTest extends EasyMockSupport {
	
	@TestSubject
    private NumberLessThan1000Converter toTest;
	
	@Mock
	Converter chain;
	
	@Before
    public void setUp() throws Exception {
		chain = createMock(Converter.class);
		toTest = new NumberLessThan1000Converter(chain);
		
		expect(chain.convert(0)).andStubReturn("");
		expect(chain.convert(67)).andStubReturn("sixty seven");
		expect(chain.convert(99)).andStubReturn("ninety nine");
	}
	
	@After
    public void tearDown() throws Exception {
        verifyAll();
    }
	
	/**
     * <b>Pre-conditions:</b><br>
     * Number passed is within the range, i.e. [0, 999]
     * <p>
     * <b>Test execution:</b><br>
     * convert()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * 0 -> ""
     * 367 -> "three hundred and sixty seven
     * 800 -> "eight hundred"
     * 999 -> "nine hundred and ninety nine"
     * 
     * @author: Sanjiv Naik
     */
    @Test
    public void testConvert_HappyDay() throws Exception {
    	replayAll();    	
    	
    	assertEquals("", toTest.convert(0));
    	assertEquals("three hundred and sixty seven", toTest.convert(367));
    	assertEquals("eight hundred", toTest.convert(800));
    	assertEquals("nine hundred and ninety nine", toTest.convert(999));
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is less then the applicable range of [0, 999]
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
     * Number passed is greater then the applicable range of [0, 999]
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
    	
    	toTest.convert(1000);
    }

}
