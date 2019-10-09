/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.List;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public interface VendingMachineDao {
   
    Item addItem(int itemId, Item item) 
            throws VendingMachinePersistenceException; 
    
    List<Item>getAllItems()
            throws VendingMachinePersistenceException;
    
    Item getItemById(int itemId)
            throws VendingMachinePersistenceException;
    
    void updateItem(int itemId)
            throws VendingMachinePersistenceException;
    
    Item deleteItem(int itemId)
            throws VendingMachinePersistenceException;
    
    //Should I put change in DAO?
    
    
}
