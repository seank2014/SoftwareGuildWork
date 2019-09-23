/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourlifeinmovies;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class YourLifeInMovies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int userYear;
        String userName, suserYear;
        userName = "";
        suserYear = "";
        
        System.out.println("Hey, lets play a game! What's your name?");
        
        Scanner myScanner = new Scanner (System.in);
        userName = myScanner.nextLine();
        
        System.out.println("What year were you born," + userName + "?");
        suserYear = myScanner.nextLine();
        userYear = Integer.parseInt(suserYear);
        
        System.out.println("\n Well " + userName + ", did you know...");
        
        if(userYear < 2005){
            System.out.println("Pixar's 'UP' came out half a decade ago.");  
        }
        
        if (userYear < 1995){
            System.out.println("And the first Harry Potter came out over 15 years ago.");
        }
        
        if (userYear < 1985){
            System.out.println("Also, space Jam came out not last decade, but the one before THAT.");
        }
        
        if(userYear < 1975){
            System.out.println("Not to mention, the original Jurassic Park release is closer to the date of the first lunar landing than it is to today."); 
        }
        
        if(userYear < 1965){
            System.out.println("Last, the MASH TV series has been around for almost half a century!");
        }
      
      
        
        
    }
    
}
