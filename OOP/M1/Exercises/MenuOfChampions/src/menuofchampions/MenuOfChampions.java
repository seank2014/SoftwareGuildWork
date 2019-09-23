/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuofchampions;

/**
 *
 * @author seanking
 */
public class MenuOfChampions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String burger, wrap, chicken;
        double bPrice,wPrice, cPrice;
        
        burger = "Cheese Burger (comes with fries)";
        wrap = "Chicken ceaser wrap(white or whole wheat wrap)";
        chicken = "Southern Fried Chicken (served with mashed potatoes and gravey)";
        
        bPrice = 16.00;
        wPrice = 10.00;
        cPrice = 15.00;
        
        System.out.println("WELCOME TO RESTAURANT NIGHT VALE");
        System.out.println("         Today's Menu is...");
         
        
        System.out.println("\n" + burger  +  " $" +bPrice);
        System.out.println(wrap +  " $" +wPrice);
        System.out.println(chicken + " $" +cPrice);
    }
    
}
