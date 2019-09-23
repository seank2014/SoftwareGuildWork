/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biggerbetteradder;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class BiggerBetterAdder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int num1,num2, num3, total;
        num1 = 0;
        num2 = 0;
        num3 = 0;
        total = 0;
        
        
        Scanner myScanner = new Scanner (System.in);
            
        String snum1, snum2, snum3;
        snum1 = "";
        snum2 = "";
        snum3 = "";
        
        System.out.println("Please enter the first number to be added:");
        snum1 = myScanner.nextLine();
        
        System.out.println("Please enter the second number to be added:");
        snum2 = myScanner.nextLine();
        
        System.out.println("Please enter the last number to be added:");
        snum3 = myScanner.nextLine();
        
        num1 = Integer.parseInt(snum1);
        num2 = Integer.parseInt(snum2);
        num3 = Integer.parseInt(snum3);
        
        total = num1 + num2 + num3;
        
        System.out.println("The total is: " + total);
        
        
        
        


        
    }
    
}
