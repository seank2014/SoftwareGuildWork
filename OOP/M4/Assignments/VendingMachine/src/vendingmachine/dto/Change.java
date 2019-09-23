/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author seanking
 */
public class Change {
    private int nickel;
    private int dime;
    private int quarter;
    private int pennies;

    public int getNickel() {
        return nickel;
    }

    public void setNickel(int nickel) {
        this.nickel = nickel;
    }

    public int getDime() {
        return dime;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }
    
}
