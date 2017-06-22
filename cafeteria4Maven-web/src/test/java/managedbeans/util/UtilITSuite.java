/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.util;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Juan Pablo
 */
public class UtilITSuite extends TestCase {
    
    public UtilITSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("UtilITSuite");
        suite.addTest(JsfUtilIT.suite());
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
    
}
