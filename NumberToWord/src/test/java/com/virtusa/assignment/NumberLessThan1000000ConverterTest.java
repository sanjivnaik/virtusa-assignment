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
 * Unit test for class NumberLessThan1000000Converter
 * 
 * @author Sanjiv Naik
 *
 */
public class NumberLessThan1000000ConverterTest extends EasyMockSupport {
	
	@TestSubject
    private NumberLessThan1000000Converter toTest;
	
	@Mock
	Converter chain;
	
	@Before
    public void setUp() throws Exception {
		chain = createMock(Converter.class);
		toTest = new NumberLessThan1000000Converter(chain);
		
		expect(chain.convert(0)).andStubReturn("");
		expect(chain.convert(1)).andStubReturn("one");
		expect(chain.convert(99)).andStubReturn("ninety nine");
		expect(chain.convert(990)).andStubReturn("nine hundred and ninety");
		expect(chain.convert(359)).andStubReturn("three hundred and fifty nine");
		expect(chain.convert(999)).andStubReturn("nine hundred and ninety nine");
	}
	
	@After
    public void tearDown() throws Exception {
        verifyAll();
    }
	
	/**
     * <b>Pre-conditions:</b><br>
     * Number passed is within the range, i.e. [0, 999999]
     * <p>
     * <b>Test execution:</b><br>
     * convert()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * 0 -> ""
     * 1359 -> "one thousand three hundred and fifty nine"
     * 99000 -> "ninety nine thousand"
     * 990000 -> "nine hundred and ninety thousand"
     * 999999 -> "nine hundred and ninety nine thousand nine hundred and ninety nine"
     * 
     * @author: Sanjiv Naik
     */
    @Test
    public void testConvert_HappyDay() throws Exception {
    	replayAll();    	
    	
    	assertEquals("", toTest.convert(0));
    	assertEquals("one thousand three hundred and fifty nine", toTest.convert(1359));
    	assertEquals("ninety nine thousand", toTest.convert(99000));
    	assertEquals("nine hundred and ninety thousand", toTest.convert(990000));
    	assertEquals("nine hundred and ninety nine thousand nine hundred and ninety nine", toTest.convert(999999));
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is less then the applicable range of [0, 999999]
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
     * Number passed is greater then the applicable range of [0, 999999]
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
    	
    	toTest.convert(1000000);
    }

}
