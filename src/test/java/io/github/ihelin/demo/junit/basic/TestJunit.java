package io.github.ihelin.demo.junit.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author iHelin
 * @since 2017-02-04 17:26
 */
public class TestJunit {

    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }

}
