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
public class FrontTimesTest {
    
    FrontTimes front = new FrontTimes();
    
    public FrontTimesTest() {
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
     * Test of frontTimes method, of class FrontTimes.
     */
    @Test
    public void testFrontTimesChoc2() {
        String expected = "ChoCho";
        String Chocolate = front.frontTimes("Chocolate", 2);
        
        assertEquals(expected,Chocolate);
    }
    
    @Test
    public void testFrontTimesChoc3() {
        String expects = "ChoChoCho";
        String choco = front.frontTimes("Chocolate", 3);
        
        assertEquals(expects, choco);
    }
    
    @Test
    public void testFrontTimesAbc() {
        String expect = "AbcAbcAbc";
        String abc = front.frontTimes("Abc", 3);
        
        assertEquals(expect, abc);
    }
    
    
}
