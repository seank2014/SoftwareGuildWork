/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinventory.dto;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author seanking
 */
public class Server {
    private String name;
    private String ip;
    private String manufactuer;
    private int ram;
    private int numProcessors;
    private LocalDate purchaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getManufactuer() {
        return manufactuer;
    }

    public void setManufactuer(String manufactuer) {
        this.manufactuer = manufactuer;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getNumProcessors() {
        return numProcessors;
    }

    public void setNumProcessors(int numProcessors) {
        this.numProcessors = numProcessors;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public long getServerAge(){
        Period p = purchaseDate.until(LocalDate.now());
        return p.getYears();
    }
    
}
