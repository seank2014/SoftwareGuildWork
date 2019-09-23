/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userio;

/**
 *
 * @author seanking
 */
public class User {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInput myInput = new UserInput();
       myInput.print("Welcome to my program \n");
        myInput.readString("Enter a name ");
        myInput.readInt("Enter a number ");
        myInput.readInt("Enter an integer between 1 and 100", 1, 100);
        myInput.readFloat("Enter another number ");
        myInput.readFloat("Enter a number between 1 and 100 ", 1, 100);
        myInput.readDouble("Enter another number ");
        myInput.readDouble("Enter a number between 1 and 100 ",1,100);
       
        
  
        
    }
    
}
