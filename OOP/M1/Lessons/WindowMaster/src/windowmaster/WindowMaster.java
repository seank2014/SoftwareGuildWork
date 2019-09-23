/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowmaster;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class WindowMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
//declare variables for height and width
float height;
float width;
//declare String variables to hold the user's height and
//width input
String stringHeight;
String stringWidth;

//decalre other variables
float areaOfWindow;
float cost;
float perimeterOfWindow;

//declare and initial the Scanner
Scanner myScanner = new Scanner(System.in);

//convert String values of height and width to float values

height = readValue("Please enter the window height:");
width = readValue("Please enter the window width:");

//calculate the area of the window
areaOfWindow = height * width;

//calculate the perimeter of the window
perimeterOfWindow = 2 * (height + width);

//calcualate the total cost - use a hard coded value for
//material cost
cost = ((3.5f * areaOfWindow) + (2.25f * perimeterOfWindow));

        System.out.println("Window height =" + height);
        System.out.println("Window width =" +width);
        System.out.println("Window area ="+ areaOfWindow);
        System.out.println("Window perimeter =" +perimeterOfWindow);
        System.out.println("Total cost = " + cost);
       
      
    }
    public static float readValue(String prompt){
        Scanner myScanner = new Scanner(System.in);
        System.out.println(prompt);
        String input = myScanner.nextLine();
        float floatVal = Float.parseFloat(input);
        return floatVal;
    }
}

