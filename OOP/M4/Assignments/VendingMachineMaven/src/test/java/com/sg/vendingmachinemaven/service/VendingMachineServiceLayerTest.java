/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author seanking
 */
public class VendingMachineServiceLayerTest {
    
    VendingMachineServiceLayer service;
    
    
    public VendingMachineServiceLayerTest() {
//    VendingMachineDao dao = new VendingMachineDaoStubImpl();
//    VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
//    
//    service = new VendingMachineServiceLayerImpl(dao);
//    

//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.txt");
//service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
//   

//<bean id="vendingMachineDaoStub" class="com.sg.vendingmachinemaven.dao.VendingMachineDaoStubImpl"/> 
//   <bean id="serviceLayer" class="com.sg.vendingmachinemaven.service.VendingMachineServiceLayerImpl">
   //  <constructor-arg ref="vendingMachineDaoStub">
  // </bean
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
     * Test of selectItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testSelectItem() throws Exception {
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
    }

    /**
     * Test of depositMoney method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testDepositMoney() throws Exception {
    }

    /**
     * Test of returnChange method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testReturnChange() throws Exception {
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testPurchaseItem() throws Exception {
    }

    /**
     * Test of getBalance method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetBalance() throws Exception {
    }

    /**
     * Test of deleteItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testDeleteItem() throws Exception {
    }

    
}
