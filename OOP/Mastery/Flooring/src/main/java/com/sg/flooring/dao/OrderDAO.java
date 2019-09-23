/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import com.sg.flooring.service.InvalidDataException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author seanking
 */
public interface OrderDAO {
//need to clarify between order prod and training
    Order createOrder(String orderNumber, Order order)
                        throws FlooringPersistenceException;

    Order getOrderByNumber(String orderNumber, LocalDate orderDate)
            throws FlooringPersistenceException;

    List<Order> getAllOrders()
            throws FlooringPersistenceException;

    Order updateOrder(LocalDate orderDate, String orderNumber, Order order)
            throws FlooringPersistenceException;

    Order deleteOrder(String orderNumber, LocalDate orderDate)
            throws FlooringPersistenceException;

}
