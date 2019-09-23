/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listexamples_visiting_each_element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author seanking
 */
public class ListExamples_visiting_each_element {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create an ArrayList of String objacts
        List<String> stringList = new ArrayList<>();
        
        //add a String object to our List
        stringList.add("My First String");
        
        //add another String object to out List
        stringList.add("My Second String");
        
        // add another String object to out list
        stringList.add("My Third String");
        
        // add another String object to out list
        stringList.add("My Fourth String");
        
        //ask the list how big it is
        System.out.println("List size: " + stringList.size());
        
        // visiting elements through for loop to print out all strings
        for(String currentString: stringList){
            System.out.println(currentString);
        }
        
        //visiting elements through iterator
        Iterator<String> iterator = stringList.iterator();
        
        while(iterator.hasNext()){
            String currentString = iterator.next();
            System.out.println(currentString);
            
        }
        
        
        
    }
    
}
