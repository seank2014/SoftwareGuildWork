/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import addressbook.controller.AddressBookController;
import addressbook.dao.AddressBookDao;
import addressbook.dao.AddressBookDaoFileImpl;
import addressbook.ui.AddressBookView;
import addressbook.ui.UserIO;
import addressbook.ui.UserIOConsole;

/**
 *
 * @author seanking
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserIO io = new UserIOConsole();
        AddressBookDao dao = new AddressBookDaoFileImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookController controller = new AddressBookController(dao, view);
        controller.run();
    }
    
}
