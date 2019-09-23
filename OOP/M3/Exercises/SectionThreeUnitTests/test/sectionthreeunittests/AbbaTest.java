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
public class AbbaTest {
    
    Abba abba = new Abba();
    
    public AbbaTest() {
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
     * Test of abba method, of class Abba.
     */
    @Test
    public void testHiAbba() {
        String expected = "HiByeByeHi";
        String other = "HiHeyBye";
        String hey = abba.abba("Hi", "Bye");
        
        assertEquals(expected, hey);
        assertNotEquals(other, hey);
        
    }
    
     @Test
    public void testYoAbba() {
        String expect = "YoAliceAliceYo";
        String other = "HiHeyBye";
        String yo = abba.abba("Yo", "Alice");
        
        assertEquals(expect, yo);
        assertNotEquals(other, yo);
        
    }
    
     @Test
    public void testWhatAbba() {
        String expects = "WhatUpUpWhat";
        String other = "HiHeyBye";

        String what = abba.abba("What", "Up");
        
        assertEquals(expects, what);
        assertNotEquals(other, what);
        
        
    }
    
}
