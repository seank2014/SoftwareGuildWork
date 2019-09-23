/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sectionthreeunittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seanking
 */
public class CountXXTest {
    
    CountXX twoX = new CountXX();
    
    public CountXXTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countXX method, of class CountXXX.
     */
    @Test
    public void testCount1() {
        int expected = 1;
        int first = twoX.countXX("abcxx");
        
        assertEquals(expected, first);
    }
    
     @Test
    public void testCount2() {
        int expects = 2;
        int second = twoX.countXX("xxx");
        
        assertEquals(expects, second);
    }
    
     @Test
    public void testCount3() {
        int expect = 3;
        int three = twoX.countXX("xxxx");
        
        assertEquals(expect, three);
    }
    
}
