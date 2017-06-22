/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Cafeteria;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class CafeteriaControllerTest extends TestCase {
    
    public CafeteriaControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(CafeteriaControllerTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getSelected method, of class CafeteriaController.
     */
    public void testGetSelected() {
        System.out.println("getSelected");
        CafeteriaController instance = new CafeteriaController();
        Cafeteria expResult = null;
        Cafeteria result = instance.getSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=null) {
            fail("The test case is a prototype.");    
        }
    }

    /**
     * Test of setSelected method, of class CafeteriaController.
     */
    public void testSetSelected() {
        System.out.println("setSelected");
        Cafeteria selected = null;
        CafeteriaController instance = new CafeteriaController();
        instance.setSelected(selected);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getSelected()!=null) {
            fail("The test case is a prototype.");
        }
    }

    
}
