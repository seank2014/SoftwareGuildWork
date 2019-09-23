/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traditionalfizzbizz;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class TraditionalFizzBizz {

    /**
     * @param args the command line arguments
     */
   public static void main(String[]  args) {
        
Scanner userInput = new Scanner(System.in); 

int input, counter;
String suserInput,max;
suserInput = "";
counter = 0;

System.out.println("How much units fizzing and buzzing do you need in your life?");
 suserInput = userInput.nextLine();
 input= Integer.parseInt(suserInput);
 

 for(int i = 0; i <= 100; i++){
 
     
     if(i == 0){
         System.out.println(i);
     }else if(i % 3 == 0 && i % 5 == 0){
      System.out.println("fizzBuzz");
     counter++;
     
 }else if(i % 3 == 0){
         System.out.println("fizz");
         counter++;
         
 } else if(i % 5 == 0) {
     System.out.println("buzz");
     counter++;
 }else{
       System.out.println(i);
       }
     
     
    if(counter == input){
         break;
     } 
     
 }
       System.out.println("TRADITION!!!!!");
 

    }
    
 
   }
   




