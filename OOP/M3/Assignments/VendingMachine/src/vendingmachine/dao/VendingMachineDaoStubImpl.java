/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {
    
    Item firstItem;
    List<Item>itemList = new ArrayList<>();
    
    
    public VendingMachineDaoStubImpl(){
        firstItem = new Item(14);
        firstItem.setName("BenAndJerrys");
        firstItem.setQty(5);
        firstItem.setPrice(new BigDecimal("2.5"));
        
        itemList.add(firstItem);
    }
    
     @Override
    public Item addItem(int itemId, Item item) throws VendingMachinePersistenceException {
        if(itemId == firstItem.getItemId()){
            return firstItem;
        }else{
            return null;
        }
        
    }
    

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public Item getItemById(int itemId) throws VendingMachinePersistenceException {
        if(itemId == firstItem.getItemId()){
            return firstItem;
        }else{
            return null;
        }
    }

    @Override
    public void updateItem(int itemId) throws VendingMachinePersistenceException {
        
        if(itemId == firstItem.getItemId()){
            this.firstItem = firstItem;
        }else{
            this.firstItem = null;
        }
    }

    @Override
    public Item deleteItem(int itemId) throws VendingMachinePersistenceException {
        if(itemId == firstItem.getItemId()){
            return firstItem;
        }else{
            return null;
        }
    }
}
