/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listexamples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seanking
 */
public class ListExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<String>stringList = new ArrayList<>();
        
        System.out.println("List size: " + stringList.size());
        
        stringList.add("The fist string.");
        
        System.out.println("List size: " + stringList.size());
        
        stringList.add("The second string. ");
        
        System.out.println("List size: " + stringList.size());
        
        stringList.remove(1);
        
        System.out.println("List size " + stringList.size());
        
        stringList.remove(0);
        System.out.println("List size " + stringList.size());
        
    }
    
}
