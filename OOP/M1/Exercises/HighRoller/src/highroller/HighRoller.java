/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highroller;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class HighRoller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userInput;
        String suserInput;
        suserInput = "";
        
        Random diceRoller = new Random();
        Scanner readerInput = new Scanner(System.in);
        System.out.println("Pick the number of sides the dice has:");
        suserInput = readerInput.nextLine();
        userInput = Integer.parseInt(suserInput);
        
         
       
        
        int rollResult = diceRoller.nextInt(userInput) + 1;
        
        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("You rolled a " + rollResult);
        
        if(rollResult == 1){
            System.out.println("You rolled a crit failure! Ouch.");
        }else if(rollResult == userInput){
            System.out.println("You rolled a critical! Nice Job!");
        }
    }
    
}
