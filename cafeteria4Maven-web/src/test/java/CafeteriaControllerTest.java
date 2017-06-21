/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import managedbeans.*;
import entities.Cafeteria;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Juan Pablo
 */
public class CafeteriaControllerTest extends TestCase {
    
    public CafeteriaControllerTest(String testName) {
        super(testName);
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
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }

  

    /**
     * Test of create method, of class CafeteriaController.
     */
    public void testCreate() {
        System.out.println("create");
        CafeteriaController instance = new CafeteriaController();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CafeteriaController.
     */
    public void testUpdate() {
        System.out.println("update");
        CafeteriaController instance = new CafeteriaController();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class CafeteriaController.
     */
    public void testDestroy() {
        System.out.println("destroy");
        CafeteriaController instance = new CafeteriaController();
        instance.destroy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class CafeteriaController.
     */
    public void testGetItems() {
        System.out.println("getItems");
        CafeteriaController instance = new CafeteriaController();
        List<Cafeteria> expResult = null;
        List<Cafeteria> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCafeteria method, of class CafeteriaController.
     */
    public void testGetCafeteria() {
        System.out.println("getCafeteria");
        Integer id = null;
        CafeteriaController instance = new CafeteriaController();
        Cafeteria expResult = null;
        Cafeteria result = instance.getCafeteria(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsAvailableSelectMany method, of class CafeteriaController.
     */
    public void testGetItemsAvailableSelectMany() {
        System.out.println("getItemsAvailableSelectMany");
        CafeteriaController instance = new CafeteriaController();
        List<Cafeteria> expResult = null;
        List<Cafeteria> result = instance.getItemsAvailableSelectMany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsAvailableSelectOne method, of class CafeteriaController.
     */
    public void testGetItemsAvailableSelectOne() {
        System.out.println("getItemsAvailableSelectOne");
        CafeteriaController instance = new CafeteriaController();
        List<Cafeteria> expResult = null;
        List<Cafeteria> result = instance.getItemsAvailableSelectOne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
