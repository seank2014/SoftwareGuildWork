/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Order;
import com.sg.flooring.service.InvalidDataException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class OrderDAOProdFileImpl implements OrderDAO {

    private final TaxDAO tDao;
    private final ProductDAO pDao;

    public OrderDAOProdFileImpl(TaxDAO tDao, ProductDAO pDao) {
        this.pDao = pDao;
        this.tDao = tDao;
  

    }

   
    /*Writing Map that will create list of Order objects 
    also telling program to save order information to a file and 
    assigning file name. */
    private Map< String, Order> orders = new HashMap<>();
    public static final String ORDER_FILE = "Orders_" + LocalDate.now().format(DateTimeFormatter.ofPattern("MMddYYYY")) + ".txt";
    public static final String DELIMITER = ",";

    //Method to create Order
    @Override
    public Order createOrder(String orderNumber, Order order) throws FlooringPersistenceException
          {
        Order newOrder = orders.put(orderNumber, order);
        writeOrder();
        return newOrder;

    }

    //Method to get specific order 
    @Override
    public Order getOrderByNumber(String orderNumber, LocalDate orderDate)
            throws FlooringPersistenceException {
        loadOrder();
        return orders.get(orderNumber);

    }

    //Method to get all orders through a list
    @Override
    public List<Order> getAllOrders()
            throws FlooringPersistenceException {
        loadOrder();
        return new ArrayList<>(orders.values());//returns order objects
    }

    //Method to edit an order
    @Override
    public Order updateOrder(LocalDate orderDate, String orderNumber, Order updatedOrder)
            throws FlooringPersistenceException {
        orders.put(orderNumber, updatedOrder);
        writeOrder();
        return updatedOrder;
    }

    //Method to delete an Order
    @Override
    public Order deleteOrder(String orderNumber, LocalDate orderDate)
            throws FlooringPersistenceException {
        Order removedOrder = orders.remove(orderNumber);
        writeOrder();
        return removedOrder;

    }

    //Method that read an order from a file
    private void loadOrder() throws FlooringPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDER_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load library data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);
            
            Order currentOrder = new Order(currentTokens[0], LocalDate.now());
            
             currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setState((currentTokens[2]));
            currentOrder.setTaxRate(new BigDecimal(currentTokens[3]));
            currentOrder.setProductType((currentTokens[4]));
            currentOrder.setArea(new BigDecimal(currentTokens[5]));
            currentOrder.setCostPerSquareFoot(new BigDecimal(currentTokens[6]));
            currentOrder.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[7]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
            currentOrder.setTotalTax(new BigDecimal(currentTokens[10]));
            currentOrder.setTotal(new BigDecimal(currentTokens[11]));
            
            //Make another class called "Order mapper" method toOrder(){ returns currentOrder(that information was parsed into)}
            //test will show if order is returned and if it has what I expect to be there
            //line 79 - 90 goes in class then, call that method here
            orders.put(currentOrder.getOrderNumber(), currentOrder);

        }
        scanner.close();
    }

    //Method that write order's values to a file
    public void writeOrder() throws FlooringPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ORDER_FILE));
        } catch (Exception e) {
            throw new FlooringPersistenceException(
                    "Could not save inventory data.", e);
        }

        List<Order> orderList = this.getAllOrders();

        for (Order currentOrder : orderList) {
            // write the Student object to the file
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getState() + DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSquareFoot() + DELIMITER
                    + currentOrder.getLaborCostPerSquareFoot() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTotalTax() + DELIMITER
                    + currentOrder.getTotal()
            //everything inside print line put in mapper class in another method
            //also create test file for Mapper

            );
            // force PrintWriter to write line to the file
            out.flush();
        }
        //Clean up
        out.close();
    }

}
