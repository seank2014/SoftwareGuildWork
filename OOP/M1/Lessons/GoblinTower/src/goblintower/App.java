/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goblintower;

/**
 *
 * @author seanking
 */
import java.util.Scanner;
import java.util.Random;


public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Hello World, My name is Sean");
        String myHero = "Goku";
        int lvl = 0;
        int maxHP = r.nextInt(50-1)+1;
        int currentHP = maxHP;
  
        int choice = 0;
        
        do {
        
        System.out.println("Choose a difficulty:");
        System.out.println("1.) Easy");
        System.out.println("2.) Normal");
        System.out.println("3.) Hard");
        String input = myScanner.nextLine();
        choice = Integer.parseInt(input);
        
        } while (choice < 1 || choice > 3);
        


        
       switch(choice){
           case 1:
               System.out.println("You have chosen easy difficulty");
               break;
               
           case 2:
               System.out.println("You have chosen noramal difficulty");
               break;
               
           case 3: 
               System.out.println("You have chosen hard difficulty");
               break;
       
       }
        myHero = PromptUser("What is your name hero?");
        
        System.out.println("Your hero name is: " + myHero);
        System.out.println(currentHP + "/" + maxHP);
        
        
        int numSteps = 0;
        int numFloors = 0;
        int gold = 10;
        while(currentHP > 0){
            // Play the game
            for (int i = 0; i < 10; i++) {
                numSteps++;
                if(r.nextBoolean()){
                    System.out.println("You've encounter a goblin");
                    currentHP -= 2;
                    if(currentHP <= 0){
                        break;
                    }
                    gold+=3;
                }
            }
            if( currentHP > 0 && numSteps % 10 == 0){
       
                System.out.println("You've cleared " + ++numFloors);
             
            }
        }
        System.out.println("You have Died!");
        System.out.println("You've reached floor " + numFloors);
        System.out.println("You've taken " + numSteps + "steps");
        

    }
    
    public static String PromptUser(String message){
    String result = "";
    DisplayMessage(message);
    Scanner sc = new Scanner(System.in);
    result = sc.nextLine();
    return result;
    
    }
    
    public static int PromptUserInt(String message, int min, int max) {
        boolean isValid = false;
         int result = 0;
        //while(isValid == false) {
        while (isValid == false) {
        //boolean isValid = false;
       
        String userInput = PromptUser(message);
        //int result = Integer.parseInt(userInput);
        result = Integer.parseInt(userInput);
      
       if (result < min || result> max){
            System.out.println("Input is out side of the range");
           //return PromptUser(message, min, max);
       }else{
           isValid = true;
       }
        }
       return result;
    }
    //}else{
         //   return result;
        //}
   

public static void DisplayMessage(String message) {
    System.out.println(message);   
    
}
}

    




