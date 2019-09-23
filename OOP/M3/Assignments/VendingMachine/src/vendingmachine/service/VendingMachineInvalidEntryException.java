/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

/**
 *
 * @author seanking
 */
public class VendingMachineInvalidEntryException extends Exception {
    
    public VendingMachineInvalidEntryException(String message){
        super(message);
    }
    
    public VendingMachineInvalidEntryException(String message,
            Throwable cause){
        super(message, cause);
    }
    
}
