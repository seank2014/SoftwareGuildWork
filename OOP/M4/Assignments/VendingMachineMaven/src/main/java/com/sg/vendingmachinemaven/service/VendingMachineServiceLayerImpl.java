/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.service;

import com.sg.vendingmachinemaven.dao.VendingMachineAuditDao;
import com.sg.vendingmachinemaven.dao.VendingMachineDao;
import com.sg.vendingmachinemaven.dao.VendingMachinePersistenceException;
import com.sg.vendingmachinemaven.dto.Change;
import com.sg.vendingmachinemaven.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


/**
 *
 * @author seanking
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    BigDecimal balance;
    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    Change change;
    Item item;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void selectItem(int itemId)
            throws VendingMachineInsufficientFundsException,
            VendingMachineInvalidEntryException,
            VendingMachineItemOutOfStockException,
            VendingMachinePersistenceException {

        dao.getItemById(itemId);
        //auditDao.writeAuditEntry("Item purchased" + item.getItemId());

    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    //cant change to private
    @Override
    public void depositMoney(BigDecimal bigdecimal)
            throws VendingMachinePersistenceException {
        balance = bigdecimal.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Change returnChange()
            throws VendingMachinePersistenceException {

        return change;
    }

    @Override
    public void purchaseItem(int itemId)
            throws VendingMachinePersistenceException, VendingMachineItemOutOfStockException, VendingMachineInsufficientFundsException {
        Item item = dao.getItemById(itemId);

        if (item.getQty() <= 0) {
            throw new VendingMachineItemOutOfStockException("Item out of stock");
        } else if (item.getQty() > 0) {
            if (balance.compareTo(item.getPrice()) == -1) {
                throw new VendingMachineInsufficientFundsException("Sorry, you do not have enough money, please select something else");

            } else {
                dao.updateItem(itemId);
                change = new Change();

                if (balance.compareTo(new BigDecimal(".25")) != -1) {
                    int quarters = balance.divide(new BigDecimal(".25"), RoundingMode.FLOOR).intValue();
                    change.setQuarter(quarters);
                    balance = balance.subtract(new BigDecimal(quarters).multiply(new BigDecimal(".25")));
                }

                if (balance.compareTo(new BigDecimal(".10")) != -1) {
                    int dimes = balance.divide(new BigDecimal(".10"), RoundingMode.FLOOR).intValue();
                    change.setDime(dimes);
                    balance = balance.subtract(new BigDecimal(dimes).multiply(new BigDecimal(".10")));
                }

                if (balance.compareTo(new BigDecimal(".05")) != -1) {
                    int nickles = balance.divide(new BigDecimal(".05"), RoundingMode.FLOOR).intValue();
                    change.setNickel(nickles);
                    balance = balance.subtract(new BigDecimal(nickles).multiply(new BigDecimal(".05")));
                }

                if (balance.compareTo(new BigDecimal(".01")) != -1) {
                    int penny = balance.divide(new BigDecimal(".01"), RoundingMode.FLOOR).intValue();
                    change.setPennies(penny);
                    balance = balance.subtract(new BigDecimal(penny).multiply(new BigDecimal(".01")));

                }
            }

        }

    }

    @Override
    public BigDecimal getBalance()
            throws VendingMachinePersistenceException {
        return balance;
    }

    @Override
    public Item deleteItem(String itemId
    ) throws VendingMachinePersistenceException {
        return dao.deleteItem(itemId);
    }

}
