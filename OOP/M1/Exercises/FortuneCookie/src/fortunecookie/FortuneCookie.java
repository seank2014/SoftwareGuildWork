/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortunecookie;

import java.util.Random;

/**
 *
 * @author seanking
 */
public class FortuneCookie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("Fortune Cookie says: ");
        Random randomizer = new Random();
        
        int x = randomizer.nextInt(10) + 1;
        
        if ( x == 1){
            System.out.println("Those aren't the droids you're looking for.");
        }else if (x ==2){
            System.out.println("Never go in against a Scicilian when death is on the line!");
        }else if (x == 3){
            System.out.println("Goonies never say die");
        }else if (x == 4){
            System.out.println("With great power, there must also come - great responsibility.");
        }else if (x == 5){
            System.out.println("Never argue with the data.");
        }else if (x == 6){
            System.out.println("Try not. Do, or do not. There is no try.");
        }else if (x == 7){
            System.out.println("You are a leaf on the wind; watch how you soar.");
        }else if (x == 8){
            System.out.println("Do absolutely nothing, and it will be everything that you thought it could be");
        }else if (x == 9){
            System.out.println("Kneel before Zod.");
            }else if (x == 10){
                System.out.println("Make is so.");
            }
        
        
        
    }
    
}
