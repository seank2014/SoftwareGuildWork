/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AddressBookDaoFileImpl implements AddressBookDao {
    
    private Map <String, Address> AddressBook = new HashMap<>();
    public static final String BOOK_FILE = "addressBook.txt";
    public static final String DELIMITER = "::";

   
    @Override
    public Address addAddress(String lastName, Address address)
    throws AddressBookDaoException{
        Address newAddress = AddressBook.put(lastName, address);
        writeBook();
        return newAddress;
    }

    @Override
    public Address removeAddress(String lastName)
    throws AddressBookDaoException{
        Address removedAddress = AddressBook.remove(lastName);
        writeBook();
        return removedAddress;
    }

    @Override
    public Address findAddress(String lastName)
    throws AddressBookDaoException{
//        loadBook();
        return AddressBook.get(lastName);
    }

    @Override
    public int TotalNumber()
    throws AddressBookDaoException{
        loadBook();
        return AddressBook.size();
    }

    @Override
    public List<Address> ListAllAddresses()
    throws AddressBookDaoException{
        loadBook();
        return new ArrayList<Address>(AddressBook.values());
    }

    @Override
    public Address editAddress(String lastName, Address editedAddress) 
    throws AddressBookDaoException{
       AddressBook.put(lastName, editedAddress);
       writeBook();
        return editedAddress;  
    }
    
    private void loadBook()throws AddressBookDaoException
    {
        Scanner scanner;
        
        try{
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(BOOK_FILE)));
        } catch(FileNotFoundException e){
            throw new AddressBookDaoException(
            "-_- Could not load address book data into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Address currentAddress = new Address(currentTokens[0]);
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setStreetName(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            currentAddress.setZipCode(currentTokens[5]);
            AddressBook.put(currentAddress.getLastName(), currentAddress);
        }
        scanner.close();
    }
    
    private void writeBook() throws AddressBookDaoException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(BOOK_FILE));
        }catch(IOException e){
            throw new AddressBookDaoException("Could not save address data", e);
        }
        
        List<Address> addressBook = this.ListAllAddresses();
        for(Address currentAddress : addressBook){
            out.println(currentAddress.getLastName() + DELIMITER +
                    currentAddress.getFirstName() + DELIMITER +
                    currentAddress.getStreetName() + DELIMITER +
                    currentAddress.getCity() + DELIMITER + 
                    currentAddress.getState() + DELIMITER +
                    currentAddress.getZipCode());
            
            out.flush();
        }
        out.close();
    }
    
}
