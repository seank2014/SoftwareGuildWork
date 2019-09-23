/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessme;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class GuessMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int answer;
       int userInput;
       String suserInput; //sAnswer;
       
       Random rGen = new Random();
       answer = rGen.nextInt(50) + 1;
       
       suserInput = "";
      // sAnswer = "";
      
      System.out.println("Please guess a number between 1 and 50: ");
       
       Scanner myScanner = new Scanner (System.in);
       suserInput = myScanner.nextLine();
        System.out.println("Your guess: " + suserInput);
       userInput = Integer.parseInt(suserInput);
       
  
       if (userInput == answer){
           System.out.println("Wow, nice guess! That was it");
       }
       
       if (userInput < answer){
           System.out.println("Ha, nice try - too low! I chose " + answer);
           
       }
       
       if (userInput > answer) {
           System.out.println("Too bad, way too high. I chose " + answer);
       }
       
       
    }
    
}
