/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthstones;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class BirthStones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number;
        String inputNumber,month,stone;
        
        inputNumber = "";
        month = "";
        stone = "";
        
        System.out.println("Please enter the number of your birth month: \n Ex. March = 3 \n October = 10");
        
        Scanner myScanner = new Scanner(System.in);
        inputNumber = myScanner.nextLine();
        number = Integer.parseInt(inputNumber);
        
          
   if(number == 1){
     month = "January"; 
     stone = "Garnet";
       System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
}
   else if(number == 2){
       month = "February";
       stone = "Amethyst";
      System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
}
   else if (number == 3){
       month = "March";
       stone = "Aquamarine";
     System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
 }
   else if (number == 4){
       month = "April";
       stone = "diamond";            
      System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
}
   else if (number == 5) {
       month = "May";
       stone = "Emerald";
      System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
}
   else if(number == 6) {
        month = "June";
        stone = "Pearl";
       System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
}
   else if (number == 7) {
        month = "July";
        stone = "Ruby";        
       System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
}
   else if (number == 8){
        month = "August";
        stone = "Peridot";
      System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
 }
   else if(number == 9){
        month = "September";
        stone = "Sapphire";
       System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
}
   else if(number == 10){
        month = "October";
        stone = "Opal";
      System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
 }
   else if(number == 11){
        month = "November";
        stone = "Topaz";
      System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);
 }
   else if (number == 12){
        month = "December";
        stone = "Turquoise";
           System.out.println("Cool! You wrote " + number + ", which means your birth month is " + month + " and your birth stone is: " + stone);

    }else{
        System.out.println("Please enter a valid number");
    } 
//need to figure out how to do this in one line
 }

   
    
}
