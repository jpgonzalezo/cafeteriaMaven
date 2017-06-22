/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Delivery;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class DeliveryControllerTest extends TestCase {
    
    public DeliveryControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(DeliveryControllerTest.class);
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
     * Test of getSelected method, of class DeliveryController.
     */
    public void testGetSelected() {
        System.out.println("getSelected");
        DeliveryController instance = new DeliveryController();
        Delivery expResult = null;
        Delivery result = instance.getSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setSelected method, of class DeliveryController.
     */
    public void testSetSelected() {
        System.out.println("setSelected");
        Delivery selected = null;
        DeliveryController instance = new DeliveryController();
        instance.setSelected(selected);
        // TODO review the generated test code and remove the default call to fail.
                if (instance.getSelected()!=null) {
            fail("The test case is a prototype.");
        }
    }

   
    
}
