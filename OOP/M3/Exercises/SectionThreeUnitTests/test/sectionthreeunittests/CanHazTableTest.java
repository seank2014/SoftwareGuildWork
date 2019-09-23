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
public class CanHazTableTest {
    
    CanHazTable table = new CanHazTable();
    
    public CanHazTableTest() {
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
     * Test of canHazTable method, of class CanHazTable.
     */
    @Test
    public void testCanHaz2Table() {
        int expects = 2;
        int two = table.canHazTable(5, 10);
        
        assertEquals(expects, two);
    }
    
     @Test
    public void testCanHaz0Table() {
        int expected = 0;
        int zero = table.canHazTable(5, 2);
        
        assertEquals(expected, zero);
    }
    
     @Test
    public void testCanHaz1Table() {
        int expect = 1;
        int one = table.canHazTable(5, 5);
        
        assertEquals(expect, one);
    }
    
}
