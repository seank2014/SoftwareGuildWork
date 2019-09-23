/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


/**
 *
 * @author seanking
 */
public class Order {

  
    LocalDate orderDate;
    String orderNumber;
    String customerName;
    String state;
    BigDecimal taxRate;
    String productType;
    BigDecimal area;
    BigDecimal costPerSquareFoot;
    BigDecimal laborCostPerSquareFoot;
    BigDecimal materialCost;
    BigDecimal laborCost;
    BigDecimal totalTax;


    
    public Order(String orderNumber, LocalDate orderDate){
      
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        
    }
    
    
  
    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

//    public void setOrderNumber(String orderNumber) {
//        this.orderNumber = orderNumber;
//    }
    
    

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }
    BigDecimal total;

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

  

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
  
    public void setOrderDate(LocalDate orderDate){
        this.orderDate = orderDate;
    }
    
    public LocalDate getOrderDate() {
        return orderDate;
    }
    

    public String getOrderNumber() {
        return orderNumber;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

   @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.orderDate);
        hash = 97 * hash + Objects.hashCode(this.orderNumber);
        hash = 97 * hash + Objects.hashCode(this.customerName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.orderNumber, other.orderNumber)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        return true;
    }

 

 
  
    
            
    
    
}
