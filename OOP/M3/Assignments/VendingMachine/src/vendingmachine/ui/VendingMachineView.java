/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public class VendingMachineView {
    
    private UserIO io;
    
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    
     public int MainMenu(){
        io.print("Welcome! Please see the items we have available above  \n");
        io.print("1. Make a selection");
        io.print("2. Exit");
        
        return io.readInt("Please enter the number of the choices available", 1, 2);
        
    }
     
       public BigDecimal GetMoney(){
                     
           return io.readBigDecimal("Please enter Money to purchase an item");  

                    
     } 
    

       public int printItemMenuAndGetSelection(List<Item>itemList){
           for(Item item : itemList){
               if(item.getQty() > 0){
                   io.print(item.getItemId() + ". " + item.getName() + "-" + item.getPrice());
               }else {
                   io.print(item.getItemId() + ". SOLDOUT" );
               }
           }
           
           return io.readInt("Please select numbered Item you would like ", 1, 6);
           
       }
    
      public void showSelection(List<Item> itemList){
          
        for(Item currentItem : itemList){
            if(currentItem.getQty() > 0){
            io.print( currentItem.getName() + " - " +  currentItem.getPrice());
            }
        }
        io.print("");
    }
      
      public void showChange(Change change){
          io.print("Thank you! Please take your change");
          io.print(change.getQuarter() + " Quarters");
          io.print(change.getDime() + " Dimes");
          io.print(change.getNickel() + " Nickels");
          io.print(change.getPennies() + " Pennies");
          
          io.readString("Press enter to return to main menu");

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
