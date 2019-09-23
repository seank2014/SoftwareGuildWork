/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.springmvcspringbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author seanking
 */
@SpringBootApplication
public class App {

    /**
     * @param args the command line arguments
     */
    
    //Spring Boot start Spring MVC with a main method, just like a console application.
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
}
