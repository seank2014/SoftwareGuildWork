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
public class Diff21 {
    // Given an int n, return the absolute value of the difference 
    // between n and 21, except return double the absolute value 
    // of the difference if n is over 21. 
    //
    // diff21(23) -> 4
    // diff21(10) -> 11
    // diff21(21) -> 0
    public int diff21(int n) {
        // When I reread the problem, the second solution made more sense
//        int diff = 21 - Math.abs(n);
//               
//        if(Math.abs(n) > 21){
//            diff = (n-21) * 2;
//        }
//        
//        return diff;
int diff = Math.abs(21-n);

if(n > 21){
    return (diff * 2);
}

return diff;
    }

    
}
