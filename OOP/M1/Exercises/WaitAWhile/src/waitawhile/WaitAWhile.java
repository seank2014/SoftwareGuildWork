/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waitawhile;

/**
 *
 * @author seanking
 */
public class WaitAWhile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int timeNow = 5;
        int bedTime = 11;
        
        while(timeNow < bedTime){
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++;// Time passes
        }
        // If you changed bedTime to 11 the loop would run another cycle
        // If you changed timeNow to 11 the code bloc would not run because the condition has not been met
        //If you commented out timeNow++ you would get an inifinite loop as 5 will always be less than 10
        
        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
    
}
