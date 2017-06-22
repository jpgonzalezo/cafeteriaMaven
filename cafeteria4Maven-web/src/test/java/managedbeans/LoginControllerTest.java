/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class LoginControllerTest extends TestCase {
    
    public LoginControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(LoginControllerTest.class);
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
     * Test of getEmail method, of class LoginController.
     */
    public void testGetEmail() {
        System.out.println("getEmail");
        LoginController instance = new LoginController();
        String expResult = new String();
        instance.setEmail("jose@gmail.com");
        expResult="jose@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");    
        }
    }

    /**
     * Test of setEmail method, of class LoginController.
     */
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "jose@gmail.com";
        LoginController instance = new LoginController();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getEmail().equals(email)) {
        fail("The test case is a prototype.");    
        }
    }

    /**
     * Test of getPassword method, of class LoginController.
     */
    public void testGetPassword() {
        System.out.println("getPassword");
        LoginController instance = new LoginController();
        String expResult = "1234";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPassword method, of class LoginController.
     */
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "45667";
        LoginController instance = new LoginController();
        instance.setPassword("1234");
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getPassword().equals(password)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getRedireccion method, of class LoginController.
     */
    public void testGetRedireccion() {
        System.out.println("getRedireccion");
        LoginController instance = new LoginController();
        String expResult = "/menu";
        instance.setRedireccion(expResult);
        String result = instance.getRedireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }



    /**
     * Test of getClienteIdLogin method, of class LoginController.
     */
    public void testGetClienteIdLogin() {
        System.out.println("getClienteIdLogin");
        LoginController instance = new LoginController();
        //String expResult="";
        instance.setClienteIdLogin("1");
        String expResult="1";
        String result = instance.getClienteIdLogin();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");    
        }
    }

    /**
     * Test of loginValidacion method, of class LoginController.
     */
    public void testLoginValidacion() {
        System.out.println("setClienteIdLogin");
        String id = "3";
        LoginController instance = new LoginController();
        instance.setClienteIdLogin(id);
        // TODO review the generated test code and remove the default call to fail.
        if (Integer.parseInt(instance.getClienteIdLogin())%1!=0) {
            fail("The test case is a prototype.");
        }
    }
    
}
