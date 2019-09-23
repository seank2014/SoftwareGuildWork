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
public class FirstLastTest {
    
    FirstLast firstLast = new FirstLast();
    
    public FirstLastTest() {
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
     * Test of firstLast6 method, of class FirstLast.
     */
    @Test
    public void testFirstLast() {
        int[] numbers = {1,2,6};
        boolean expected = true;
        boolean last = firstLast.firstLast6(numbers);
        
        assertEquals(expected, last);
    }
    
    @Test
    public void testFirst() {
        int[] numbers2 = {6,1,2,3};
        boolean expect = true;
        boolean first = firstLast.firstLast6(numbers2);
        
        assertEquals(expect, first);
    }
    
    @Test
    public void testNeither() {
        int[] numbers3 = {13, 6, 1, 2, 3};
        boolean expects = false;
        boolean neither = firstLast.firstLast6(numbers3);
        
        assertEquals(expects, neither);
    }
    
}
