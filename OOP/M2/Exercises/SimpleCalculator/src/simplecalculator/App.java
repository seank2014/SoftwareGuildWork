/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class App {

    public static void main(String[] args) {
        //Instantiate the simpleCalculator object
    SimpleCalculator mySimpleCalculator = new SimpleCalculator();
    
        
        Scanner input = new Scanner(System.in);

        //variables
        int userInput1, userInput2;
        String suserInput1, suserInput2, suserInput;

        System.out.println("Calculator");
        
        //Do while loop to keep code ruuning if user wants to continue
        do{

        System.out.println("\n Would you like to add, subtract, multiply or divide two numbers?");

        suserInput = input.nextLine();

        if (suserInput.equalsIgnoreCase("add")) {
            
            // Main code to ask user for input and printing out calculation

            System.out.println("Ok, please enter the first number you would like to add");
            suserInput1 = input.nextLine();
            userInput1 = Integer.parseInt(suserInput1);
            System.out.println("Now please enter the second");
            suserInput2 = input.nextLine();
            userInput2 = Integer.parseInt(suserInput2);
            
                int sum = SimpleCalculator.add(userInput1, userInput2);
                System.out.println("The sum is "+ sum); 

        } else if (suserInput.equalsIgnoreCase("subtract")) {
            System.out.println("Great, please enter the first number you would like to subtract");
            suserInput1 = input.nextLine();
            userInput1 = Integer.parseInt(suserInput1);
            System.out.println("Please enter the second number");
            suserInput2 = input.nextLine();
            userInput2 = Integer.parseInt(suserInput2);
            
            int difference = SimpleCalculator.substract(userInput1, userInput2);
            System.out.println("The difference is " + difference);
            

        } else if (suserInput.equalsIgnoreCase("multiply")) {
            System.out.println("Wonderful, please enter the first number you would like to multiply");
            suserInput1 = input.nextLine();
            userInput1 = Integer.parseInt(suserInput1);
            System.out.println("Now the second number, please");
            suserInput2 = input.nextLine();
            userInput2 = Integer.parseInt(suserInput2);
            
            int total = SimpleCalculator.multiply(userInput1, userInput2);
            System.out.println("The total is " + total);

        } else if (suserInput.equalsIgnoreCase("divide")) {
            System.out.println("Cool, please enter the number you would like to divide");
            suserInput1 = input.nextLine();
            userInput1 = Integer.parseInt(suserInput1);
            System.out.println("Please enter the number you would like to divide it by");
            suserInput2 = input.nextLine();
            userInput2 = Integer.parseInt(suserInput2);
            
            double dividend = SimpleCalculator.divide(userInput1, userInput2);
            System.out.println(userInput1 +" divided by " + userInput2 + " is "+ dividend);
            
            

        }
        
        System.out.println("Do you want to exit the calculator?");
        suserInput = input.nextLine();
        
    }while(suserInput.equalsIgnoreCase("no"));
        
        System.out.println("Thanks for using the calculator, come back soon!");
        
       

    }
}
