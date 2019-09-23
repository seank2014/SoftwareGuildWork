/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doitbetter;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class DoItBetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int miles, hotDogs, language;
        miles= 0;
        hotDogs = 0;
        language = 0;
        
        Scanner myScanner = new Scanner (System.in);
        
        String smiles ="";
        String shotDogs = "";
        String slanguage ="";
        
        System.out.println("How many miles can you run?");
        smiles = myScanner.nextLine();
        miles = Integer.parseInt(smiles);
        System.out.println("That's cool, I can run " + (miles * 2 +1) + ". No big deal though.\n");
        
        System.out.println("So, how many hotdogs can you eat?");
        shotDogs = myScanner.nextLine();
        hotDogs = Integer.parseInt(shotDogs);
        System.out.println("That's it? I can scarf down, " + (hotDogs * 2 + 1) + " easily.\n");
        
        System.out.println("How many languages do you speak?");
        slanguage = myScanner.nextLine();
        language = Integer.parseInt(slanguage);
        System.out.println("Not bad. I speak " + (language * 2 + 1) + " myself." );
        
        
        
    }
    
}
