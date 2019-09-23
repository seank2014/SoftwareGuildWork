/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staypositive;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class StayPositive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userInput;
        String suserInput;
        suserInput = "";
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("What number should I count down from?");
        suserInput = myScanner.nextLine();
        userInput = Integer.parseInt(suserInput);
        
        while (userInput >= 0){
            System.out.print(userInput + " ");
            userInput--;
            if((userInput % 10) == 0 ){
                System.out.println();
            }// need to revisit why this works
        }
        
    }
    
}
