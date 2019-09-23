/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.controller;

import addressbook.dao.AddressBookDao;
import addressbook.dao.AddressBookDaoException;
import addressbook.dto.Address;
import addressbook.ui.AddressBookView;
import java.util.List;

/**
 *
 * @author seanking
 */
public class AddressBookController {

    AddressBookDao dao;
    AddressBookView view;
    
    public AddressBookController(AddressBookDao dao,AddressBookView view ){
        this.dao = dao;
        this.view = view;
        
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try{
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createAddress();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    findAddress();
                    break;
                case 4:
                    addressCount();
                    break;
                case 5:
                    listAllAddresses();
                    break;
                case 6:
                    editAddress();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exit();
        }catch(AddressBookDaoException e){
            view.errorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {

        return view.printMenu();

    }

    private void createAddress() throws AddressBookDaoException {
        view.addAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.addressCreatedSuccessBanner();
    }

    private void listAllAddresses()throws AddressBookDaoException {
        view.listAllAddressesBanner();
        List<Address> addressBook = dao.ListAllAddresses();
        view.displayAddressList(addressBook);
    }

    private void findAddress()throws AddressBookDaoException {
        view.displayAddressBanner();
        String lastName = view.getLastNameAddress();
        Address address = dao.findAddress(lastName);
        view.displayAddress(address);
    }

    private void removeStudent() throws AddressBookDaoException{
        view.removedAddressBanner();
        String lastName = view.getLastNameToDelete();
        dao.removeAddress(lastName);
        view.removedAddressSuccessful();
    }

    private void addressCount() throws AddressBookDaoException {
        view.addressCountMenuBanner();
        List<Address> addressBook = dao.ListAllAddresses();
        dao.TotalNumber();
        view.addressCountMenu(addressBook);
    }

    private void editAddress() throws AddressBookDaoException {
        view.editAddressBanner();
        String lastName = view.getLastNameToEdit();
        dao.findAddress(lastName);
        if (dao.findAddress(lastName) != null) {
            Address editAddress = view.getNewAddressInfo();
            dao.editAddress(lastName, editAddress);
            view.AddresseditedSuccess();
        } else {
            view.noSuchPerson();
        }
    }

    private void exit() {
        view.exitBanner();
    }

    private void unknownCommand() {
        view.unknownCommandBanner();
    }

}
