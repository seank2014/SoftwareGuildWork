/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthyheart;

import java.util.Scanner;


/**
 *
 * @author seanking
 */
public class HealthyHeart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
int userAge, heartRate;
       double maxTarget, minTarget;
       userAge = 0;
      
       
       Scanner myScanner = new Scanner(System.in);
       
       String suserAge = "";
       
        System.out.println("How old are you?");
        suserAge = myScanner.nextLine();
        userAge = Integer.parseInt(suserAge);
        heartRate = 220 - userAge;
        maxTarget = heartRate * 1/2;
        minTarget = heartRate * .85;

        System.out.println("\n Your maximum heart rate should be " + heartRate + " beats per minute.\n");
        System.out.println("Your target HR Zone is "+ Math.round(maxTarget )  + " - " + Math.round(minTarget) );
    }
    
}
