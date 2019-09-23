/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.advice;

import com.sg.vendingmachinemaven.dao.VendingMachineAuditDao;
import com.sg.vendingmachinemaven.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author seanking
 */
public class LoggingAdvice {

    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp){
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args){
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        }catch (VendingMachinePersistenceException e){
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
