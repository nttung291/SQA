/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Customer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author habui
 */
public class CancelContractFrameIT {
    
    public CancelContractFrameIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCustomer method, of class CancelContractFrame.
     */
    @Test
    public void testSetCustomer() {
        ;
    }

    /**
     * Test of getCustomer method, of class CancelContractFrame.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        CancelContractFrame instance = new CancelContractFrame();
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initData method, of class CancelContractFrame.
     */
    @Test
    public void testInitData() {
        System.out.println("initData");
        Customer cus = null;
        CancelContractFrame instance = new CancelContractFrame();
        instance.initData(cus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescriptions method, of class CancelContractFrame.
     */
    @Test
    public void testGetDescriptions() {
        System.out.println("getDescriptions");
        CancelContractFrame instance = new CancelContractFrame();
        String expResult = "";
        String result = instance.getDescriptions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
