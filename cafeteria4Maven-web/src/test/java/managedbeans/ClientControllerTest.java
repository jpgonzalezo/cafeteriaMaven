/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Client;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class ClientControllerTest extends TestCase {
    
    public ClientControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ClientControllerTest.class);
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
     * Test of getSelected method, of class ClientController.
     */
    public void testGetSelected() {
        System.out.println("getSelected");
        ClientController instance = new ClientController();
        Client expResult = null;
        Client result = instance.getSelected();
        assertEquals(expResult, result);
        if (result!=null) {
            fail("The test case is a prototype.");    
        }
    }

    /**
     * Test of setSelected method, of class ClientController.
     */
    public void testSetSelected() {
        System.out.println("setSelected");
        Client selected = null;
        ClientController instance = new ClientController();
        instance.setSelected(selected);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getSelected()!=null) {
            fail("The test case is a prototype.");
        }
    }

    
}
