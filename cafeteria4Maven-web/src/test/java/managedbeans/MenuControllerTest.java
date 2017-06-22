/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Menu;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class MenuControllerTest extends TestCase {
    
    public MenuControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(MenuControllerTest.class);
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
     * Test of isBotonComprar method, of class MenuController.
     */
    public void testIsBotonComprar() {
        System.out.println("isBotonComprar");
        MenuController instance = new MenuController();
        instance.setBotonComprar(false);
        boolean expResult = false;
        boolean result = instance.isBotonComprar();
        assertEquals(expResult, result);
        if (instance.isBotonComprar()!=false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setBotonComprar method, of class MenuController.
     */
    public void testSetBotonComprar() {
        System.out.println("setBotonComprar");
        boolean botonComprar = true;
        MenuController instance = new MenuController();
        instance.setBotonComprar(botonComprar);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.isBotonComprar() != true) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getSeleccionado method, of class MenuController.
     */
    public void testGetSeleccionado() {
        System.out.println("getSeleccionado");
        MenuController instance = new MenuController();
        List<String> prueba=new ArrayList<String>();
        prueba.add("1");
        prueba.add("porotos");
        prueba.add("1200");
        prueba.add("23");
        prueba.add("0");
        instance.setSeleccionado(prueba);
        List<String> expResult = prueba;
        List<String> result = instance.getSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");   
        }
    }

    /**
     * Test of setSeleccionado method, of class MenuController.
     */
    public void testSetSeleccionado() {
        System.out.println("setSeleccionado");
        List<String> seleccionado = new ArrayList<String>();
        seleccionado.add("1");
        seleccionado.add("porotos");
        seleccionado.add("1200");
        seleccionado.add("23");
        seleccionado.add("0");
        MenuController instance = new MenuController();
        instance.setSeleccionado(seleccionado);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getSeleccionado().size()!=5){
            fail("The test case is a prototype.");
        }
    }

   
    
}
