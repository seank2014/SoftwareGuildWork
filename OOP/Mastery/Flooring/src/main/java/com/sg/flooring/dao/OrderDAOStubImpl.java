/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seanking
 */
public class OrderDAOStubImpl implements OrderDAO {

    Order onlyOrder;
    List<Order> orderList = new ArrayList<>();
    OrderDAO dao;

    public OrderDAOStubImpl() {
        onlyOrder = new Order("1", LocalDate.now());
        onlyOrder.setCustomerName("weis");
        onlyOrder.setState("OH");
        onlyOrder.setTaxRate(new BigDecimal("6.25"));
        onlyOrder.setProductType("Carpet");
        onlyOrder.setArea(new BigDecimal("98"));
        onlyOrder.setCostPerSquareFoot(new BigDecimal("2.25"));
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("2.10"));
        onlyOrder.setLaborCost(new BigDecimal("220.50"));
        onlyOrder.setMaterialCost(new BigDecimal("205.80"));
        onlyOrder.setTotalTax(new BigDecimal("26.64"));
        onlyOrder.setTotal(new BigDecimal("452.94"));

        orderList.add(onlyOrder);
    }

    @Override
    public Order createOrder(String orderNumber, Order order)
            throws FlooringPersistenceException {
        if (onlyOrder.equals(onlyOrder.getOrderNumber())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order getOrderByNumber(String orderNumber, LocalDate orderDate) {
        if (orderNumber.equals(onlyOrder.getOrderNumber()) && orderDate.equals(onlyOrder.getOrderDate())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public Order updateOrder(LocalDate orderDate, String orderNumber, Order updatedOrder)
            throws FlooringPersistenceException {
       if (updatedOrder.equals(dao.getOrderByNumber(orderNumber, orderDate))){
           return onlyOrder;
       }else{
           return null;
       }
        
    }

    @Override
    public Order deleteOrder(String orderNumber, LocalDate orderDate) {
        if (orderDate.equals(onlyOrder.getOrderDate()) && orderNumber.equals(onlyOrder.getOrderNumber())) {
            return onlyOrder;
        } else {
            return null;
        }

    }

    


}
