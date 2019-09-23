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
public class SumDoubleTest {
    
    SumDouble sum = new SumDouble();
    
    public SumDoubleTest() {
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
     * Test of sumDouble method, of class SumDouble.
     */
    @Test
    public void testSumDouble1() {
        int expected = 3;
        int sum1 = sum.sumDouble(1, 2);
        
        assertEquals(expected, sum1);
    }
    
     @Test
    public void testSumDouble2() {
        int expects = 5;
        int sum2 = sum.sumDouble(3, 2);
        
        assertEquals(expects, sum2);
    }
    
     @Test
    public void testSumDouble3() {
        int expect = 8;
        int sum3 = sum.sumDouble(2, 2);
        
        assertEquals(expect, sum3);
    }
    
}
