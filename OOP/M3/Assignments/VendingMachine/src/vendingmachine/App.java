/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.service.VendingMachineInsufficientFundsException;
import vendingmachine.service.VendingMachineInvalidEntryException;
import vendingmachine.service.VendingMachineItemOutOfStockException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.service.VendingMachineServiceLayerImpl;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author seanking
 */
public class App {

    /**
     * @param args the command line arguments
     * @throws vendingmachine.service.VendingMachineInsufficientFundsException
     * @throws vendingmachine.service.VendingMachineInvalidEntryException
     * @throws vendingmachine.service.VendingMachineItemOutOfStockException
     * @throws vendingmachine.dao.VendingMachinePersistenceException
     */
    public static void main(String[] args) throws VendingMachineInsufficientFundsException,
       VendingMachineInvalidEntryException, VendingMachineItemOutOfStockException,
        VendingMachinePersistenceException{
        
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService =new VendingMachineServiceLayerImpl(myDao, myAuditDao);
       VendingMachineController controller = new VendingMachineController(myService, myView);
       controller.run();
        
        
    }

   
    
}
