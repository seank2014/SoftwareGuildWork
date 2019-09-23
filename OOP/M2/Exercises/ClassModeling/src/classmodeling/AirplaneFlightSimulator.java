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
public class AirplaneFlightSimulator {
    
    private int height;
    private double milesPerHour;
    private int numberOfPassengers;
    private int numberOfCrew;
    private double windSpeed;
    private int planeCapcity;
    private double planeLength;
    private double planeFuelCapacity;
    private double currentFuel;
    private String planeType;
    private String planeCompany;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(double milesPerHour) {
        this.milesPerHour = milesPerHour;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfCrew() {
        return numberOfCrew;
    }

    public void setNumberOfCrew(int numberOfCrew) {
        this.numberOfCrew = numberOfCrew;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getPlaneCapcity() {
        return planeCapcity;
    }

    public void setPlaneCapcity(int planeCapcity) {
        this.planeCapcity = planeCapcity;
    }

    public double getPlaneLength() {
        return planeLength;
    }

    public void setPlaneLength(double planeLength) {
        this.planeLength = planeLength;
    }

    public double getPlaneFuelCapacity() {
        return planeFuelCapacity;
    }

    public void setPlaneFuelCapacity(double planeFuelCapacity) {
        this.planeFuelCapacity = planeFuelCapacity;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getPlaneCompany() {
        return planeCompany;
    }

    public void setPlaneCompany(String planeCompany) {
        this.planeCompany = planeCompany;
    }
    
    
    
}
