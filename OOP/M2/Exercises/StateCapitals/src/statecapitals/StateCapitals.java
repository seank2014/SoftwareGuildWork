/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author seanking
 */
public class StateCapitals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, String> stateCapitals = new HashMap<>();

        stateCapitals.put("Alabama", "Montgomery");

        stateCapitals.put("Alaska", "Juneau");

        stateCapitals.put("Arizona", "Pheonix");

        stateCapitals.put("Arkansas", "Little Rock");

        stateCapitals.put("California", "Sacramento");

        stateCapitals.put("Colorado", "Denver");

        stateCapitals.put("Conneticut", "Hartford");

        stateCapitals.put("Delaware", "Dover");

        stateCapitals.put("Florida", "Tallahassee");

        stateCapitals.put("Georgia", "Atlanta");

        stateCapitals.put("Hawaii", "Honolulu");

        stateCapitals.put("Idaho", "Boise");

        stateCapitals.put("Illinois", "Springfeild");

        stateCapitals.put("Indiana", "Indianapolis");

        stateCapitals.put("Iowa", "Des Moines");

        stateCapitals.put("Kansas", "Topeka");

        stateCapitals.put("Kentucky", "Frankfort");

        stateCapitals.put("Louisiana", "Baton Rouge");

        stateCapitals.put("Maine", "Augusta");

        stateCapitals.put("Maryland", "Annapolis");

        stateCapitals.put("Massachusetts", "Boston");

        stateCapitals.put("Michigan", "Lansing");

        stateCapitals.put("Minnesota", "St. Paul");

        stateCapitals.put("Mississippi", "Jackson");

        stateCapitals.put("Missouri", "Jefferson City");

        stateCapitals.put("Montana", "Helena");

        stateCapitals.put("Nebraska", "Lincoln");

        stateCapitals.put("Nevada", "Carson City");

        stateCapitals.put("New Hampshire", "Concord");

        stateCapitals.put("New Jersey", "Trenton");

        stateCapitals.put("New Mexico", "Santa Fe");

        stateCapitals.put("New York", "Albany");

        stateCapitals.put("North Carolina", "Raleigh");

        stateCapitals.put("North Dakota", "Bisnarck");

        stateCapitals.put("Ohio", "Columbus");

        stateCapitals.put("Oklahoma", "Oklahoma City");

        stateCapitals.put("Oregon", "Salem");

        stateCapitals.put("Pennsylvania", "Harrisburg");

        stateCapitals.put("Rhode Island", "Providence");

        stateCapitals.put("South Carolina", "Columbia");

        stateCapitals.put("South Dakota", "Pierre");

        stateCapitals.put("Tennessee", "Nashville");

        stateCapitals.put("Texas", "Austin");

        stateCapitals.put("Utah", "Salt Lake City");

        stateCapitals.put("Vermont", "Montpelier");

        stateCapitals.put("Virginia", "Richmond");

        stateCapitals.put("Washington", "Olympia");

        stateCapitals.put("West Virginia", "Charleston");

        stateCapitals.put("Wisconsin", "Madison");

        stateCapitals.put("Wyoming", "Cheyenne");
        System.out.println("STATES: \n===========");
        Set<String> keys = stateCapitals.keySet();        
        
        for (String k : keys) {
            System.out.println(k);

        }

        System.out.println("CAPITALS: \n=========");
        Collection<String> capitals = stateCapitals.values();
        for (String c : capitals) {
            System.out.println(c);
        }

        System.out.println("STATES AND CAPITALS \n==========");
        for (String k : keys) {
            System.out.println(k + " - " + stateCapitals.get(k));
            
            //Need to figure out how to do in alphebetical order
        }

    }

}
