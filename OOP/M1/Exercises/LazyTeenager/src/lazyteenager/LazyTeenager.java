/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazyteenager;

import java.util.Random;

/**
 *
 * @author seanking
 */
public class LazyTeenager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                   Random rand = new Random();
                   boolean cleanRoom = false; 


   
       int i = 0;
        
       do{
             i++;
            System.out.println("Clean you room!! " + "(x" + i + ")"); 
            cleanRoom = rand.nextInt(20) == 1; 

            if(i >= 15){
                System.out.println("Clean you room!! " + "That's IT, I'm doing it!!! "
                        + "YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
                
            }
            
            if (cleanRoom == true && i >= 5){
                System.out.println("FINE! I'LL CLEAM MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
            }
    
       }while(cleanRoom != true);
       
       
    }
    
}
