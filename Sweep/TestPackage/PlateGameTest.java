/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class PlateGameTest {
    
    public PlateGameTest() {
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
     * Test of actionPerformed method, of class PlateGame.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
    }

    /**
     * Test of ChangeValueToTime method, of class PlateGame.
     */
    @Test
    public void testChangeValueToTime() {
        System.out.println("ChangeValueToTime");
        int a = 303;
        PlateGame instance = new PlateGame(3);
        String expResult = "05:03";
        String result = instance.ChangeValueToTime(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of zeroAction method, of class PlateGame.
     */
    @Test
    public void testZeroAction() {
        System.out.println("zeroAction");
    }

    /**
     * Test of checkEnd method, of class PlateGame.
     */
    @Test
    public void testCheckEnd() {
        System.out.println("checkEnd");
//        PlateGame instance = new PlateGame();
//        instance.checkEnd();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of restart method, of class PlateGame.
     */
    @Test
    public void testRestart() {
        System.out.println("restart");
//        int end = 0;
//        PlateGame instance = new PlateGame();
//        instance.restart(end);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of newGame method, of class PlateGame.
     */
    @Test
    public void testNewGame() {
        System.out.println("newGame");
    }

    /**
     * Test of run method, of class PlateGame.
     */
    @Test
    public void testRun() {
        System.out.println("run");
    }

    /**
     * Test of mouseClicked method, of class PlateGame.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
//        MouseEvent e = null;
//        PlateGame instance = new PlateGame();
//        instance.mouseClicked(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class PlateGame.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
//        MouseEvent e = null;
//        PlateGame instance = new PlateGame();
//        instance.mousePressed(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseReleased method, of class PlateGame.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
//        MouseEvent e = null;
//        PlateGame instance = new PlateGame();
//        instance.mouseReleased(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseEntered method, of class PlateGame.
     */
    @Test
    public void testMouseEntered() {
        System.out.println("mouseEntered");
//        MouseEvent e = null;
//        PlateGame instance = new PlateGame();
//        instance.mouseEntered(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of mouseExited method, of class PlateGame.
     */
    @Test
    public void testMouseExited() {
//        System.out.println("mouseExited");
//        MouseEvent e = null;
//        PlateGame instance = new PlateGame();
//        instance.mouseExited(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
