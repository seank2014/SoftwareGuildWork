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
public class MakeTagsTest {
    
    MakeTags tags = new MakeTags();
    
    public MakeTagsTest() {
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
     * Test of makeTags method, of class MakeTags.
     */
    @Test
    public void testMakeYayTags() {
        String expected = "<i>Yay</i>";
        String yayTag = tags.makeTags("i", "Yay");
        
        assertEquals(expected, yayTag);
        
        
    }
    
     @Test
    public void testMakeHelloTags() {      
        String expects = "<i>Hello</i>";
        String helloTag = tags.makeTags("i", "Hello");
        
        assertEquals(expects, helloTag);
        
    }
    
     @Test
    public void testMakeYay2Tags() {
        String expect = "<cite>Yay</cite>";
        String yay2Tag = tags.makeTags("cite", "Yay");
        
        assertEquals(expect, yay2Tag);
    }
    
}
