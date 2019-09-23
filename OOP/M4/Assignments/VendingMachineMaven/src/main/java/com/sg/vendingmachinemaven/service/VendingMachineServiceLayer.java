/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.service;

import com.sg.vendingmachinemaven.dao.VendingMachinePersistenceException;
import com.sg.vendingmachinemaven.dto.Change;
import com.sg.vendingmachinemaven.dto.Item;
import java.math.BigDecimal;
import java.util.List;


/**
 *
 * @author seanking
 */
public interface VendingMachineServiceLayer {
    
    
    void selectItem(int itemId) throws
            VendingMachineInsufficientFundsException,
            VendingMachineInvalidEntryException,
            VendingMachineItemOutOfStockException,
            VendingMachinePersistenceException;
    
    List<Item>getAllItems() throws
            VendingMachinePersistenceException;
    
    
    void depositMoney(BigDecimal bigdecimal) throws
            VendingMachinePersistenceException;//Maybe I should give this another name
    
    public Change returnChange() throws
            VendingMachinePersistenceException;
    
    public void purchaseItem(int itemId)throws
            VendingMachinePersistenceException, VendingMachineItemOutOfStockException,
           VendingMachineInsufficientFundsException;
    
    public BigDecimal getBalance() throws
            VendingMachinePersistenceException;
    
    public Item deleteItem(String itemId)
            throws VendingMachinePersistenceException;
}

