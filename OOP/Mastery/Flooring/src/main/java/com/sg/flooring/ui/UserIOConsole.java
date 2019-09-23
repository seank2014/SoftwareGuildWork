/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class UserIOConsole implements UserIO {
     
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
        BigDecimal bigDecimal = new BigDecimal(input);
        //taking string prompt, save that string and than that it will convert to BigDecimal

        return bigDecimal;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
        
        System.out.println(prompt);
        String input =myScanner.nextLine();
        min = new BigDecimal("1.00");
        max = new BigDecimal("1000000.00");
        BigDecimal bigDecimal = new BigDecimal(input);
        
        while (bigDecimal.compareTo(min)< -1 || bigDecimal.compareTo(max) < 1) {
            bigDecimal = new BigDecimal("1.00");
            System.out.println(prompt);
            myScanner.nextLine();     
        }        
        return bigDecimal;
    }

    @Override
    public LocalDate readLocalDate(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        LocalDate localDate = LocalDate.parse(input);
        return localDate;    
    }

    @Override
    public LocalDate readLocalDate(String prompt, LocalDate min, LocalDate max) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        min = LocalDate.MIN;
        max = LocalDate.MAX;
        LocalDate localDate = LocalDate.parse(input);
        
        
        while(localDate.compareTo(min) > -1 || localDate.compareTo(max) < 1){
            localDate = LocalDate.MIN;
            System.out.println(prompt);
            myScanner.nextLine();
        }
        return localDate;

    }
    
}
