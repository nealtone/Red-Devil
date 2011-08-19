/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class GetBombTest {
    
    public GetBombTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reset method, of class GetBomb.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        GetBomb instance = new GetBomb();
        instance.reset();
    }

    /**
     * Test of actionPerformed method, of class GetBomb.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        GetBomb instance = new GetBomb();
    }

    /**
     * Test of choose method, of class GetBomb.
     */
    @Test
    public void testChoose() {
        System.out.println("choose");
        GetBomb instance = new GetBomb();
        int expResult = 9;
        int result = instance.choose();
        assertEquals(expResult, result);
    }

    /**
     * Test of mouseClicked method, of class GetBomb.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
    }

    /**
     * Test of mousePressed method, of class GetBomb.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
    }

    /**
     * Test of mouseReleased method, of class GetBomb.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
    }

    /**
     * Test of mouseEntered method, of class GetBomb.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
    }

    /**
     * Test of mouseExited method, of class GetBomb.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
    }
}
