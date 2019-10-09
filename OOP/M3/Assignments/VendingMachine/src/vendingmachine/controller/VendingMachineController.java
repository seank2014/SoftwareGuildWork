/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;
import vendingmachine.service.VendingMachineInsufficientFundsException;
import vendingmachine.service.VendingMachineInvalidEntryException;
import vendingmachine.service.VendingMachineItemOutOfStockException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author seanking
 */
public class VendingMachineController {

    private VendingMachineServiceLayer service;
    private VendingMachineView view;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws VendingMachineInvalidEntryException{
        boolean keepGoing = true;
        int menuSelection = 0;
      try {
            while (keepGoing) {

                menuSelection = getMenuSelection();
                
                switch(menuSelection){
                    case 1:
                        selectItem();
                        break;
                    case 2:
                        keepGoing = false;
                        break;
                    default:
                         unknownCommand();   
                }
            }
            
            exitMessage();
                } catch (VendingMachinePersistenceException | VendingMachineItemOutOfStockException | VendingMachineInsufficientFundsException|VendingMachineInvalidEntryException e) {
           view.displayErrorMessage(e.getMessage());
        }

  }

    private int getMenuSelection() throws VendingMachinePersistenceException {
        try{
        showSelection();
        return view.MainMenu();
        }catch(NumberFormatException e){
            e.getMessage();
            return 0;
        }
    }
    
    private void showSelection() throws VendingMachinePersistenceException{
        List<Item> itemList = service.getAllItems();
        view.showSelection(itemList);
        
    }
    
    private void selectItem() throws VendingMachinePersistenceException, VendingMachineItemOutOfStockException,
        VendingMachineInsufficientFundsException, VendingMachineInvalidEntryException{   
         try{  
        BigDecimal input = view.GetMoney();
        service.depositMoney(input);
        List<Item> itemList = service.getAllItems();
        int anotherInput = view.printItemMenuAndGetSelection(itemList);
       Change returnChange = service.purchaseItem(anotherInput, input);
      view.showChange(returnChange);  
         }catch(NumberFormatException e){
             view.displayErrorMessage(e.getMessage());
             
         }
             
    }
    
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
