/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.controller;

import com.sg.vendingmachinemaven.dao.VendingMachinePersistenceException;
import com.sg.vendingmachinemaven.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinemaven.service.VendingMachineInvalidEntryException;
import com.sg.vendingmachinemaven.service.VendingMachineItemOutOfStockException;
import com.sg.vendingmachinemaven.service.VendingMachineServiceLayer;
import com.sg.vendingmachinemaven.ui.VendingMachineView;

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
