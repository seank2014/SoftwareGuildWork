/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.ui;

import addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author seanking
 */
public class AddressBookView {

    private UserIO io;
    
    public AddressBookView(UserIO io){
        this.io = io;
    }

    //if you dont put "public" other classes will not be able to access method
    public int printMenu() {
        io.print("Main Menu");
        io.print("1. Add address\n"
                + "2. Remove an address\n"
                + "3. Find address by last name\n"
                + "4. Show number of addresses in book\n"
                + "5. List all address in book\n"
                + "6. Edit an address\n"
                + "7. Exit");

        return io.readInt("Please select from the about choices.", 1, 7);

    }

    public Address getNewAddressInfo() {
        String lastName = io.readString("Please enter address holders last name");
        String firstName = io.readString("Please enter address holders first name");
        String streetName = io.readString("Please enter the street address");
        String city = io.readString("Please enter the city");
        String state = io.readString("Please enter the state");
        String zipCode = io.readString("Please enter zipcode");
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setStreetName(streetName);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZipCode(zipCode);
        return currentAddress;
         
    }
    
    public void addAddressBanner(){
        io.print("Add Address Menu:");
    }
    
    public int addressCreatedSuccessBanner(){
        return io.readInt("Address added. Press 1 to go to Main Menu",1,1);
    }
    
    public void listAllAddressesBanner(){
        io.print("List Address Menu:");
    }
    
    public void displayAddressList(List<Address> addressBook){
        for(Address currentAddress : addressBook){
            io.print(currentAddress.getLastName() + ", " + currentAddress.getFirstName()
            + ": "
            + currentAddress.getStreetName() + ", " + currentAddress.getCity() + ", " + currentAddress.getState()
            + ", " + currentAddress.getZipCode());
        }
        io.readInt("Press 1 to go to Main Menu", 1, 1);
    }
    
    public void displayAddressBanner(){
        io.print("Find Address Menu:");
    }
    
    public String getLastNameAddress(){
       return io.readString("Please enter the last name of the person's address you are trying to locate");
    }
    
    public void displayAddress(Address address){
        if(address != null){
            io.print(address.getFirstName() + " " + address.getLastName() + ":");
            io.print(address.getStreetName());
            io.print(address.getCity() + ", " + address.getState());
            io.print(address.getZipCode());
        } else{
            io.print("No such address.");
        }
       io.readInt("Press 1 to go to Main Menu", 1, 1);
    }
    
    public void removedAddressBanner(){
        io.print("Delete Address Menu");
    }
    
     public String getLastNameToDelete(){
       return io.readString("Please enter the last name of address to delete:");
    }
     
     public void removedAddressSuccessful(){
         io.readInt("Address Deleted. Press 1 to go to Main Menu", 1,1);
     }
     
     public void addressCountMenuBanner(){
         io.print("List Address Count Menu:");
     }
     
     public int addressCountMenu(List<Address> addressBook){
         int count = addressBook.size();
         
         if (count == 1){
             return io.readInt("There is " + count + " address in the book. Please press 1 to go to Main Menu",1,1);
         }else{
    return io.readInt("There are " + count + " addresses in the book. Please press 1 to go to Main Menu",1,1);
         }
     }
     
     public void editAddressBanner(){
         io.print("Edit Address:");
     }
     
     public void AddresseditedSuccess(){
         io.readInt("Address edited. Please enter 1 to go to the Main Menu",1,1);
     }
     
        public String getLastNameToEdit(){
       return io.readString("Please enter the last name of address you'd like to edit:");
    }
        
        public int noSuchPerson(){
            return io.readInt("No such person is listed in the AddressBook. Please enter 1 to go to the Main Menu", 1, 1);
        }
        
        public void exitBanner(){
            io.print("Good Bye!");
        }
        
        public void unknownCommandBanner(){
            io.print("Unknown Command!");
        }
     
        public void errorMessage(String errorMsg){
            io.print("Error:");
            io.print(errorMsg);
        }
    

}
