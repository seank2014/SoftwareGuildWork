/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;

/**
 *
 * @author seanking
 */
public class VendingMachineView {
    
    private UserIO io;
    
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection(){
        
         io.print("Welcome");
            io.print("1. Exit");
            io.print("2. Snickers - $1.25");
            io.print("3. Twix - $1.25");
            io.print("4. Coke - $1.00");
            io.print("5. Ice Tea - $1.00");
 
            return promptUser().intValue();
    }

       
     public BigDecimal promptUser(){
            String input = io.readString("Please enter Money to purchase an item");
           return new BigDecimal(input);    
     } 
     
     public void ItemSelectedBanner(){
         io.print("Your item has been selected");
     }
     
     public void displayExitBanner(){
         io.print("Enjoy! Thanks for shopping!");
     }
     
     public void displayUnknownCommandBanner(){
         io.print("Please make a valid entry");
     }
     
     public void displayErrorMessage(String errorMsg){
         io.print("=== ERROR ===");
         io.print(errorMsg);
     }
}
