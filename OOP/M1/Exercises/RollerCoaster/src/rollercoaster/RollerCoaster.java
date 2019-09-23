/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rollercoaster;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class RollerCoaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");
        
        String keepRiding = "y";
        //String getOff = "n";
        int loopsLooped = 0;
        while(keepRiding.equals("y")){
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee....!!!");
            System.out.println("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }
        
       /*while (getOff.equals("n")){
           System.out.println("ok, no problem");
       loopsLooped++;}*/
       
        
        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }// if we set the condition to look for n, it will create and infinite loop
    //int is in front of loopsLoop because we have to declare any variabl before we assign it a value
    
}
