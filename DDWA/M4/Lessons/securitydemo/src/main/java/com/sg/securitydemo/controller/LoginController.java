/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author seanking
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String displayLoginPage(){
        return "login";
    }
    
}
