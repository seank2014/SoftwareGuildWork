/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class ProductDAOFileImpl implements ProductDAO {
    
    private Map<String, Product>productTypes = new HashMap<>();
    public static final String PRODUCT_FILE = "product.txt";
    public static final String DELIMETER = ",";

    @Override
    public Product getProductByProductType(String productType) 
    throws FlooringPersistenceException {
        loadProduct();
        return productTypes.get(productType);
    }

    @Override
    public List<Product> getAllProducts()
            throws FlooringPersistenceException {
        
        loadProduct();
        
        return new ArrayList<Product>(productTypes.values());
    }
    
    private void loadProduct() throws FlooringPersistenceException {
        
        Scanner scanner;
        
        try {
        // Create Scanner for reading the file
        scanner = new Scanner(
                
        new BufferedReader(
                
                new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e){
            throw new FlooringPersistenceException(
            "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            Product currentProduct = new Product(currentTokens[0]);
            currentProduct.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));
            productTypes.put(currentProduct.getProductType(), currentProduct);
            
        }
        scanner.close();
        
        
    }
    
}
