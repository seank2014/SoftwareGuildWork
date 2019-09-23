/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twoforsandtenyearsago;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class TwoForsAndTenYearsAgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What year would you like to count back from?");
        int year = userInput.nextInt();
        
        for(int i = 0; i <= 10; i++){
            System.out.println(i + " years ago would be " +(year - i));
        }
        System.out.println("\nI can count backwards using a different way too...");
        
        for (int i = year; i >= year-100; i-=20) {
            System.out.println((year - i) + " years ago would be " + i);
            
            //The year input and the number 10
            //the first one because it is has less calculations in the stop point
        }
      
    } 
        
    }
    

