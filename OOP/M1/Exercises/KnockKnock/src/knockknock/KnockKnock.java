/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knockknock;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class KnockKnock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Know Knock! Guess Who!!");
        String nameGuess = inputReader.nextLine();
        //If I change the capitilazion, the code doesn't run. To fix this I would change the capitalization
        if(nameGuess.equals("Marty McFly")){
            //The code still runs but the Netbeans give a suggestion
            
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); //Sorry, had to!
    }else{
            System.out.println("Dude, do I-look-like " + nameGuess);
        }
    }
    
}
