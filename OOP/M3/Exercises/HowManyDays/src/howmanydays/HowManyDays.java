/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howmanydays;


import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class HowManyDays {
    
    public static int calculateDay(WeekDays day){
        
    switch(day){
            case MONDAY: 
             return   5 - 1;
            case TUESDAY:
                return 5 -2;
            case WEDNESDAY:
                return 5-3;
            case THURSDAY:
                return 5-4;
            case FRIDAY:
                return 5-5;
            case SATURDAY:
                return 7 - 1;
            case SUNDAY:
                return 7 -2;
            default: 
                throw new UnsupportedOperationException();
        }
    
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("Enter a day of week to see how may days until Friday");
        String userInput = scan.nextLine();
        WeekDays day = WeekDays.valueOf(userInput.toUpperCase(Locale.ITALY));

        
        int result = calculateDay(day);
        
        System.out.println("There are " + result + " days until Friday");
        
        
        
        
    }
    
}
