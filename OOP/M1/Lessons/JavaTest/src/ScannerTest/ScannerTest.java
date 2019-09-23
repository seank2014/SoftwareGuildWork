/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScannerTest;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class ScannerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name;
        int age;
        int numComputers;
        String hometown;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name:");
        name = sc.nextLine();
        System.out.println("Please enter your age:");
        age = sc.nextInt();
        System.out.println("Enter the number of computers:");
        numComputers = sc.nextInt();
sc.nextLine();

//if you use nextInt, the string
        //under it will be skipped over once you press enter
        //that is because nextInt is looking for only the integer 
        //and doesnt take in the return key
        //so when you have a nextLine under it, the nextLine will 
        //receive the return key as a complete entry and the user
        //will not be able to fill in information for that
        //so to avoid this, it is best to put everything in as
        //a string and the convert it later
        //or you can put sc.nextLine(); under the sc.nextInt();
        System.out.println("Enter your hometown:");
        hometown = sc.nextLine();
        
        System.out.println("You said:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Num Computers: " + numComputers);
        System.out.println("Hometown: " + hometown);
        
        
        
        
    }
    
}
