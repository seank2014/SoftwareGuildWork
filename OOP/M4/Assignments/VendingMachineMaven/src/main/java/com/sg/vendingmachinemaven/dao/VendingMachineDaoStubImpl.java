/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.dao;

import com.sg.vendingmachinemaven.dto.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seanking
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {
    Item onlyItem;
    List<Item>itemList = new ArrayList<>();

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getItemById(int itemId) throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateItem(int itemId) throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item deleteItem(String name) throws VendingMachinePersistenceException {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
