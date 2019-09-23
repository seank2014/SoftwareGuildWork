/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doordonot;

import java.util.Scanner;


/**
 *
 * @author seanking
 */
public class DoOrDoNot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Should I do it? (y/n)");
        boolean doIt;
        
        if(input.next().equals("y")){
            doIt = true; //DO IT!
        } else {
            doIt = false; //DONT YOU DARE!
        }
        
        boolean iDidIt = false;
        
        /*do {
            iDidIt = true;
            break;
        }while(doIt);*/
        
        while(doIt){
            iDidIt = true;
            break;
        }
        //with the while loop, when I tell it to do it, it prints out "I did it"
        // when I tell it not to do it, it prints out"Don't look at me, I didn't do anything!"
        if(doIt && iDidIt) {
            System.out.println("I did it!");
        }else if (!doIt && iDidIt){
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }
    }
}
// If you tell it to do it, it will print out "I did it!"
//If you tell it not to do it, it will print out "I know you said not to ... but I totally did anyways. "

        
    

