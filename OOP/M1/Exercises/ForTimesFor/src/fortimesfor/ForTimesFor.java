/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortimesfor;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class ForTimesFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner userInput = new Scanner(System.in);
        String suserNumber, suserAnswer;
        suserNumber = "";
        suserAnswer = "";
        int userNumber, userAnswer, points;
        points = 1;
        System.out.println("Which times tables shall I recite?");
        suserNumber = userInput.nextLine();
        userNumber = Integer.parseInt(suserNumber);
        
        for(int i = 1; i < 16; i++){
            System.out.println( i + " * " + userNumber + " is: ");
            suserAnswer = userInput.nextLine();
            userAnswer = Integer.parseInt(suserAnswer);
            
            if(userAnswer == (userNumber * i)){
                System.out.println("Correct! You've earned 1 point");
                points++;
            }else{
                System.out.println("Incorrect, the answer is " + (userNumber * i));
            }
            
            }
        System.out.println("You've earned " + points + " points");
        
        if (points < 8) {
            System.out.println("You got less than 50%, you should study more");
        }else if(points > 14.5){
            System.out.println("Congrats, you got over 90% correct!");
        }
    }
    
}
