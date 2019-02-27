package me.ianhe.junit;

import junit.framework.TestCase;

/**
 * @author iHelin
 * @since 2017-02-04 17:34
 */
public class JavaTest extends TestCase {

    protected int value1, value2;

    // assigning the values
    protected void setUp() {
        value1 = 3;
        value2 = 3;
    }

    // test method to add two values
    public void testAdd() {
        int result = value1 + value2;
        assertEquals(6, result);
    }

    public void testHello() {
        System.out.println("1345");
    }

}
