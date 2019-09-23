/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.ui;

import com.sg.flooring.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author seanking
 */
public class View {

    private UserIO io;


    public View(UserIO io) {
        this.io = io;

    }
    
    //I need a read big decimal and local date print

    //need to make a method to ask user to pick between training and prod
    
    
     public void displayOrderCreateBanner() {
        io.print("=== Create new order ====");
    }
    public int printMenuANdGetSelection() {
        io.print("****************************************");
        io.print("* <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Quit");
        io.print("*\n*****************************************");

        return io.readInt("Please select an option", 1, 5);

    }
    

    public Order getNewOrderInfo() {
        LocalDate orderDate = LocalDate.now();
        String orderNumber = io.readString("For your convinience please enter an order number you can remember");      
        String customerName = io.readString("Please enter your company name");
        String state = io.readString("We currently serve Ohio, Pennsylvania, Minnesota or Indiana \n "
                + "please enter the initial of one of these states Ex:\n"
                + "Ohio - 'OH'\n "
                + "Pennsylvania - 'PA'\n"
                + " Minnesota - 'MI'\n"
                + " Indiana - 'IN'");
        String productType = io.readString("Please enter the type of material you would like to purchase. \n We currently have Carpet, Laminate, Tile and Wood");
        BigDecimal area = io.readBigDecimal("Please enter how much of this material you would like");
        Order currentOrder = new Order(orderNumber, orderDate);
        currentOrder.setCustomerName(customerName);  
        currentOrder.setState(state);
        currentOrder.setProductType(productType);
        currentOrder.setArea(area);
        io.print("Your order number is " + currentOrder.getOrderNumber() + " and was placed on " + currentOrder.getOrderDate().format(DateTimeFormatter.ofPattern("MMddYYY")) + "\n");
     
        return currentOrder;     
    }
    
    public String askToCommit(){
        String answer = io.readString("Do you want to commit this order Y/N? ");
        return answer;
    }


    public void displayOrderCreatedSuccessBanner() {
        io.print("New Order was created");
        //must also print out order number
    }

    public void displayOrderList(List <Order> orderList) {
        for (Order currentOrder : orderList) {
            io.print(currentOrder.getOrderDate().format(DateTimeFormatter.ofPattern("MMddYYYY")) + ": "
                    + currentOrder.getOrderNumber() + ", "
                    + currentOrder.getCustomerName() + ", "
                    + currentOrder.getState() + ", "
                    + currentOrder.getTaxRate() + ", "
                    + currentOrder.getProductType() + ", "
                    + currentOrder.getArea() + ", "
                    + currentOrder.getCostPerSquareFoot() + ", "
                    + currentOrder.getLaborCostPerSquareFoot() + ", "
                    + currentOrder.getMaterialCost() + ", "
                    + currentOrder.getLaborCost() + ", "
                    + currentOrder.getTotalTax() + ",  "
                    + currentOrder.getTotal()
            
            );
        }
        

        io.readString("Please hit enter to continue.");

    }

    public void displayAllOrdersBanner() {
        io.print("=== Display All Orders===");
    }

    public void displayOrderBanner() {
        io.print("=== Display order ===");
    }


    public void displayOrder(Order order) {
        if (order != null) {
            io.print("" + order.getOrderNumber());
            io.print(order.getCustomerName() + " " + order.getState() + " "
                    + order.getTaxRate() + " " + order.getProductType() + " "
                    + order.getArea() + " " + order.getCostPerSquareFoot() + " "
                    + order.getLaborCostPerSquareFoot() + " " + order.getMaterialCost()
                    + " " + order.getLaborCost() + " "+ order.getTotalTax() +" "+ order.getTotal());
            io.print("");
        } else {
            io.print("Sorry, we didn't find your order. Please try again.");

        }
        io.print("Please press enter to continue");

    }

    public void displayDeleteOrderBanner() {
        io.print("=== Delete Order===");
    }
    
     public String getOrderNumber() {
        return io.readString("Please enter your order number");
    }
     
   public LocalDate getOrderDate() {
        return io.readLocalDate("Please enter your order date \n Ex:YYYY-MM-DD");
    }

    public void displayOrderDeletedSuccessfulBanner() {
        io.print("=== Order has been deleted ===");
    }

    public void displayOrderEditedBanner() {

        io.print("=== Edit Order ===");

    }

    public void displayEditSuccesfulBanner() {
        io.print("Edit complete");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void infoNotValid(){
        io.print("Info not valid");
        
    }

}
