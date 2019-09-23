/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barelycontrolledchaos;

import java.util.Random;

/**
 *
 * @author seanking
 */
public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = randomColorgen();
        String animal = randomAnimalgen();
        String colorAgain = randomColorgen();
        int weight = randomIntgen(5, 200);
        int distance = randomIntgen(10, 20);
        int number = randomIntgen(10000, 20000);
        int time = randomIntgen(2, 6);

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", " + weight
                + "lb " + " miniature " + animal + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " + number
                + " " + colorAgain + " poppies for nearly " + time + " hours until it"
                + " left me alone");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    public static String randomColorgen() {
        
        Random rand = new Random();
        int n = rand.nextInt(5) + 1;
        
        String color = "";  
        
        switch(n){
            case 1:
            color = "Brown";
            break;
           case 2:
            color = "Black";
            break;  
            case 3:
            color = "Yellow";
            break;  
            case 4:
            color = "Green";
            break;  
             case 5:
            color = "Purple";
        }  
        
        return color;
        
        
        
    


    }

    public static String randomAnimalgen() {
        Random rand = new Random();
        int rInt = rand.nextInt(5) + 1;
           
        String animal = "";
      
        
       
        switch(rInt){
            case 1:
            animal = "Bear";
            break;
            case 2:
            animal = "Tiger";
            break;
            case 3:
            animal = "Lion";
            break;
            case 4:
            animal = "Peacock";
            break;
            case 5:
            animal = "Dog";
        }
        
        return animal;
    }

    
    public static int randomIntgen(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
