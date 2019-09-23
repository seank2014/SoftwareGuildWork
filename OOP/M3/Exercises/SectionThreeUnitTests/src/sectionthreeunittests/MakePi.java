/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sectionthreeunittests;

/**
 *
 * @author seanking
 */
public class MakePi {
     // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        int[] newPi = new int[n];
        int[] pi =  {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3}; 
        
        
        for(int i = 0; i < newPi.length; i++){
           newPi[i] = pi[i];
           
           if(newPi[i] > pi.length-1 ){
               newPi[i] = 0;
           }
        }

return newPi;
                
    }
    
}
