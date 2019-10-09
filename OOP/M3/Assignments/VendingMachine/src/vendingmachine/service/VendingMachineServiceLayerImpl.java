/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    Change change;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Item selectItem(int itemId)
            throws VendingMachineInsufficientFundsException,
            VendingMachineInvalidEntryException,
            VendingMachineItemOutOfStockException,
            VendingMachinePersistenceException {

       return dao.getItemById(itemId);

    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public void depositMoney(BigDecimal balance)
            throws VendingMachinePersistenceException {
        balance.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Change purchaseItem(int itemId, BigDecimal balance)
            throws VendingMachinePersistenceException, VendingMachineItemOutOfStockException, VendingMachineInsufficientFundsException,
            VendingMachineInvalidEntryException {
        
                Item item = selectItem(itemId);
                
                if(item == null){
                    throw new VendingMachineInvalidEntryException("Item number doesn't exist");
                }

        if (item.getQty() <= 0) {
            throw new VendingMachineItemOutOfStockException("Item out of stock");
        } else if (item.getQty() > 0) {
            if (balance.compareTo(item.getPrice()) == -1) {
                throw new VendingMachineInsufficientFundsException("Sorry, you do not have enough money. You gave " +"$"+ balance);

            } else {
               balance = balance.subtract(item.getPrice());

                updateItem(itemId);
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
        
        auditDao.writeAuditEntry(item.getName() + " purchased");
        
        return change;

     }

    

    @Override
    public void updateItem(int itemId
    ) throws VendingMachinePersistenceException {
        dao.updateItem(itemId);
    }

}
