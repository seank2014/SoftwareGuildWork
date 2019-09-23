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
        //Instantiate simpleCalculator  and IO object
        SimpleCalculator sc = new SimpleCalculator();
        UserInput Io = new UserInput();

        Scanner input = new Scanner(System.in);

        //variables
        int userInput1, userInput2;
        String suserInput;

        Io.print("Calculator");

        //Do while loop to keep code ruuning if user wants to continue
        do {

            suserInput = Io.readString("\n Would you like to add, subtract, multiply or divide two numbers?");

            if (suserInput.equalsIgnoreCase("add")) {

                // Main code to ask user for input and printing out calculation
                userInput1 = Io.readInt("Ok, please enter the first number you would like to add");
                userInput2 = Io.readInt("Now please enter the second");

                int sum = sc.add(userInput1, userInput2);
                System.out.println("The sum is " + sum);

            } else if (suserInput.equalsIgnoreCase("subtract")) {
                userInput1 = Io.readInt("Great, please enter the first number you would like to subtract");
                userInput2 = Io.readInt("Please enter the second number");

                int difference = sc.substract(userInput1, userInput2);
                System.out.println("The difference is " + difference);

            } else if (suserInput.equalsIgnoreCase("multiply")) {
                userInput1 = Io.readInt("Wonderful, please enter the first number you would like to multiply");
                userInput2 = Io.readInt("Now the second number, please");

                int total = sc.multiply(userInput1, userInput2);
                Io.print("The total is " + total);

            } else if (suserInput.equalsIgnoreCase("divide")) {
                userInput1 = Io.readInt("Cool, please enter the number you would like to divide");
                userInput2 = Io.readInt("Please enter the number you would like to divide it by");

                double dividend = sc.divide(userInput1, userInput2);
                Io.print(userInput1 + " divided by " + userInput2 + " is " + dividend);

            }

            System.out.println("Do you want to exit the calculator?");
            suserInput = input.nextLine();

        } while (suserInput.equalsIgnoreCase("no"));

        Io.print("Thanks for using the calculator, come back soon!");

    }
}
