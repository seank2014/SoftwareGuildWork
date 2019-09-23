/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;
import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author seanking
 */
public interface ServiceLayer {
    
    public void createOrder(Order order) throws FlooringPersistenceException, InvalidDataException;
    List<Order>getAllOrders()throws FlooringPersistenceException, OrderDoesNotExistException;
    public Order findOrder(String orderNumber)throws FlooringPersistenceException;
    public void saveCurrentWork(Order order)throws FlooringPersistenceException;
    public Order updateOrder(String orderNumber)throws FlooringPersistenceException;
    public Order deleteOrder(LocalDate orderDate, String orderNumber)throws FlooringPersistenceException;
    
    
    
}
