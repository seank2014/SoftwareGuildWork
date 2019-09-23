/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class TaxDAOFIleImpl implements TaxDAO {
     
    List<Tax> taxes = new ArrayList<>();
   public static final String TAX_FILE = "taxes.txt";
    public static final String DELIMETER = ",";

   @Override
   public List<Tax> loadTaxes() throws FlooringPersistenceException {
        Scanner scanner;
        try {
        // Create Scanner for reading the file
        scanner = new Scanner(
        new BufferedReader(
                new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e){
            throw new FlooringPersistenceException(
            "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            Tax currentTax = new Tax((currentTokens[0]));
            currentTax.setTaxRate(new BigDecimal(currentTokens[1]));
           taxes.add(currentTax);  
    
        }
        
       
        
        scanner.close();
        return taxes;
    }
   
     
}
