/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.springmvcspringbootexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author seanking
 */
@RestController
@RequestMapping("/api")/*by putting this mapping at a class 
level we are telling Spring MVC that this class can only handle URLs that begin with "/api"*/
public class controller {

    @GetMapping //get in postman
    /*Signals to Spring MVC that this method can only handle HTTP requests using the GET method*/
    public String[] helloWorld() {
        String[] result = {"Hello", "World", "!"};
        return result;
    }

    @PostMapping("/calculate") /*tells Spring MVC to execute our method if HTTP request's method is POST*/
    /*The PostMapping relative URL is appended to the RequestMapping URL at the top of the class*/
    public String calculate(int operand1, String operator, int operand2) {
        int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                String message = String.format("operator '%s' is invalid", operator);
                throw new IllegalArgumentException(message);
        }
        return String.format("%s %s %s =  %s", operand1, operator, operand2, result);
    }
    
    @DeleteMapping("/resource/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable/*tells Spring MVC to find the parameter in the URL. {id}*/ int id){
        //This is where we would use our id to delete.
    }

}
