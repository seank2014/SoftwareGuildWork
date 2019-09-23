/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplesort;

import java.util.Arrays;

/**
 *
 * @author seanking
 */
public class SimpleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] firstHalf = {3,7,9,10,16,19,20,34,55,67,88,99};
        int [] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        int c=0;
       
        int[] wholeNumbers = new int [24];
        int temp;
        
        for(int i =0; i<firstHalf.length;i++){
            wholeNumbers[i]=firstHalf[i];
            c++;
            
        }
        
        for(int j =0; j<secondHalf.length; j++){
            wholeNumbers[c++]=secondHalf[j];
        }
        
        for(int i=0;i<wholeNumbers.length-1;i++){
            for(int j=0; j < wholeNumbers.length-1;j++){
             if(wholeNumbers[j] > wholeNumbers[j+1]){
                 temp = wholeNumbers[j];
                 wholeNumbers[j] = wholeNumbers[j+1];
                 wholeNumbers[j + 1] = temp;
                 
             }  

           }     
            
        }
        
        System.out.println("Here ya go - all nice and ordered:\n" + Arrays.toString(wholeNumbers) + " ");
            
            
        }

    
}
