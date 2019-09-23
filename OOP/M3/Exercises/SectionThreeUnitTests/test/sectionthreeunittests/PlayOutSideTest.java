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
public class PlayOutSideTest {

    PlayOutSide play = new PlayOutSide();

    public PlayOutSideTest() {
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
     * Test of playOutside method, of class PlayOutSide.
     */
    @Test
    public void testPlayOutside1() {
        boolean expected = true;
        boolean play1 = play.playOutside(70, false);
        
        assertEquals(expected, play1);
    }

    @Test
    public void testPlayOutside2() {
        boolean expects = false;
        boolean play2 = play.playOutside(95, false);
        
        assertEquals(expects, play2);
    }

    @Test
    public void testPlayOutside3() {
        boolean expect = true;
        boolean play3 = play.playOutside(95, true);
        
        assertEquals(expect, play3);
         
    }

    @Test
    public void testPlayOutside4() {
        boolean newExpect = false;
        boolean play4 = play.playOutside(59, true);
        
        assertEquals(newExpect, play4);
    }

}
