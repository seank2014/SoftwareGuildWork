/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitbasket;

import java.util.Arrays;

/**
 *
 * @author seanking
 */
public class FruitBasket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] fruit = { "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange",
            "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange",
            "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange",
            "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple",
            "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};

           /* System.out.println("There are " + 31+ " oranges and " + 30+" apples");*/
        
       String [] apples = {fruit[1], fruit[3],fruit[5], fruit[7],fruit[11], fruit[14],fruit[17],fruit[18],fruit[20], fruit[21],
        fruit[24], fruit[25], fruit[26], fruit[27], fruit[30], fruit[31], fruit[36], fruit[37], fruit[38], fruit[39],fruit[42], 
        fruit[45],fruit[48], fruit[49], fruit[52], fruit[54], fruit[56], fruit[58]};
       
       String [] oranges = { fruit[0],fruit[2], fruit[4], fruit[6], fruit[8], fruit[9], fruit[10], fruit[12], fruit[13], fruit[15], 
           fruit[16], fruit[19], fruit[22], fruit[23], fruit[28], fruit[29], fruit[32], fruit[33], fruit[34], fruit[35],
           fruit[40], fruit[41], fruit[43], fruit[44], fruit[46], fruit[47], fruit[50], fruit[51], fruit[53],
           fruit[55], fruit[57], fruit[59], fruit[60]
           
       };
        
        /*System.out.println(Arrays.toString(apples));
        System.out.println(Arrays.toString(oranges));*/
        
        for( int i = 0;i <= fruit.length; i++){
        

            
            if(i == fruit.length){
            System.out.println("Total# of Fruit in Basket:" + fruit.length);
            System.out.println("Number of Apples: " +apples.length);
            System.out.println("Number of Oranges: " +oranges.length);   
           
            }
      
           
            }
        

    } 
        
    }
    


