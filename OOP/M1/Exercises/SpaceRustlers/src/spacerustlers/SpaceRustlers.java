/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacerustlers;

/**
 *
 * @author seanking
 */
public class SpaceRustlers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int spaceships = 10;
      int aliens = 25;
      int cows = 100;
      
      if (aliens > spaceships){
          System.out.println("Vrroom, vroom! Let's get going!");
          
      }// the if statement executes the code in it's block if the condition in the statement is true
      //if the condition in the if statement is false, the program will check if the condition in the else if 
      //statement is true and excute the block of code it contains.
      
      else{
          System.out.println("There aren't enough green guys to drive these ships!");
      }
      
      if(cows == spaceships){
          System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
          
      } else if(cows > spaceships){
          System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
          
          //the program still executed the block of code in the else if statement
      }else{
          System.out.println("Too mant ships! Not enough cows.");
      }
      
      if(aliens > cows){
          System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centaura!");
          
      }else if (aliens <= cows){
          System.out.println("Oh no! The herds got restless and took over! Looks like_we're_hamburger now!!");
      }
     
      
      
    }
   
    
}
