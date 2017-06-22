/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.FoodItem;
import entities.Orden;
import java.util.List;
import java.util.Map;
import javax.faces.event.ActionEvent;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class OrdenControllerTest extends TestCase {
    
    public OrdenControllerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OrdenControllerTest.class);
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
     * Test of getOpcion method, of class OrdenController.
     */
    public void testGetOpcion() {
        System.out.println("getOpcion");
        OrdenController instance = new OrdenController();
        instance.setOpcion("no");
        String expResult = "no";
        String result = instance.getOpcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setOpcion method, of class OrdenController.
     */
    public void testSetOpcion() {
        System.out.println("setOpcion");
        String opcion = "si";
        OrdenController instance = new OrdenController();
        instance.setOpcion(opcion);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getOpcion().equals(opcion)) {
            fail("The test case is a prototype.");    
        }
    }

    /**
     * Test of getBloque method, of class OrdenController.
     */
    public void testGetBloque() {
        System.out.println("getBloque");
        OrdenController instance = new OrdenController();
        instance.setBloque("2");
        String expResult = "2";
        String result = instance.getBloque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)||Integer.parseInt(result)%1!=0) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setBloque method, of class OrdenController.
     */
    public void testSetBloque() {
        System.out.println("setBloque");
        String bloque = "2";
        OrdenController instance = new OrdenController();
        instance.setBloque(bloque);
        // TODO review the generated test code and remove the default call to fail.
        if (Integer.parseInt(instance.getBloque())%1!=0) {
            fail("The test case is a prototype.");
        }
    }



    /**
     * Test of setIdCliente method, of class OrdenController.
     */
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        String idCliente = "1";
        OrdenController instance = new OrdenController();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        if (Integer.parseInt(instance.getIdCliente())%1!=0) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getIdCliente method, of class OrdenController.
     */
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        OrdenController instance = new OrdenController();
        instance.setIdCliente("1");
        String expResult = "1";
        String result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }


    /**
     * Test of getBloques method, of class OrdenController.
     */
    public void testGetBloques() {
       System.out.println("getBloque");
        OrdenController instance = new OrdenController();
        instance.setBloque("2");
        String expResult = "2";
        String result = instance.getBloque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)||Integer.parseInt(result)%1!=0) {
            fail("The test case is a prototype.");
        }
    }




    /**
     * Test of getPrecioEntrega method, of class OrdenController.
     */
    public void testGetPrecioEntrega() {
        System.out.println("getPrecioEntrega");
        OrdenController instance = new OrdenController();
        float expResult = 2500;
        float result = instance.getPrecioEntrega();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPrecioEntrega method, of class OrdenController.
     */
    public void testSetPrecioEntrega() {
        System.out.println("getPrecioComida");
        OrdenController instance = new OrdenController();
        Integer expResult = 2000;
        instance.setPrecioComida(expResult);
        Integer result = instance.getPrecioComida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDireccionEntrega method, of class OrdenController.
     */
    public void testGetDireccionEntrega() {
        System.out.println("getDireccionEntrega");
        OrdenController instance = new OrdenController();
        instance.setDireccionEntrega("mikasa 1234 distrito trost");
        String expResult = "mikasa 1234 distrito trost";
        String result = instance.getDireccionEntrega();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setDireccionEntrega method, of class OrdenController.
     */
    public void testSetDireccionEntrega() {
        System.out.println("setDireccionEntrega");
        String nuevaDireccion = "mikasa 1234 distrito trost";
        OrdenController instance = new OrdenController();
        instance.setDireccionEntrega(nuevaDireccion);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getDireccionEntrega().equals("mikasa 1234 distrito trost")) {
            fail("The test case is a prototype.");
        }
    }


    /**
     * Test of getPropina method, of class OrdenController.
     */
    public void testGetPropina() {
        System.out.println("getPropina");
        OrdenController instance = new OrdenController();
        instance.setPropina(1200);
        Integer expResult = 1200;
        Integer result = instance.getPropina();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPropina method, of class OrdenController.
     */
    public void testSetPropina() {
        System.out.println("setPropina");
        Integer nuevaPropina = 100;
        OrdenController instance = new OrdenController();
        instance.setPropina(nuevaPropina);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getPropina()%1!=0) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPrecioComida method, of class OrdenController.
     */
    public void testGetPrecioComida() {
        System.out.println("getPrecioComida");
        OrdenController instance = new OrdenController();
        Integer expResult = 2000;
        instance.setPrecioComida(expResult);
        Integer result = instance.getPrecioComida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPrecioComida method, of class OrdenController.
     */
    public void testSetPrecioComida() {
        System.out.println("setPrecioComida");
        Integer masPrecio = 100;
        OrdenController instance = new OrdenController();
        instance.setPrecioComida(masPrecio);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getPrecioComida()%1!=0) {
            fail("The test case is a prototype.");
        }
    }
    
        public void testCreateFoodItemSeleccionada() {
        System.out.println("createFoodItemSeleccionada");
        List<List<String>> foodSeleccionada = null;
        OrdenController instance = new OrdenController();
        List<FoodItem> expResult = null;
        List<FoodItem> result = instance.createFoodItemSeleccionada(foodSeleccionada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } 

}
