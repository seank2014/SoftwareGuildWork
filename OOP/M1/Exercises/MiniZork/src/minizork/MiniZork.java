/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minizork;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class MiniZork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.println("Go to the house, or open the mailbox?");
        
        String action = userInput.nextLine();
        
        if(action.equals("open the mailbox")){
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.println("Look inside or stick your hand in?");
            action = userInput.nextLine();
            
            if (action.equals("look inside")){
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.println("Run away or keep looking?");
                action = userInput.nextLine();
                
                if(action.equals("keep looking")){
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                }else if (action.equals("run away")){
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }
            }else if (action.equals("stick your hand in")) {
                System.out.println("you discover a diamond");
                System.out.println("you take it to an appraiser and find that it is very valuable");
                System.out.println("you cash it in and buy the whole game");
            
            }
        } else if(action.equals("go to the house")) {
            System.out.println("the house is dark so you look for a light switch");
            System.out.println("you find a flash light on the floor");
            System.out.println("Do you stay in the house or leave?");
            action = userInput.nextLine();
            
            if(action.equals("stay in the house")){
                System.out.println("you go exploring and start to check to see if there are open doors");
                System.out.println("you finally are able to pry a job open");
                System.out.println("Do you go inside or look for another room.");
                action = userInput.nextLine();
                
                if(action.equals("go inside")){
                    System.out.println("You look around but don't find much");
                    System.out.println("As you turn to leave, you fall through a trap door that leads to outside the house.");
                }
                
            }else if(action.equals("look for another room")){
                System.out.println("You spend hours looking but no luck - all the other rooms are locked");
                System.out.println("You finally decide to leave and get something to eat");
                
            }
        }else if(action.equals("leave")){
            System.out.println("Good decision, that house was weird");
            System.out.println("You treat yourself to a milkshake");}
    }
    
}
