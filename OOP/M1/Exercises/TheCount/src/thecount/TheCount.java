/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecount;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class TheCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        int userBeg, userEnd, userInc;
        String suserBeg, suserEnd, suserInc;
        
        System.out.println("Please give a start number:");
        suserBeg = userInput.nextLine();
        userBeg = Integer.parseInt(suserBeg);
        
        System.out.println("Please give a end number:");
        suserEnd = userInput.nextLine();
        userEnd = Integer.parseInt(suserEnd);
        
        System.out.println("Add by:");
        suserInc = userInput.nextLine();
        userInc = Integer.parseInt(suserInc);
        
        for(int i = userBeg; userBeg < userEnd; userBeg+=userInc){
            System.out.println(userBeg);
            
            
        }        
        
    }
    
}
