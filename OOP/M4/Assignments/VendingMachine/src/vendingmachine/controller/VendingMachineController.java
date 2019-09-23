/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import vendingmachine.dao.VendingMachinePersistenceException;
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

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                if (menuSelection == 1) {
                    keepGoing = false;
                } else if (menuSelection == 2 || menuSelection == 3 || menuSelection == 4 || menuSelection == 5) {
                    service.selectItem(menuSelection);
                } else {
                    unknownCommand();
                }

            }
            exitMessage();
        } catch (VendingMachinePersistenceException |VendingMachineInvalidEntryException| VendingMachineInsufficientFundsException |
            VendingMachineItemOutOfStockException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //auditDao as parameter
    //instantiantiating controller
    
    //selectitem
    //confirm item selected
    //show change amount and type of change
    //ask if they want to purchase another item
     
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
