/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.controller;

import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dto.Order;
import com.sg.flooring.service.InvalidDataException;
import com.sg.flooring.service.OrderDoesNotExistException;
import com.sg.flooring.service.ServiceLayer;
import com.sg.flooring.ui.View;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author seanking
 */
public class FlooringController {

    private ServiceLayer service;
    private View view;

    public FlooringController(ServiceLayer service, View view) {
        this.service = service;
        this.view = view;

    }

    public void run() throws FlooringPersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        displayOrders();
                        break;
                    case 2:
                        addOrder();
                        break;
                    case 3:
                        editOrder();
                        break;
                    case 4:
                        removeOrder();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }

    }
    

    private int getMenuSelection() {
        return view.printMenuANdGetSelection();
    }

    private void displayOrders() throws FlooringPersistenceException, OrderDoesNotExistException {
        view.displayAllOrdersBanner();
        List <Order> orderList = service.getAllOrders();
        view.displayOrderList(orderList);
    }

    private void addOrder() throws FlooringPersistenceException, InvalidDataException {
        view.displayOrderCreateBanner();
        Order newOrder = view.getNewOrderInfo();
        if(view.askToCommit().equalsIgnoreCase("Y")){
                    service.createOrder(newOrder);

        } else {
            System.out.println("Order was not saved!");
        }
        
        view.displayOrderCreatedSuccessBanner();
    }

    private void editOrder() throws FlooringPersistenceException, InvalidDataException {
        view.displayOrderEditedBanner();
        String orderNumber = view.getOrderNumber();
        Order editedOrder = service.findOrder(orderNumber);
         if (editedOrder != null) {
            Order orderTwo = view.getNewOrderInfo();
            if (orderNumber != orderTwo.getOrderNumber()) {
                        LocalDate orderDate = LocalDate.now();

             service.deleteOrder(orderDate, orderNumber);
                orderNumber.equals(orderTwo.getOrderNumber());
                
                service.createOrder(orderTwo);
            } else {
                
               Order orderOne = service.updateOrder(orderNumber);
            }
            view.displayEditSuccesfulBanner();
        } else {
            System.out.println("Entry not found");
        }

    }

    private void removeOrder() throws FlooringPersistenceException {
        view.displayDeleteOrderBanner();
        String orderNumber = view.getOrderNumber();
        
        LocalDate orderDate = view.getOrderDate();

        service.deleteOrder(orderDate, orderNumber);
        
        if (orderNumber == null || orderDate == null){
            
            view.infoNotValid();
            
        } 
        
        if (orderNumber != null && orderDate != null){
            
        view.displayOrderDeletedSuccessfulBanner();
        
        }
        
        
    }


    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    

    public void exitMessage() {
        view.displayExitBanner();

    }

}
