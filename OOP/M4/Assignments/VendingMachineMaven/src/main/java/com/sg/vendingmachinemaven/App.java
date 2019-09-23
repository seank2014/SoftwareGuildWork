/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven;

import com.sg.vendingmachinemaven.controller.VendingMachineController;
import com.sg.vendingmachinemaven.dao.VendingMachinePersistenceException;
import com.sg.vendingmachinemaven.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachinemaven.service.VendingMachineInvalidEntryException;
import com.sg.vendingmachinemaven.service.VendingMachineItemOutOfStockException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author seanking
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws VendingMachineInsufficientFundsException,
       VendingMachineInvalidEntryException, VendingMachineItemOutOfStockException,
        VendingMachinePersistenceException{
        
//        UserIO myIo = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
//        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
//        VendingMachineServiceLayer myService =new VendingMachineServiceLayerImpl(myDao);
//       VendingMachineController controller = new VendingMachineController(myService, myView);
//       controller.run();
        
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
    
}
