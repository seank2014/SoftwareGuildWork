/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private Map<Integer, Item> vending = new HashMap<>();
    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    //Created only for the purpose of testing the getAllItems methods
    @Override
    public Item addItem(int itemId, Item item) throws VendingMachinePersistenceException {
        Item newItem = vending.put(itemId, item);
        writeInventory();
        return newItem;
    }
    
    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        loadInventory();
        return new ArrayList<Item>(vending.values());
    }

    @Override
    public Item getItemById(int itemId) throws VendingMachinePersistenceException {
//        loadInventory();
        return vending.get(itemId);
    }

    @Override
    public void updateItem(int itemId) throws VendingMachinePersistenceException {
        loadInventory();
        int itemCount = vending.get(itemId).getQty();
        vending.get(itemId).setQty(itemCount-1);
        writeInventory();
    }

    @Override
    public Item deleteItem(int itemId) throws VendingMachinePersistenceException {

        Item deletedItem = vending.remove(itemId);
        writeInventory();
        return deletedItem;

    }

    private void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load inventory data into memory.", e);
        }

        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item(Integer.parseInt(currentTokens[0]));
            currentItem.setName(currentTokens[1]);
            currentItem.setQty(Integer.parseInt(currentTokens[2]));
            currentItem.setPrice(new BigDecimal(currentTokens[3]));
            vending.put(currentItem.getItemId(), currentItem);
           
        }
        scanner.close();

    }

    private void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save student data.", e);
        }
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getItemId()+ DELIMITER +
                    currentItem.getName() + DELIMITER
                    + currentItem.getQty() + DELIMITER
                    + currentItem.getPrice());
            out.flush();
        }
        out.close();
    }

    /* insert into file if doesnt start automatically
    
    1::Gummy Bears::4::3.00
2::Juice::5::4.00
3::Snickers::12::1.25
4::Oreos::0::1.25
5::M&Ms::10::1.00
6::Soda::7::1.50
7::Ritz::6::0.75
8::Pretzels::10::1.50*/
}
