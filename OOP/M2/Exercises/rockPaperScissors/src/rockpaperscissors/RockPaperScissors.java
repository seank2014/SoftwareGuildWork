/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class RockPaperScissors {

    
   
        public void go(){
      
            int min, max, ties,Cwins,Uwins, userInput,rounds, cNum, i;
       String suserInput, Urounds, playAgain= "";
       min=1;
       max =10;
       i =0;
       
       ties =0;
       Cwins=0;
       Uwins=0;
       
       
       Scanner myScanner = new Scanner(System.in);
       Random randomizer = new Random();
       
        System.out.println("WELCOME TO ROCK, PAPER, SCISSORS");
        
       do{
           
            
        System.out.println("\n How many rounds do you want to play? Choose between 1 and 10:");
        Urounds = myScanner.nextLine();
        rounds = Integer.parseInt(Urounds);
        
        
        

    if(rounds < min || rounds > max){
            System.out.println("Invalid entry!"); 
           break;
        }
    
       do{
        System.out.println("Rock, paper or scissor? Enter: \n 1 for rock \n 2 for paper \n 3 for scissors");
        suserInput = myScanner.nextLine();
       userInput = Integer.parseInt(suserInput);
       
       cNum = randomizer.nextInt(3)+1; 

       if (userInput > 3|| userInput < 1){
           break;
       }
       if(userInput == cNum){
           System.out.println("tie");
           ties++;
       }else if (userInput == 1 && cNum ==2){
           System.out.println("Computer wins this round!");
           Cwins++;
       } else if(userInput == 1 && cNum == 3){
           System.out.println("You win this round!");
           Uwins++;
           }else if(userInput == 2 && cNum == 1){
               System.out.println("You win this round!");
               Uwins++;
           }else if(userInput == 2 && cNum == 3){
               System.out.println("Computer wins this round!");
               Cwins++;
           }else if(userInput == 3 && cNum == 1){
               System.out.println("Computer wins this round!");
               Cwins++;
           }else if(userInput == 3 && cNum == 2){
               System.out.println("You win this round!");
               Uwins++;
           }
       
       System.out.print("Computer chose " + cNum);
       System.out.println("\n Your wins: " + Uwins +" Computer wins: " + Cwins + " Ties: " + ties);
        i++; 
}while (i < rounds);

        System.out.println("Total ties were: " +ties);
        System.out.println("Your total wins were:  " + Uwins );
        System.out.println("The computers total wins were:  " + Cwins);
        
       if(ties > Uwins && ties > Cwins){
           System.out.println("It was a tie!");
       }else if(Uwins > ties && Uwins > Cwins){
           System.out.println("Congrats, overall wins go to you!");
       }else if(Cwins > ties && Cwins > Uwins){
           System.out.println("Computer wins, better luck next time.");
       }else{
        System.out.println("It's a tie");
           
       }
       
       
           
       System.out.println("Would you like to play again (y/n)?");
       playAgain = myScanner.nextLine();
       
       
       }while(playAgain.equalsIgnoreCase("y"));
       
        System.out.println("Thanks for playing!");
             
        }
 
        
            
        }
        
    
    

