/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userio;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class UserInput implements UserIO {

    Scanner myScanner = new Scanner(System.in);
    //without abstract class says string is abstract? Is it becasue is it not a primitive type?

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        double doubleVal = Double.parseDouble(input);
        return doubleVal;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        min = 1;
        max = 100;
        String input = myScanner.nextLine();
        Double doubleInput = Double.parseDouble(input);

        while (doubleInput < 1 || doubleInput > 100) {
            System.out.println(prompt);
            doubleInput = Double.parseDouble(myScanner.nextLine());
        }
        return doubleInput;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        Float floatVal = Float.parseFloat(input);

        return floatVal;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        min = 1;
        max = 100;
        String input = myScanner.nextLine();
        Float floatVal = Float.parseFloat(input);

        while (floatVal < min || floatVal > max) {
            System.out.println(prompt);
            floatVal = Float.parseFloat(myScanner.nextLine());
        }
        return floatVal;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        int intInput = Integer.parseInt(input);

        return intInput;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        min = 1;
        max = 100;
        String input = myScanner.nextLine();
        int intValue = Integer.parseInt(input);

        while (intValue < 1 || intValue > 100) {

            System.out.println(prompt);
            intValue = Integer.parseInt(myScanner.nextLine());
        }

        return intValue;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        long longInput = Long.parseLong(input);

        return longInput;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        min = 1;
        max = 100;
        long longVal = Long.parseLong(input);

        while (longVal < 1 || longVal > 100) {
            System.out.println(prompt);
            longVal = Long.parseLong(myScanner.nextLine());

        }

        return longVal;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);

        String suserInput = myScanner.nextLine();

        return suserInput;
    }
}
