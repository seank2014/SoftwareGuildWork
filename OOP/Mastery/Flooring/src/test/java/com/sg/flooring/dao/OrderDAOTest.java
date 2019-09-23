/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import com.sg.flooring.service.InvalidDataException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author seanking
 */
public class OrderDAOTest {
    
    private ProductDAO pDao= new ProductDAOFileImpl();
    private TaxDAO tDao = new TaxDAOFIleImpl();
    private OrderDAO Dao = new OrderDAOProdFileImpl(tDao, pDao);

    public OrderDAOTest() throws Exception {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        List<Order> orderList = Dao.getAllOrders();
        for (Order order : orderList) {
            Dao.deleteOrder(order.getOrderNumber(), order.getOrderDate());

        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createOrder method, of class OrderTrainingDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCreateOrder() throws Exception {
        //Arrange 
        Order order = new Order("1", LocalDate.now());
        order.setCustomerName("weis");
        order.setState("OH");
        order.setTaxRate(new BigDecimal("6.25"));
        order.setProductType("Tile");
        order.setArea(new BigDecimal("100"));
        order.setCostPerSquareFoot(new BigDecimal("3.50"));
        order.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order.setMaterialCost(new BigDecimal("350.0"));
        order.setLaborCost(new BigDecimal("415.0"));
        order.setTotalTax(new BigDecimal("54.0"));
        order.setTotal(new BigDecimal("900"));
        
        Dao.createOrder(order.getOrderNumber(), order);
        
        //Act
        Order fromDao = Dao.getOrderByNumber(order.getOrderNumber(), LocalDate.now());

        //Assert
        assertEquals(order, fromDao);

    }


    /**
     * Test of getAllOrders method, of class OrderTrainingDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllOrders() throws Exception{
        //Arrange 
        Order order1 = new Order("1", LocalDate.now());
        order1.setCustomerName("Tom");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("6.25"));
        order1.setProductType("Tile");
        order1.setArea(new BigDecimal("100"));
        order1.setCostPerSquareFoot(new BigDecimal("3.50"));
        order1.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order1.setMaterialCost(new BigDecimal("350.0"));
        order1.setLaborCost(new BigDecimal("415.0"));
        order1.setTotalTax(new BigDecimal("54.0"));
        order1.setTotal(new BigDecimal("900"));
        
        Dao.createOrder(order1.getOrderNumber(), order1);
        
         //Act 
        Order  order2 = new Order("2", LocalDate.now());
        order2.setCustomerName("Chase");
        order2.setState("OH");
        order2.setTaxRate(new BigDecimal("6.25"));
        order2.setProductType("Tile");
        order2.setArea(new BigDecimal("100"));
        order2.setCostPerSquareFoot(new BigDecimal("3.50"));
        order2.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order2.setMaterialCost(new BigDecimal("350.0"));
        order2.setLaborCost(new BigDecimal("415.0"));
        order2.setTotalTax(new BigDecimal("54.0"));
        order2.setTotal(new BigDecimal("900"));
        
        Dao.createOrder(order2.getOrderNumber(), order2);
       
        //Assert
        
        assertEquals(2, Dao.getAllOrders().size());
    }

    /**
     * Test of updateOrder method, of class OrderTrainingDAO.
     */
    @Test
    public void testUpdateOrder() {
    }

    /**
     * Test of deleteOrder method, of class OrderTrainingDAO.
     * @throws com.sg.flooring.dao.FlooringPersistenceException
     */
    @Test
    public void testDeleteOrder() throws FlooringPersistenceException, InvalidDataException {
        //Arrange 
         Order order1 = new Order("1", LocalDate.now());
        order1.setCustomerName("weis");
        order1.setState("OH");
        order1.setTaxRate(new BigDecimal("6.25"));
        order1.setProductType("Tile");
        order1.setArea(new BigDecimal("100"));
        order1.setCostPerSquareFoot(new BigDecimal("3.50"));
        order1.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order1.setMaterialCost(new BigDecimal("350.0"));
        order1.setLaborCost(new BigDecimal("415.0"));
        order1.setTotalTax(new BigDecimal("54.0"));
        order1.setTotal(new BigDecimal("900"));
//
//        
        Dao.createOrder(order1.getOrderNumber(), order1);
        Dao.getOrderByNumber(order1.getOrderNumber(), order1.getOrderDate());
//      
        Order order2 = new Order("2", LocalDate.now());
        order2.setCustomerName("Chase");
        order2.setState("OH");
        order2.setTaxRate(new BigDecimal("6.25"));
        order2.setProductType("Tile");
        order2.setArea(new BigDecimal("100"));
        order2.setCostPerSquareFoot(new BigDecimal("3.50"));
        order2.setLaborCostPerSquareFoot(new BigDecimal("4.15"));
        order2.setMaterialCost(new BigDecimal("350.0"));
        order2.setLaborCost(new BigDecimal("415.0"));
        order2.setTotalTax(new BigDecimal("54.0"));
        order2.setTotal(new BigDecimal("900"));
//        
        Dao.createOrder(order2.getOrderNumber(), order2);
        Dao.getOrderByNumber(order2.getOrderNumber(), order2.getOrderDate());
        
         //Act
//
        Dao.deleteOrder(order1.getOrderNumber(), order1.getOrderDate());
        assertEquals(1,Dao.getAllOrders().size());
        assertNull(Dao.getOrderByNumber("1", order1.getOrderDate()));

        //Assert
//
        Dao.deleteOrder(order2.getOrderNumber(), order2.getOrderDate());
        assertEquals(0, Dao.getAllOrders().size());
        assertNull(Dao.getOrderByNumber("2", order2.getOrderDate()));  
         
        
    }

}
