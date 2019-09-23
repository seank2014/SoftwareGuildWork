/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adder.version.pkg1;

/**
 *
 * @author seanking
 */
public class AdderVersion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //declare sum and initialize it to 0
       int sum = 0;
       //declare and initialize our operands
       int operand1 = 3;
       int operand2 = 2;
       
       //assign the sum of operand1 and operand2 to the sum
       
       sum = operand1 + operand2;
       
       //NOTE: the + operator is acting as the 
       //string concatenantion operator instead of the 
       //addition operator. In Java, we use the plus
       //operator to concatenate string values.
       System.out.println("Sum is:" + sum);
    }
    
}
