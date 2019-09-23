/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inabucket;

/**
 *
 * @author seanking
 */
public class InABucket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //You can declate all KINDS of variables
        
        String walrus;
        double piesEaten;
        float weightOfTeacupPig;
        int grainsOfSand;
        
        // But declaring them just sets up the space for data
        // to use the variable, you have to put data IN it first!
        walrus = "Sir Leroy Jenkins III";
        piesEaten = 42.1;
        weightOfTeacupPig = 100;
        grainsOfSand = 5;
        
        System.out.println("Meet my pet Walrus, " + walrus);
        System.out.print("He was a bit hungry today, and ate this many pies : ");
        System.out.println(piesEaten);
        System.out.println("He now wights about as much of a small pig, which is : " + weightOfTeacupPig + " pounds");
        System.out.println("He baths in about " + grainsOfSand + " liters of grain sand per day");
        
               
    }
    
}
