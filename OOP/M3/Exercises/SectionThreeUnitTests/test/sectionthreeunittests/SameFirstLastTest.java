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
public class SameFirstLastTest {
    
    SameFirstLast sameFirst = new SameFirstLast();
    
    public SameFirstLastTest() {
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
     * Test of sameFirstLast method, of class SameFirstLast.
     */
    @Test
    public void testSameFirst() {
        int[] numbers = {1, 2, 3}; 
        boolean expected = false;
        boolean first = sameFirst.sameFirstLast(numbers);
        
        assertEquals(expected, first);
    }
    
     @Test
    public void testSameFirstLast1() {
        int[] number2 = {1, 2, 3, 1};
        boolean expect = true;
        boolean bothOne = sameFirst.sameFirstLast(number2);
        
        assertEquals(expect, bothOne);
    }
    
     @Test
    public void testSameFirstLast2() {
        int[] numbers3 = {1, 2, 1};
        boolean expects = true;
        boolean bothTwo = sameFirst.sameFirstLast(numbers3);
        
        assertEquals(expects, bothTwo);
    }
    
}
