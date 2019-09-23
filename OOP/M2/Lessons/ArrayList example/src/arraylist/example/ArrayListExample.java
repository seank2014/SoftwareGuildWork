/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist.example;

import java.util.ArrayList;

/**
 *
 * @author seanking
 */
public class ArrayListExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create an ArrayList of String objects
        ArrayList<String> stringList = new ArrayList<>();

        //ask the list how big it is
        /* System.out.println("List size before adding any Strings: " +
                stringList.size());*/
        // add a String object to our list
        stringList.add("My First String");

        //ask the list how big it is
        /*  System.out.println("List size after adding one String " + stringList.size());*/
        // add another String object to out list
        stringList.add("My Second String");

        // ask the list how big it is
        System.out.println("List size after adding two Strings: " + stringList.size());

        /*Just wanted see how to print out actual list
        
        System.out.println(stringList);*/
        // remove the second String object from out list - remember that
        // our indexes start counting at 0 instead of 1
        stringList.remove(1);

        // ask the list how big it is
        System.out.println("List size after removing one String: " + stringList.size());

        // remove the remaining String object from out list - remember
        // that the list resizes automatically so if there is only one
        // element in a list it is always at index 0
        stringList.remove(0);
        
        // ask the list how big it is
        System.out.println("List size after removing last String: " + stringList.size());
   
        // what happens if you try to remove another element? Give it a 
        // try...
    }

}
