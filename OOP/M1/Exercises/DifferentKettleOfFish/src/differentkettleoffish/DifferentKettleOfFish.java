/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differentkettleoffish;

/**
 *
 * @author seanking
 */
public class DifferentKettleOfFish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int fish = 1; fish <= 10; fish++){
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            }else{
                System.out.println(fish + " fish!");
            }
           //nothing change really. I did add and equal sign because it did not go til 10 from the code I copied
        }
        
    }
    
}
