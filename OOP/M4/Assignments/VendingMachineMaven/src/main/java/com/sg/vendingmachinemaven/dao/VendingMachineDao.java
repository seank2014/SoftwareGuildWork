/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.dao;

import com.sg.vendingmachinemaven.dto.Item;
import java.util.List;


/**
 *
 * @author seanking
 */
public interface VendingMachineDao {
    
    List<Item>getAllItems()
            throws VendingMachinePersistenceException;
    
    Item getItemById(int itemId)
            throws VendingMachinePersistenceException;
    
    void updateItem(int itemId)
            throws VendingMachinePersistenceException;
    
    Item deleteItem(String name)
            throws VendingMachinePersistenceException;
    
    //Should I put change in DAO?
    
    
}
