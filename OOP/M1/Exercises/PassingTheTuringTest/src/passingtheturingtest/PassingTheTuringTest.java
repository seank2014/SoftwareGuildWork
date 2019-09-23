/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passingtheturingtest;

import java.util.Scanner;



/**
 *
 * @author seanking
 */
public class PassingTheTuringTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userName, myName, color, favoriteFood, number;
        
        userName = "";
        myName = "Duke";
        color ="";
        favoriteFood = "";
        number = "";
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Hello there, what is your name?");
        userName = inputReader.next();
        
        System.out.println("Oh, well nice to meet you " + userName + ", my name is " + myName + "\n");
        
        System.out.println("So what is your favorite color?");
        color = inputReader.next();
        
        System.out.println(color +" is a really nice color\n");
        
        System.out.println("You seem really cool, what is your favorite food?");
        favoriteFood = inputReader.next();
        
        System.out.println(userName + " that sounds delicious!\n");
        
        System.out.println("You know," + userName + " you are really cool. What is your your favorite number?");
        number = inputReader.next();
        
        System.out.println( number + " is really awesome\n");
        System.out.println("Well, it was nice getting to know you. Have a good day!");
       
        
        
        
        
    }
    
}
