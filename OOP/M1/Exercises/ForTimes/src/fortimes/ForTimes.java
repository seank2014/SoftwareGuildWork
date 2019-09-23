/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortimes;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class ForTimes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String suserNumber;
        suserNumber = "";
        int userNumber;
        System.out.println("Which times tables shall I recite?");
        suserNumber = userInput.nextLine();
        userNumber = Integer.parseInt(suserNumber);
        
        for(int i = 1; i < 16; i++){
            System.out.println( i + " * " + userNumber + " is: "+(i * userNumber));
            
            
        }
    }
    
}
