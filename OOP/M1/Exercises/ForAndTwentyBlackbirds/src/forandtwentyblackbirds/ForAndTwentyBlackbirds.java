/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forandtwentyblackbirds;

/**
 *
 * @author seanking
 */
public class ForAndTwentyBlackbirds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int birdsInPie = 1;
        for (int i =1; i < 24; i++){
            System.out.println("Blackbird #" + i + "goes into the pie!");
           birdsInPie++;
        }
        //I chand the I and the birdsInPie to start at 1.
        System.out.println("There are " + birdsInPie + "birds in there!");
        System.out.println("Quite the pie full!");
    }
    
    
}
