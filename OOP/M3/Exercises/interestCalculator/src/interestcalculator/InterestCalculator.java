/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class InterestCalculator {

    public void calculateInterest() {
        int userYears;
        String saInterestRate, suserPrincipal, suserYears;
        BigDecimal aInterestRate, userPrincipal, totalPrincipal, endYear;
        BigDecimal percentage = new BigDecimal("100");
        BigDecimal one = new BigDecimal("1");

        Scanner userInput = new Scanner(System.in);

        System.out.println("WELCOME TO Interest Calculator!\n");

        System.out.println("What is the annual interst rate for your investment");
        saInterestRate = userInput.nextLine();
        aInterestRate = new BigDecimal(saInterestRate);

        System.out.println("How much is your initial principal");
        suserPrincipal = userInput.nextLine();
        userPrincipal = new BigDecimal(suserPrincipal);

        System.out.println("Enter number of years you will invest");
        suserYears = userInput.nextLine();
        userYears = Integer.parseInt(suserYears);

        endYear = userPrincipal.multiply(one.add(aInterestRate.divide(percentage))).setScale(2, RoundingMode.DOWN);
        totalPrincipal = userPrincipal.multiply(aInterestRate.divide(percentage)).setScale(2, RoundingMode.DOWN);
        BigDecimal newPrincipal = userPrincipal.setScale(2, RoundingMode.DOWN);

        for (int i = 1; i <= userYears; i++) {
            System.out.println("Year " + i + " you will start your year with " + newPrincipal + ". \n With a " + aInterestRate + "% annual rate, You make $" + totalPrincipal.toString() + " that year, bringing your end of year balance to $" + endYear.toString());
            newPrincipal = newPrincipal.add(totalPrincipal).setScale(2, RoundingMode.HALF_DOWN);
            //+= totalPrincipal;
            totalPrincipal = newPrincipal.multiply(aInterestRate.divide(percentage)).setScale(2, RoundingMode.HALF_DOWN);
            endYear = newPrincipal.multiply(one.add(aInterestRate.divide(percentage))).setScale(2, RoundingMode.HALF_DOWN);
        }
    }

}
