/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public interface VendingMachineServiceLayer {
    
    
    Item selectItem(int itemId) throws
            VendingMachineInsufficientFundsException,
            VendingMachineInvalidEntryException,
            VendingMachineItemOutOfStockException,
            VendingMachinePersistenceException;
    
    List<Item>getAllItems() throws
            VendingMachinePersistenceException;
    
    
    void depositMoney(BigDecimal balance) throws
            VendingMachinePersistenceException;
    
    public Change purchaseItem(int itemId, BigDecimal balance)throws
            VendingMachinePersistenceException, VendingMachineItemOutOfStockException,
           VendingMachineInsufficientFundsException, VendingMachineInvalidEntryException;
    
  
    public void updateItem(int itemId)
            throws VendingMachinePersistenceException;
}

