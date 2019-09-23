/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sectionthreeunittests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author seanking
 */
public class MischeviousChildrenTest {
    
    MischeviousChildren trouble = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
     * Test of areWeInTrouble method, of class MischeviousChildren.
     */
    @Test
    public void testAreWeInTroubleBothSmile() {
        //running test two ways
        
        boolean bothSmile = trouble.areWeInTrouble(true, true);
        assertTrue(bothSmile);
       
       assertEquals(true, bothSmile);
        
       
    }
    
    @Test
    public void testAreWeInTroubleOneSmile() {
       boolean oneSmile = trouble.areWeInTrouble(false, true);
       assertFalse(oneSmile);
       
       assertEquals(false, oneSmile);      
    }
    
    @Test
    public void testAreWeInTroubleNeitherSmile() {
        boolean neitherSmile = trouble.areWeInTrouble(false, false);
        assertTrue(neitherSmile);
        
        assertEquals(true, neitherSmile);
    }
    
}
