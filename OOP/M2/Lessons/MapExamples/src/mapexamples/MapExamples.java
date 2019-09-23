/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapexamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author seanking
 */
public class MapExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<String, Integer> populations = new HashMap<>();
        
        //add map, key and value
        populations.put("USA", 200000000);
        
        populations.put("Canada", 34000000);
        
        populations.put("United Kingdom", 127000000);
        
        populations.put("Japan", 127000000);
        
        //print size
        System.out.println("Map size is: " + populations.size());
        
//        
//      //get value from Map
//      Integer usaPopulation = populations.get("USA");
//        System.out.println(usaPopulation);
//        
//        //replace value
//        populations.put("USA", 313000000);
//        
//        usaPopulation = populations.get("USA");
//        
//        System.out.println(usaPopulation);
//        
//        //get keys out a map, list those keys and list the value
//        
        Set<String> keys = populations.keySet();
//        
       for(String currentKey : keys){
           
       Integer currentPopulation = populations.get(currentKey);
         System.out.println("The population of " + currentKey + " is " + currentPopulation);
            
      
            //get all values out a Map
            //first ask for the collection of values
            
           /* Collection<Integer> populationValues = populations.values();
            
            for(Integer currentPop : populationValues){
                System.out.println(currentPop);*/
                
            }
            
        
        }
    }
    

