/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovesme;

/**
 *
 * @author seanking
 */
public class Lovesme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int petals, i;
       petals = 34;
       i=0;
        System.out.println("Well here goes nothing..."); 
       while(petals > i){
           petals--;//position is important. decrement need to come before if statement to properperly execute
            if(petals % 2 == 0 ){
              System.out.println("It loves me NOT!");
            }else{
           System.out.println("It LOVES me!");
                  }
            // I wrote a while loop but did not have a particular reason for doing so
       
       }
           
    }
    
}
