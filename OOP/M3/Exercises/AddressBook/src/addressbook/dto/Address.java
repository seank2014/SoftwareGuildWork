/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dto;

/**
 *
 * @author seanking
 */
public class Address {
   private String firstName;
   private String lastName;
   private String streetName;
   private String city;
   private String state;
   private String zipCode;
   
   public Address(String lastName){
       this.lastName = lastName;
   }
   
   
   public String getFirstName(){
       return firstName;
   }
   
   public void setFirstName(String firstName){
       this.firstName = firstName;
   }

    public String getLastName() {
        return lastName;
    }

  
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
   
   
   
    
}
