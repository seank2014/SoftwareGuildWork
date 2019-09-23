/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessmemore;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class GuessMeMore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Random randomizer = new Random();
        Scanner myScanner = new Scanner(System.in);
       
        
        int userInput,myNumber,i;
        String suserInput;
        suserInput = "";
        
        myNumber = randomizer.nextInt(100 + 1 + 100) - 100;
        //System.out.println(myNumber);
        
        /*for(i =myNumber; i < 21;i++){
            System.out.println(i);
        }*/ //wasnt sure that I had the right range so i created a for loop to check
        System.out.println("I am thinking of a number between -100 and 100. Enter what you think it is:");
        suserInput = myScanner.nextLine();
        userInput = Integer.parseInt(suserInput);
        System.out.println("You guessed: " + userInput);
        
        if (myNumber == userInput){
            System.out.println("Wow, right on the money! Great work.");
        } else if (myNumber < userInput){
            System.out.println("Oh no! That is too high, try again");
            suserInput = myScanner.nextLine();
            userInput = Integer.parseInt(suserInput);
            System.out.println("You guessed: " + userInput);
            if(myNumber < userInput){
                System.out.println("Didn't guess low enough, sorry.");  
            }else if(myNumber > userInput){
                System.out.println("Dang, now you are too low. Oh well, better luck next time.");
            }else if(myNumber == userInput){
                System.out.println("Way too go, you guessed it.");
            }
            
            
           } else if (myNumber > userInput){
               System.out.println("Too low, try again.");
               suserInput = myScanner.nextLine();
               userInput = Integer.parseInt(suserInput);
               System.out.println("You guessed: " + userInput);
               if(myNumber > userInput){
                   System.out.println("Still too low. Thanks for playing");
               } else if(myNumber < userInput){
                       System.out.println("Too high, sorry. Play again, sometime");
                   }else if(myNumber == userInput){
                       System.out.println("Finally got it. Congrats!");
                   }
           } System.out.println("I was thinking of " + myNumber);
        
        
        
        
        
    }
    
}
