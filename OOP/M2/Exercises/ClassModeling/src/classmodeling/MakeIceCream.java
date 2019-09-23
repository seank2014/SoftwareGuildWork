/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmodeling;

/**
 *
 * @author seanking
 */
public class MakeIceCream {
    
    private String flavor;
    private double containerSize;
    private boolean containsNuts;
    private String type;
    private String consistency;
    private int batchSize;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(double containerSize) {
        this.containerSize = containerSize;
    }

    public boolean isContainsNuts() {
        return containsNuts;
    }

    public void setContainsNuts(boolean containsNuts) {
        this.containsNuts = containsNuts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
    
    
}
