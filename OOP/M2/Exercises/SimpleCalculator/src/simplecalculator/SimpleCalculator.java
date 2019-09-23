/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

/**
 *
 * @author seanking
 */
public class SimpleCalculator {

//Method with formula for addition
    public static int add(int a, int b){
        int sum = a + b;
        return sum;
        
    }
    
    //Method with formula for subtraction
    public static int substract(int a, int b){
        int difference = a -b;
        return difference;
    }
    
    //Method with formula for multiplication
    public static int multiply(int a, int b){
        int total = a * b;
        return total;
    }
    
    //Method with formula for division
    public static double divide(double a, double b){
        double dividend = a/b;
        return dividend;
    }
    
}
