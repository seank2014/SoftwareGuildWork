/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizor;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class Factorizor {

    
    //has to be non-static to be accessed by main class
public void factorize(){
        Scanner input = new Scanner(System.in);

        int userInput, sum;
        String SuserInput;
        sum = 0;
        boolean prime =true;

        System.out.println("What number would you like to factor?");
        SuserInput = input.nextLine();
        userInput = Integer.parseInt(SuserInput);

        System.out.println("The factors of " + userInput + " are: ");

        if (userInput > 0) {

            for (int i = 1; i <= userInput; i++) {
                if (userInput % i == 0) {
                    System.out.println("" + i);
                    userInput = userInput /= i;

                }
            }

            System.out.println("Enter number again");
            SuserInput = input.nextLine();
            userInput = Integer.parseInt(SuserInput);

            for (int j = 1; j <= userInput / 2; j++) {

                if (userInput % j == 0) {
                    sum = sum + j;
                }
            }

            if (sum == userInput) {

                System.out.println(userInput + " is a perfect number.");
            } else {

                System.out.println(userInput + " is not a perfect number.");

            }

        }

        for (int i = 2; i < userInput; i++) {
            if(userInput%i==0){
                prime=false;
                break;
            }
        }
            
            
            if (prime==true) {
                System.out.println(userInput + " is a prime number.");
            } else {
                System.out.println(userInput + " is not a prime number.");
            }
}

    }

