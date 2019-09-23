/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class LuckySevens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int originalBet, die1, die2, sum, roll, currentBet, currentRoll;
        String oBet;
        roll = 0;
        currentBet = 0;
        currentRoll = 0;
    

        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();

        System.out.println("Welcome to LuckySevens");
        System.out.println("\nRoll the die and try your luck");

        System.out.println("\nPlease enter your starting bet");
        oBet = userInput.nextLine();
        originalBet = Integer.parseInt(oBet);

        currentBet = originalBet;
        

        do {

            roll++;

            die1 = randomizer.nextInt(4) + 1;
            die2 = randomizer.nextInt(3) + 1;
            sum = die1 + die2;

            if (sum == 7) {
                currentBet += 4;

            } else {
                currentBet -= 1;
            }

            if (currentBet > originalBet)  {

                originalBet = currentBet;
                currentRoll = roll;
            }

        } while (currentBet > 0);

        System.out.println("You broke after " + roll + " rolls");

            System.out.println("You should have quit after " + currentRoll + " rolls when you had " + originalBet + " dollars");

        

    }

}
