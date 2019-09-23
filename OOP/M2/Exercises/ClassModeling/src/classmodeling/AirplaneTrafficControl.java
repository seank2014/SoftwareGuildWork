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
public class AirplaneTrafficControl {
    
    private float xCoordinate;
    private float yCoordinate;
    private float zCoordinate;
    private int milesPerHour;
    private boolean landed;
    private double arrivalTime;
    private String planeType;
    private String planeCompany;
    
    public void location (){
        
    }

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

    public int getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(int milesPerHour) {
        this.milesPerHour = milesPerHour;
    }

    public boolean isLanded() {
        return landed;
    }

    public void setLanded(boolean landed) {
        this.landed = landed;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
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
