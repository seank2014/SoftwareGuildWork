/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessmefinally;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author seanking
 */
public class GuessMeFinally {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random randomizer = new Random();
        Scanner myScanner = new Scanner(System.in);
       
        
        int userInput,myNumber,i;
        String suserInput;
        suserInput = "";
        
        myNumber = randomizer.nextInt(100 + 1 + 100)  - 100;
        /*System.out.println(myNumber);
        
        }*/ //either I tried to use a for loop to check this in a previous code-along, realized a better way to do this was to comment the rest of the code and just output the random number
        
        System.out.println("I am thinking of a number between -100 and 100. Enter what you think it is:");
        suserInput = myScanner.nextLine();
        userInput = Integer.parseInt(suserInput);
        System.out.println("You guessed: " + userInput);
        
        if (myNumber == userInput){
            System.out.println("Wow, nice guess! That was it!");
        } 
       
        
        while (myNumber != userInput) {
            
        if(myNumber < userInput){
            System.out.println("Oh no! That is too high, try another number");
            suserInput = myScanner.nextLine();
            userInput = Integer.parseInt(suserInput);
            System.out.println("You guessed: " + userInput);
            }else if (myNumber > userInput){
               System.out.println("Too low, try again.");
               suserInput = myScanner.nextLine();
               userInput = Integer.parseInt(suserInput);
               System.out.println("You guessed: " + userInput);

           }
           } System.out.println("I was thinking of " + myNumber);
                      System.out.println("Finally, it's about time you got it!");

           
        
        
        
    }
    
}
