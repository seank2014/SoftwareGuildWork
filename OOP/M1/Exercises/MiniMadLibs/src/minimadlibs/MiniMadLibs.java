/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimadlibs;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class MiniMadLibs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
        Scanner inputReader = new Scanner(System.in);
       String one,two,three,four,five,six,seven,eight,nine,ten; 
        one = "";
        two = "";
        three = "";
        four = "";
        five = "";
        six = "";
        seven = "";
        eight = "";
        nine = "";
        ten = "";
        
        System.out.println("I need a noun: ");
        one = inputReader.nextLine();
        
        System.out.println("Now an adjective: ");
        two = inputReader.nextLine();
        
        System.out.println("Another noun: ");
        three = inputReader.nextLine();
        
        System.out.println("And a number: ");
        four = inputReader.nextLine();
        
        System.out.println("Another adjective: ");
        five = inputReader.nextLine();
        
        System.out.println("A plural noun: ");
        six = inputReader.nextLine();
        
        System.out.println("Another one: ");
        seven = inputReader.nextLine();
        
        System.out.println("One more: ");
        eight = inputReader.nextLine();
        
        System.out.println("A verb (present tense): ");
        nine = inputReader.nextLine();
        
        System.out.println("Same verb (past tense): ");
        ten = inputReader.nextLine();
        
        System.out.println("\n*** NOW LETS GET MAD (libs)***\n ");
        System.out.println(one + " the " + two + " frontier. These are the voyages of the starship " + three + ". Its " + four + "-year mission: to explore strange " + five +""+ six + ", to seek out " + five + "" +seven + " and " + five + "" + eight + ", to boldly " + nine + " where no one has " + ten + " before.");
          
        
    }
    
}
