/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doggenetics;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class DogGenetics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomizer = new Random();
        
        String dName ="";
        int makeup;
        
        System.out.println("What is you dog's name?");
        dName = myScanner.nextLine();
        
       
            
        System.out.println("Well then, I have this highly reliable report on " + dName + "'s prestigious background right here. ");
        
        
        System.out.println("\n" + dName +" is:");
    int n1= randomizer.nextInt(100);
    int n2 = randomizer.nextInt(100-n1);
    int n3 = randomizer.nextInt(100-n1-n2);
    int n4 = randomizer.nextInt(100 - n1 -n2 - n3);
    int n5 = 100 -n1 - n2 - n3 - n4;
    
        System.out.println(n1+ "% Bulldog");
        System.out.println(n2 + "% Rottweiler");
        System.out.println(n3 + "% Greyhound");
        System.out.println(n4 + "% Terrier");
        System.out.println(n5 + "% Mastif");
        
        System.out.println("Wow, thar's quite the dog!");
        
        
        }
        
    
}
