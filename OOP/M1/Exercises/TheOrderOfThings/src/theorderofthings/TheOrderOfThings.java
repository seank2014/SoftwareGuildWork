/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theorderofthings;

/**
 *
 * @author seanking
 */
public class TheOrderOfThings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCentaurian";
        material = "plantinum";
        purpose = "good";
        
        noun = "dragons";
        
       
        //Using the + with strings, doesn't add it concatenates! (sticks them together)
       // System.out.println(number + opinion + size + age + shape + color + origin + material + purpose + noun);
        System.out.println(purpose);
        System.out.println(color);
        System.out.println(material);
        System.out.println(age);
        System.out.println(origin);
        System.out.println(number);
        System.out.println(size);
        System.out.println(shape);
        System.out.println(opinion);
        System.out.println(noun);
    }
    
    
    
}
