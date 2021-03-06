/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinemaven.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class UserIOConsoleImpl implements UserIO {
    
    Scanner myScanner = new Scanner(System.in);

     
     
     

    @Override// bug in code, where loop will only execute twice
    public void print(String message) {
       System.out.println(message);
    

    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        double doubleVal = Double.parseDouble(input);
        return doubleVal;

    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        min = 1;
        max = 100;
   String input = myScanner.nextLine();
       Double doubleInput = Double.parseDouble(input);
        
        while(doubleInput < 1 || doubleInput > 100){
            
            doubleInput = 1.0;
            
            System.out.println(prompt);
            myScanner.nextLine();

         
        } 
            

        
        return doubleInput;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        Float floatVal = Float.parseFloat(input);
        
        return floatVal;
        
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        min =1;
        max = 100;
        String input = myScanner.nextLine();
        Float floatVal = Float.parseFloat(input);
        
        while(floatVal < min || floatVal > max){
            floatVal = 1f;
            System.out.println(prompt);
            myScanner.nextLine();
        }
        return floatVal;
    }

    @Override
    public int readInt(String prompt) {
            System.out.println(prompt);
            String input = myScanner.nextLine();
            int intInput = Integer.parseInt(input);
            
            return intInput;


    }

    @Override
    public int readInt(String prompt, int min, int max) {
            System.out.println(prompt);
            min = 1;
            max = 100;
            String input = myScanner.nextLine();
            int intValue = Integer.parseInt(input);
            
            while(intValue < 1 || intValue > 100){
                
                System.out.println(prompt);
                myScanner.nextLine();
                intValue = 1;

            }
            
            return intValue;
            


    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        long longInput = Long.parseLong(input);
        
        return longInput;

    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String input =myScanner.nextLine();
        min =1;
        max =100;
        long longVal = Long.parseLong(input);
        
        while (longVal < 1 || longVal > 100){
            longVal = 1;
            
            System.out.println(prompt);
            myScanner.nextLine();
            
        }
        
        return longVal;
        
    }

    @Override
    public String readString(String prompt) {
         System.out.println(prompt);
        
        String input = myScanner.nextLine();
        
        return input;
        

    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        
        String input = myScanner.nextLine();
        //work on try catch block to catch "$"
        
        return new BigDecimal(input);//taking string prompt, save that string and than that it will convert to BigDecimal

    }
}
