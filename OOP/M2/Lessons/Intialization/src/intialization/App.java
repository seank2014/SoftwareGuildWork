/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intialization;

/**
 *
 * @author seanking
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count = 19;
        Person person = new Person();
        person.setAge(35);
        person.setName("Eric");
        
        /*person = null; null pointer is an error that object is not pointing to anything on the heap*/
        
        System.out.println("Count = " + count);
        System.out.println("Age = " + person.getAge());
        System.out.println("Name = " + person.getName());
    }
    
}
