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
public class Diff21Test {
    
    Diff21 dif = new Diff21();
    
    public Diff21Test() {
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
     * Test of diff21 method, of class Diff21.
     */
    @Test
    public void testDiff21() {
        int expected = 4;
        int diff1 = dif.diff21(23);
        
        assertEquals(expected, diff1);
             
    }
    
    
        @Test
    public void testDiff212() {
        int expects = 11;
        int diff2 = dif.diff21(10);
        
        assertEquals(expects, diff2);
             
    }
    
      @Test
    public void testDiff213() {
        int expect = 0;
        int diff3 = dif.diff21(21);
        
        assertEquals(expect, diff3);
             
    }
    
       @Test
    public void testDiff214() {
        int expec = 24;
        int diff4 = dif.diff21(-3);
        
        assertEquals(expec, diff4);
             
    }
}
