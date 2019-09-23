/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author seanking
 */
public interface AddressBookDao {
    
    Address addAddress(String lastName, Address address) throws AddressBookDaoException;
    
    Address removeAddress(String lastName)throws AddressBookDaoException;
    
    Address findAddress(String lastName)throws AddressBookDaoException;
    
    int TotalNumber()throws AddressBookDaoException;
    
    List <Address> ListAllAddresses()throws AddressBookDaoException;
    
    Address editAddress(String lastName, Address editedAddress)throws AddressBookDaoException;
    
    
}
