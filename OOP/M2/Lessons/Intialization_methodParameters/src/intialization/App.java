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
        changeMyValue(count);
        System.out.println("Count = " + count);
        
        Person myPerson = new Person();
        myPerson.setAge(24);
        myPerson.setName("Joe");
        System.out.println("Age = " + myPerson.getAge());
        System.out.println("Name = " + myPerson.getName());
        
        changeMyName(myPerson);
        
        System.out.println("Age = " + myPerson.getAge());
        System.out.println("Name = " + myPerson.getName());
    }
    public static void changeMyValue(int value){
        value = 12;
        
        
        
    }
    
    public static void changeMyName(Person person){
        
        person.setName("Steve");
        
      
    }
    
}
