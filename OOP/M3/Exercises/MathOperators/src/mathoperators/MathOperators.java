/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathoperators;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class MathOperators {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IntMath mathInt = new IntMath();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome! You are going to enter two number to find out their sum, difference, \n product and dividend");

        System.out.println("Please enter the first number");
        String first = scan.nextLine();
        int firstNum = Integer.parseInt(first);

        System.out.println("Please enter the second number");
        String second = scan.nextLine();
        int secondNum = Integer.parseInt(second);

        int sum = mathInt.calculate(MathOperator.PLUS, firstNum, secondNum);
        int sub = mathInt.calculate(MathOperator.SUBTRACT, firstNum, secondNum);
        int multiply = mathInt.calculate(MathOperator.MULTIPLY, firstNum, secondNum);
        int divide = mathInt.calculate(MathOperator.DIVIDE, firstNum, secondNum);

        System.out.println("Their sum is " + sum);
        System.out.println("Their difference is " + sub);
        System.out.println("Their product is " + multiply);
        System.out.println("Their dividend is " + divide);
    }

}
