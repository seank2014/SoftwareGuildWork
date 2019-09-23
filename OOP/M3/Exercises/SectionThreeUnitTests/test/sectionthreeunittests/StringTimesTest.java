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
public class StringTimesTest {
    
    StringTimes time = new StringTimes();
    
    public StringTimesTest() {
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
     * Test of stringTimes method, of class StringTimes.
     */
    @Test
    public void testTwoStringTimes() {
        String expectedResult = "HiHi";
        
        String twoTimes = time.stringTimes("Hi", 2);
        
        assertEquals(expectedResult,twoTimes);     
    }
    
    @Test
    public void testThreeStringTimes() {
        String expectedResult = "HiHiHi";
        
        String threeTimes = time.stringTimes("Hi", 3);
        
        assertEquals(expectedResult,threeTimes);     
        
    }
    
    @Test
    public void testOneStringTimes() {
        String expectedResult = "Hi";
        
        String oneTimes = time.stringTimes("Hi", 1);
        
        assertEquals(expectedResult,oneTimes);     
        
    }
    
      @Test
    public void testanotherStringTimes() {
        String expectedResul2t = "HiHi";
        
        String twoTimes = time.stringTimes("Hi", 4);
        
        assertNotEquals(expectedResul2t,twoTimes);     
    }
    
}
