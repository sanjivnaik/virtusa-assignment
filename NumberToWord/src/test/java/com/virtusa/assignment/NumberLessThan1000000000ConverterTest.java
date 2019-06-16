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
 * Unit test for class NumberLessThan1000000000Converter
 * 
 * @author Sanjiv Naik
 *
 */
public class NumberLessThan1000000000ConverterTest extends EasyMockSupport {
	
	@TestSubject
    private NumberLessThan1000000000Converter toTest;
	
	@Mock
	Converter chain;
	
	@Before
    public void setUp() throws Exception {
		chain = createMock(Converter.class);
		toTest = new NumberLessThan1000000000Converter(chain);
		
		expect(chain.convert(0)).andStubReturn("");
		expect(chain.convert(100)).andStubReturn("one hundred");
		expect(chain.convert(123)).andStubReturn("one hundred and twenty three");
		expect(chain.convert(999)).andStubReturn("nine hundred and ninety nine");
		expect(chain.convert(456789)).andStubReturn("four hundred and fifty six thousand seven hundred and eighty nine");
		expect(chain.convert(999999)).andStubReturn("nine hundred and ninety nine thousand nine hundred and ninety nine");
	}
	
	@After
    public void tearDown() throws Exception {
        verifyAll();
    }
	
	/**
     * <b>Pre-conditions:</b><br>
     * Number passed is within the range, i.e. [0, 999999999]
     * <p>
     * <b>Test execution:</b><br>
     * convert()
     * 
     * <p>
     * <b>Expected result:</b><br>
     * 0 -> ""
     * 100000000 -> "hundred million"
     * 123456789 -> "one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine"
     * 999999999 -> "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine"
     * 
     * @author: Sanjiv Naik
     */
    @Test
    public void testConvert_HappyDay() throws Exception {
    	replayAll();    	
    	
    	assertEquals("", toTest.convert(0));
    	assertEquals("one hundred million", toTest.convert(100000000));
    	assertEquals("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine", toTest.convert(123456789));
    	assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", toTest.convert(999999999));
    }
    
    /**
     * <b>Pre-conditions:</b><br>
     * Number passed is less then the applicable range of [0, 999999999]
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
     * Number passed is greater then the applicable range of [0, 999999999]
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
    	
    	toTest.convert(1000000000);
    }

}
