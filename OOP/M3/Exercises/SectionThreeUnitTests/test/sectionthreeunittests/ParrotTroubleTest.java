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
public class ParrotTroubleTest {
    
    ParrotTrouble trouble = new ParrotTrouble();
    
    public ParrotTroubleTest() {
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
     * Test of parrotTrouble method, of class ParrotTrouble.
     */
    @Test
    public void testParrotTrouble1() {
        boolean expected = true;
        boolean trouble1 = trouble.parrotTrouble(true, 6);
        
        assertEquals(expected, trouble1);
    }
    
     @Test
    public void testParrotTrouble2() {
        boolean expects = false;
        boolean trouble2 = trouble.parrotTrouble(true, 7);
        
        assertEquals(expects, trouble2);
    }
    
     @Test
    public void testParrotTrouble3() {
        boolean expect = false;
        boolean trouble3 = trouble.parrotTrouble(false, 6);
        
        assertEquals(expect, trouble3);
    }
    
      @Test
    public void testParrotTrouble4() {
        boolean shouldB = true;
        boolean trouble4 = trouble.parrotTrouble(true, 21);
        
        assertEquals(shouldB, trouble4);
    }
    
}
