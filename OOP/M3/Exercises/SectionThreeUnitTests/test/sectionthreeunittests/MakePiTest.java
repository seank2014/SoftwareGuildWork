/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sectionthreeunittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seanking
 */
public class MakePiTest {
    
    MakePi seePi = new MakePi();
    
    public MakePiTest() {
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
     * Test of makePi method, of class MakePi.
     */
    @Test
    public void testMakePi3() { 
        int[] expected = {3,1,4};
        
        int[] pi = seePi.makePi(3);
        Assert.assertArrayEquals(expected, pi);
    }
    
    @Test
    public void testMakePi16() {
        int[] expects = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3};
        
        int[] anotherPi = seePi.makePi(16);
        Assert.assertArrayEquals(expects, anotherPi);
    }
    
     @Test
    public void testMakePi7() {
        int[] expect = {3,1,4,1,5,9,2};
        
        int[] aPi = seePi.makePi(7);
        Assert.assertArrayEquals(expect, aPi);
    }
    
}
