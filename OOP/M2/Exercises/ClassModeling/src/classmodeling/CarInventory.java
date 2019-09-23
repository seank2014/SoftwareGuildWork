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
public class CarInventory {
   
    private float xCoordinate;
    private float yCoordinate;
    private float zCoordinate;
    private int year;
    private String make;
    private String model;
    private boolean availabilty;
    private int milage;
    private String color;
    private boolean previousOwners;
    private int numberOfPreviousOwners;
    private double milesPerHour;
    private String fuelType;

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public float getzCoordinate() {
        return zCoordinate;
    }

    public void setzCoordinate(float zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(boolean availabilty) {
        this.availabilty = availabilty;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPreviousOwners() {
        return previousOwners;
    }

    public void setPreviousOwners(boolean previousOwners) {
        this.previousOwners = previousOwners;
    }

    public int getNumberOfPreviousOwners() {
        return numberOfPreviousOwners;
    }

    public void setNumberOfPreviousOwners(int numberOfPreviousOwners) {
        this.numberOfPreviousOwners = numberOfPreviousOwners;
    }

    public double getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(double milesPerHour) {
        this.milesPerHour = milesPerHour;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    
    
    
    
}
