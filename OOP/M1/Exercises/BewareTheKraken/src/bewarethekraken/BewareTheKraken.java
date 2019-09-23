/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bewarethekraken;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class BewareTheKraken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();
        int fishes;
        String fish;
        fish ="";
        
        
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");
        
        int depthDivedInFt = 0;
   
        String breakOut; 
            
       // if I turn the while loop's condition to just read "true", it will create an infinite loop
        
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.

        while(depthDivedInFt < 36200){
            //System.out.println("true");
        
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            
            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
              
            }
           
            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
            
          System.out.println("Do you want to stop? (y/n)");
           breakOut = userInput.nextLine();
             if (breakOut.equals("y")){
                 depthDivedInFt -= 1000;
            break;
        }
        fishes = randomizer.nextInt(4) +1;

           if (fishes == 1){
               fish = "Goldfish";
           }  else if (fishes == 2){
               fish = "Swordfish";
               
           }else if(fishes == 3){
               fish = "Guppies";
           } else if (fishes == 4){
               fish = "Sun fish";
           }

            System.out.println("We just saw a " + fish);
             
                                  
        

        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
    
}
