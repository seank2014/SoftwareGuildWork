/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allthetrivia;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class AllTheTrivia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String states,ounces, sum, hexagon;
        
        states = "";
        ounces = "";
        sum = "";
        hexagon = "";
        
        Scanner inputReader = new Scanner (System.in);
        
        System.out.println("How many states are there?");
        states = inputReader.next();
        
        System.out.println("How many ounces are in one cup?");
        ounces = inputReader.next();
        
        System.out.println("What is the sum of 5 + 5?");
        sum = inputReader.next();
        
        System.out.println("How many sides, does a hexagon have?");
        hexagon = inputReader.next();
        
        System.out.println("Cool,so there are " + ounces + " states.");
        System.out.println("There are " + sum + " ounces in a cup." );
        System.out.println("We also know the sum of 5 + 5 is " + hexagon);
        System.out.println("And a hexagon has " + states + " sides");
        
        
         
        
        
        
        
        
    }
    
}
