/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fieldday;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class FieldDay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
String baggins, dresden, howl, potter, vimes,userInput;
baggins = "Baggins";
dresden = "Dresden";
howl = "Howl";
potter = "Potter";
vimes = "Vimes";
userInput = "";



        System.out.println("Please enter your name (please capitalize the first letter)and find out your team: ");
        Scanner inputReader = new Scanner (System.in);
        userInput = inputReader.nextLine();
        
        if(userInput.compareTo(baggins) < 0){
        System.out.println("Congrats, you belong to the Red Dragons!");
        } else if(userInput.compareTo(baggins) > 0 && userInput.compareTo(dresden) < 0){
            System.out.println("You're in the Dark Wizards!");
        }else if(userInput.compareTo(dresden) > 0 && userInput.compareTo(howl) < 0){
            System.out.println("Welcome to Moving Castles!");
        }else if(userInput.compareTo(howl) > 0 && userInput.compareTo(potter) < 0){
            System.out.println("Golden Snitches, here you come!");
        }else if(userInput.compareTo(potter) > 0 && userInput.compareTo(vimes) < 0){
            System.out.println("You're going to the Night Guards!");
        }else if(userInput.compareTo(vimes) > 0){
            System.out.println("To the Black Holes, you go.");
        }
        System.out.println("Good luck in the games!");
        
    }
    
}
