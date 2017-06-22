/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.util;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class JsfUtilIT extends TestCase {
    
    public JsfUtilIT(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(JsfUtilIT.class);
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
     * Test of getSelectItems method, of class JsfUtil.
     */
    public void testGetSelectItems() {
        System.out.println("getSelectItems");
        List entities = null;
        boolean selectOne = false;
        SelectItem[] expResult = null;
        SelectItem[] result = JsfUtil.getSelectItems(entities, selectOne);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidationFailed method, of class JsfUtil.
     */
    public void testIsValidationFailed() {
        System.out.println("isValidationFailed");
        boolean expResult = false;
        boolean result = JsfUtil.isValidationFailed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addErrorMessage method, of class JsfUtil.
     */
    public void testAddErrorMessage_Exception_String() {
        System.out.println("addErrorMessage");
        Exception ex = null;
        String defaultMsg = "";
        JsfUtil.addErrorMessage(ex, defaultMsg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addErrorMessages method, of class JsfUtil.
     */
    public void testAddErrorMessages() {
        System.out.println("addErrorMessages");
        List<String> messages = null;
        JsfUtil.addErrorMessages(messages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addErrorMessage method, of class JsfUtil.
     */
    public void testAddErrorMessage_String() {
        System.out.println("addErrorMessage");
        String msg = "";
        JsfUtil.addErrorMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSuccessMessage method, of class JsfUtil.
     */
    public void testAddSuccessMessage() {
        System.out.println("addSuccessMessage");
        String msg = "";
        JsfUtil.addSuccessMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestParameter method, of class JsfUtil.
     */
    public void testGetRequestParameter() {
        System.out.println("getRequestParameter");
        String key = "";
        String expResult = "";
        String result = JsfUtil.getRequestParameter(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjectFromRequestParameter method, of class JsfUtil.
     */
    public void testGetObjectFromRequestParameter() {
        System.out.println("getObjectFromRequestParameter");
        String requestParameterName = "";
        Converter converter = null;
        UIComponent component = null;
        Object expResult = null;
        Object result = JsfUtil.getObjectFromRequestParameter(requestParameterName, converter, component);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
