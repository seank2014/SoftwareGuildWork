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

    private Map<String, Item> vending = new HashMap<>();
    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        loadInventory();
        return new ArrayList<Item>(vending.values());
    }

    @Override
    public Item getItemById(int itemId) throws VendingMachinePersistenceException {
        loadInventory();
        return vending.get(itemId);
    }

    @Override
    public void updateItem(int itemId) throws VendingMachinePersistenceException {
        loadInventory();
        int itemCount = vending.get(itemId).getQty();

        vending.get(itemId).setQty(itemCount - 1);
    }

    @Override
    public Item deleteItem(String itemId) throws VendingMachinePersistenceException {

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
            Item currentItem = new Item();
            currentItem.setName("Snickers");
            currentItem.setQty(15);
            currentItem.setPrice(new BigDecimal("1.25"));
            vending.put(currentItem.getName(), currentItem);
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
            out.println(currentItem.getName() + DELIMITER
                    + currentItem.getQty() + DELIMITER
                    + currentItem.getPrice());
            out.flush();
        }
        out.close();
    }
}
