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
public class SleepingInTest {
    SleepingIn sleep = new SleepingIn();
    
    public SleepingInTest() {
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
     * Test of canSleepIn method, of class SleepingIn.
     */
    @Test
    public void testBothFlase() {
        boolean expected = true;
        boolean both = sleep.canSleepIn(false, false);
        
        assertEquals(expected, both);
    }
    
     @Test
    public void testVacationFalse() {
        boolean expects = false;
        boolean neither = sleep.canSleepIn(true, false);
        
        assertEquals(expects, neither);
    }
    
     @Test
    public void testWeekDayFalse() {
        boolean expect = true;
        boolean weekday = sleep.canSleepIn(false, true);
        
        assertEquals(expect, weekday);
    }
    
}
