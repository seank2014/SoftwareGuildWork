/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;


import com.sg.flooring.dao.FlooringAuditDao;
import com.sg.flooring.dao.FlooringAuditFileImpl;
import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dao.OrderDAO;
import com.sg.flooring.dao.OrderDAOStubImpl;
import com.sg.flooring.dao.ProductDAO;
import com.sg.flooring.dao.ProductDAOFileImpl;
import com.sg.flooring.dao.TaxDAO;
import com.sg.flooring.dao.TaxDAOFIleImpl;
import com.sg.flooring.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author seanking
 */
public class ServiceLayerTest {
    
    private ServiceLayer service;
    
    
    public ServiceLayerTest() {
      OrderDAO Dao = new OrderDAOStubImpl();
      FlooringAuditDao auditDAO = new FlooringAuditFileImpl();
      ProductDAO product = new ProductDAOFileImpl();
      TaxDAO taxDao = new TaxDAOFIleImpl();
//      
      service = new ServiceLayerImpl(auditDAO, Dao, product, taxDao);
      
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
     * Test of createOrder method, of class ServiceLayer.
     * @throws com.sg.flooring.service.InvalidDataException
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     * @throws java.lang.Exception
     */
//    @Test
//    public void testCreateOrder() throws Exception {
//        Order order = new Order("1",LocalDate.now());
//        order.setCustomerName("Corporation");
//        order.setState("OH");
//        order.setTaxRate(new BigDecimal("6.25"));
//        order.setProductType("Carpet");
//        order.setArea(new BigDecimal("100"));
//        order.setCostPerSquareFoot(new BigDecimal("2.25"));
//        order.setLaborCost(new BigDecimal("2.10"));
//        order.setMaterialCost(new BigDecimal("100"));
//        order.setTotalTax(new BigDecimal("50"));
//        order.setTotal(new BigDecimal("300"));
//        
//      service.createOrder(order);
//    }
//    
    
    /**
     * Test of getAllOrders method, of class ServiceLayer.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        
        assertEquals(1, service.getAllOrders().size());
    }

    /**
     * Test of calcualteTotal method, of class ServiceLayer.
     */
    @Test
    public void testCalcualteTotal() {
    }

    /**
     * Test of findOrder method, of class ServiceLayer.
     */
    @Test
    public void testFindOrder() {
    }

    /**
     * Test of saveCurrentWork method, of class ServiceLayer.
     */
    @Test
    public void testSaveCurrentWork() {
    }

    /**
     * Test of updateOrder method, of class ServiceLayer.
     */
    @Test
    public void testUpdateOrder() {
    }

    /**
     * Test of deleteOrder method, of class ServiceLayer.
     */
    @Test
    public void testDeleteOrder() throws Exception {
        Order order = service.deleteOrder(LocalDate.now(), "1");
        assertNotNull(order);
        order = service.deleteOrder(LocalDate.now(), "2");
        assertNull(order);
    }

  

    
    

    
}
