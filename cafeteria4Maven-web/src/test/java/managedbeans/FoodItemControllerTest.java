/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.FoodItem;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class FoodItemControllerTest extends TestCase {
    
    public FoodItemControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(FoodItemControllerTest.class);
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
     * Test of getSelected method, of class FoodItemController.
     */
    public void testGetSelected() {
        System.out.println("getSelected");
        FoodItemController instance = new FoodItemController();
        FoodItem expResult = null;
        FoodItem result = instance.getSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
                if (result!=expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setSelected method, of class FoodItemController.
     */
    public void testSetSelected() {
        System.out.println("setSelected");
        FoodItem selected = null;
        FoodItemController instance = new FoodItemController();
        instance.setSelected(selected);
        // TODO review the generated test code and remove the default call to fail.
                       if (instance.getSelected()!=null) {
            fail("The test case is a prototype.");
        }
    }
}
