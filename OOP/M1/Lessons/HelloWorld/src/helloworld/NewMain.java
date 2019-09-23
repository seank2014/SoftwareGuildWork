/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World, my name is Sean");
        String myHero = "Goku";
        int lvl = 0;
        double currentHP = 20.5;
        float weight = 150.5f;
        boolean isEncounter = false;
        
        Scanner myScanner = new Scanner(System.in);
        myHero = myScanner.nextLine();
        System.out.println("Your hero name is:" + myHero);
        
        String p1 = "bob";
        String p2 = "sally";
        
        String p3 = p1;
        
        // ==
        // >
        // <
        // !=
        // p1 == p2 && p1 == p3 (true)
        // p1 == p2 || p1 == p3 (true)
        
        switch (p1){
            case "bob":
                // do this
                break;
            case "sally":
                // do something else
                break;
            default:
                //do something if nothing else matches
                break;
        }
        if (p1 == p2){
            // when true
            } else {
            // when false
        }
        do {
            lvl++;
       }while(lvl < 10);
        for (int i =0; i < 10; i++){
            System.out.println(myHero +"punches something");
        }
        while(lvl < 10){
            System.out.println(myHero + "punches something");
            lvl++;
        }
    }
}
