/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class InterestCalculator {

    public void calculateInterest() {
        int userYears;
        String saInterestRate, suserPrincipal, suserYears;
        float aInterestRate, userPrincipal, totalPrincipal, endYear;
        float percentage = 100;

        Scanner userInput = new Scanner(System.in);

        System.out.println("WELCOME TO Interest Calculator!\n");

        System.out.println("What is the annual interst rate for your investment");
        saInterestRate = userInput.nextLine();
        aInterestRate = Integer.parseInt(saInterestRate);

        System.out.println("How much is your initial principal");
        suserPrincipal = userInput.nextLine();
        userPrincipal = Integer.parseInt(suserPrincipal);

        System.out.println("Enter number of years you will invest");
        suserYears = userInput.nextLine();
        userYears = Integer.parseInt(suserYears);

        endYear = userPrincipal * (1 + (aInterestRate / percentage));
        totalPrincipal = userPrincipal * (aInterestRate / percentage);
        float newPrincipal = userPrincipal;

        for (int i = 1; i <= userYears; i++) {
            System.out.println("Year " + i + " you will start your year with" + userPrincipal + ". \n With a " + aInterestRate + " % annual rate, You make $" + totalPrincipal + " that year, bringing your end of year balance to $" + endYear);
            newPrincipal = userPrincipal += totalPrincipal;
            totalPrincipal = newPrincipal * (aInterestRate / percentage);
            endYear = newPrincipal * (1 + (aInterestRate / percentage));
        }
    }

}
