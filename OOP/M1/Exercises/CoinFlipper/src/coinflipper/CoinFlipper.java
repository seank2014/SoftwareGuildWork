/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinflipper;

import java.util.Random;

/**
 *
 * @author seanking
 */
public class CoinFlipper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Random randomizer = new Random();
 
        System.out.println("READY, SET, FLIP...");
        System.out.print("You got: ");
        
 randomizer.nextBoolean();
 
 if (randomizer.nextBoolean() == true){
     System.out.println("Tails");
 }else{
     System.out.println("Heads");
 }
 // i first put else if but that was making the boolean sometimes return a value that was neither true or false
    }
    
}
