/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitsalad;

import java.util.Arrays;

/**
 *
 * @author seanking
 */
public class FruitSalad {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato",
            "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pint Pearl Apple", "Rasberry", "Blood Orange",
            "Sungold Tomato", "Fuji Apple", "Blueberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango",
            "Satsuma Orange", "Watermelon", "Snozzberry"
        };


        String[] fruitSal = new String[24];

        
        int aCounter = 0;
        int bCounter = 0;
        int oCounter = 0;
        int fruitCounter = 0;
        
        
            for (int i = 0; i < fruit.length; i++) {
                if (fruit[i].contains("berry")) {
                    bCounter++;
                    fruitCounter++;
                   fruitSal[i] =  fruit[i];
                } else if (fruit[i].contains("Apple") && aCounter < 3) {
                    aCounter++;
                    fruitCounter++;
                    fruitSal[i] = fruit[i];
                } else if (fruit[i].contains("Orange") && oCounter < 2 ) {
                    oCounter++;
                    fruitCounter++;
                    fruitSal[i] = fruit[i];
                } else if (fruit[i].contains("kiwi") || fruit[i].contains("banana") || fruit[i].contains("Mango") || fruit[i].contains("Watermelon")) {
                    fruitCounter++;
                   fruitSal[i] =  fruit[i];
                }
                
                if(fruitCounter == 12){
                    break;
                }

            }

        

        System.out.println("Number of fruits: " + fruitCounter);
        
        for( int i = 0; i < fruitSal.length; i++){
            System.out.print(fruitSal[i] + " ");
        }
        
        System.out.println("Number of berries " + bCounter);
        System.out.println("Number of Apples " + aCounter);
        System.out.println("Number of Orange " + oCounter);

        
    }

}
