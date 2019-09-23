/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springforwardfallback;

/**
 *
 * @author seanking
 */
public class SpringForwardFallBack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("It's Spring...!");
        for(int i = 0; i  <= 10; i++){
            System.out.println(i + ", ");
        }
        
        System.out.println("\nOh no, it's fall...");
        for(int i = 10; i > 0; i--){
            System.out.println(i + ", ");
        }
    }
    //the first and second conditions are how it stops and starts
    
}
