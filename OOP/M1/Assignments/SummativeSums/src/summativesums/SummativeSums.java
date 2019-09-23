/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summativesums;

/**
 *
 * @author seanking
 */
public class SummativeSums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        
        arraySums();
            
   
  
    }
    
   public static int arraySums(){
    
    int num1 [] = {1, 90, -33, -55, 67, -16, 28, -55, 15};
    int num2 [] = {999, -60, -77, 14, 160, 301};
    int num3 [] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140,150,160,170, 180, 190, 200, -99};
       
    int total = 0;
    int total2 = 0;
    int total3 = 0;
    
    for( int element : num1 ) {
        total += element;
    }
     for(int element : num2){
        total2 += element;
    }
     for(int element : num3){
         total3 += element;
     }
        System.out.println("#1 Array Sum: " + total);
        System.out.println("#2 Array Sum: " + total2);
        System.out.println("#3 Array Sum: " + total3);
        
        return total;
        
    
    }
    
}
