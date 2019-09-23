/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author seanking
 */
public class stateCapitals2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HashMap<String, Capital> stateCapitals = new HashMap<>();
        
        Scanner sc = new Scanner(System.in);
        
        
        

        Capital Alabama = new Capital( "Montgomery", 199518, 162);
      

        Capital Alaska = new Capital("Juneau", 32164, 2636);

        Capital Arizona = new Capital("Pheonix", 1626000, 517);

        Capital Arkansas = new Capital("Little Rock", 198606, 118);

        Capital California = new Capital("Sacremento", 501901, 97);

        Capital Colorado = new Capital("Denver", 619968, 153);

        Capital Conneticut = new Capital("Hartford", 123400, 18);

        Capital Delaware = new Capital("Dover", 37538, 23);

        Capital Florida = new Capital("Tallahassee", 191049, 100);

        Capital Georgia = new Capital("Atlanta", 486290, 133);

        Capital Hawaii = new Capital("Honolulu", 351792, 60);

        Capital Idaho = new Capital("Boise", 226570, 82);

        Capital Illinois = new Capital("Springfeild", 167376, 32);

        Capital Indiana = new Capital("Indianapolis", 872680, 366);

        Capital Iowa = new Capital("Des Moines", 217521, 88);

        Capital Kansas = new Capital("Topeka", 126587, 61);

        Capital Kentucky = new Capital("Frankfort", 27621, 15);

        Capital Louisiana = new Capital("Baton Rouge", 225374, 86);

        Capital Maine = new Capital("Augusta", 201800 ,306);

        Capital Maryland = new Capital("Annapolis", 39321, 7);

        Capital Massachusetts = new Capital("Boston", 685094, 48);

        Capital Michigan = new Capital("Lansing", 116986, 39);

        Capital Minnesota = new Capital("St. Paul", 306621, 52);

        Capital Mississippi = new Capital("Jackson", 166965, 111);

        Capital Missouri = new Capital("Jefferson City", 42895, 38);

        Capital Montana = new Capital("Helena", 31429, 17);

        Capital Nebraska = new Capital("Lincoln", 284736, 93);

        Capital Nevada = new Capital("Carson City", 55439, 145);

        Capital NewHampshire = new Capital("Concord", 129783, 31);

        Capital NewJersey = new Capital("Trenton" , 84964, 8);

        Capital NewMexico = new Capital("Santa Fe", 83776, 52);

        Capital NewYork = new Capital("Albany", 98251, 21);

        Capital NorthCarolina = new Capital("Releigh", 464758, 145);

        Capital NorthDakota = new Capital("Bismarck", 75865, 34);

        Capital Ohio = new Capital("Columbus", 879170, 219);

        Capital Oklahoma = new Capital("Oklahoma City", 643648, 606);

        Capital Oregon = new Capital("Salem", 169798, 49);

        Capital Pennsylvania = new Capital("Harrisburg", 49192, 8);

        Capital RhodeIsland = new Capital("Providence", 180393, 18);

        Capital SouthCarolina = new Capital("Columbia", 133114 , 135);

        Capital SouthDakota = new Capital("Pierre", 14004, 13);

        Capital Tennessee = new Capital("Nashville", 691243, 504);

        Capital Texas = new Capital("Austin", 950715, 321);

        Capital Utah = new Capital("Salt Lake City", 200544, 111);

        Capital Vermont = new Capital("Montpelier", 7484, 10);

        Capital Virginia = new Capital("Richmond", 227032, 60);

        Capital Washington = new Capital("Olympia", 51609, 47);

        Capital WestVirginia = new Capital("Charleston", 130113, 109);

        Capital Wisconsin = new Capital("Madison", 255214, 199);

        Capital Wyoming = new Capital("Cheyenne", 63624, 73);
      

        stateCapitals.put("Alabama", Alabama);
        stateCapitals.put("Alaska", Alaska);
        stateCapitals.put("Arizona", Arizona);
        stateCapitals.put("Arkansas", Arkansas);
        stateCapitals.put("California", California);
        stateCapitals.put("Colorado", Colorado);
        stateCapitals.put("Conneticut", Conneticut);
        stateCapitals.put("Delaware", Delaware);
        stateCapitals.put("Florida", Florida);
        stateCapitals.put("Georgia", Georgia);
        stateCapitals.put("Hawaii", Hawaii);
        stateCapitals.put("Idaho", Idaho);
        stateCapitals.put("Illinois", Illinois);
        stateCapitals.put("Indiana", Indiana);
        stateCapitals.put("Iowa", Iowa);
        stateCapitals.put("Kansas", Kansas);
        stateCapitals.put("Kentucky", Kentucky);
        stateCapitals.put("Louisiana", Louisiana);
        stateCapitals.put("Maine", Maine);
        stateCapitals.put("Maryland", Maryland);
        stateCapitals.put("Massachusetts", Massachusetts);
        stateCapitals.put("Michigan", Michigan);
        stateCapitals.put("Minnesota", Minnesota);
        stateCapitals.put("Mississippi", Mississippi);
        stateCapitals.put("Missouri", Missouri);
        stateCapitals.put("Montana", Montana);
        stateCapitals.put("Nebraska", Nebraska);
        stateCapitals.put("Nevada", Nevada);
        stateCapitals.put("New Hampshire", NewHampshire);
        stateCapitals.put("New Jersey", NewJersey);
        stateCapitals.put("New Mexico", NewMexico);
        stateCapitals.put("New York", NewYork);
        stateCapitals.put("North Carolina", NorthCarolina);
        stateCapitals.put("North Dakota", NorthDakota);
        stateCapitals.put("Ohio", Ohio);
        stateCapitals.put("Oklahoma", Oklahoma);
        stateCapitals.put("Oregon", Oregon);
        stateCapitals.put("Pennsylvania", Pennsylvania);
        stateCapitals.put("Rhode Island", RhodeIsland);
        stateCapitals.put("South Carolina", SouthCarolina);
        stateCapitals.put("South Dakota", SouthDakota);
        stateCapitals.put("Tennessee", Tennessee);
        stateCapitals.put("Texas", Texas);
        stateCapitals.put("Utah", Utah);
        stateCapitals.put("Vermont", Vermont);
        stateCapitals.put("Virginia", Virginia);
        stateCapitals.put("Washington", Washington);
        stateCapitals.put("West Virginia", WestVirginia);
        stateCapitals.put("Wisconsin", Wisconsin);
        stateCapitals.put("Wyoming", Wyoming);
        
        System.out.println("Map sice is: " + stateCapitals.size());
        
        Set<String> keys = stateCapitals.keySet(); 
           for(String k : keys){
               Capital current = stateCapitals.get(k); //getting value of key
   
            System.out.println(k + " - " + current.getName() + " | Pop: " + current.getPopulation() + " | Area: " + current.getSquareMileage() + " sq mi");
        }
           
           System.out.println();
           System.out.println("Please enter the lower limit for capital city population: ");
           String suserInput = sc.nextLine();
           int userInput = Integer.parseInt(suserInput);
          
           
           if(userInput > 0){
               
            
           System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + userInput);

            for(String k : keys){
               Capital current = stateCapitals.get(k); //getting value of key
               if(current.getPopulation() > userInput){
   
            System.out.println(k + " - " + current.getName() + " | Pop: " + current.getPopulation() + " | Area: " + current.getSquareMileage() + " sq mi");
        }  
               
            }
           }
        
           
        
    }
}
