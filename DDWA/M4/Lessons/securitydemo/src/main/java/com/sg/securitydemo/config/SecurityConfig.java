/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author seanking
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsService userDetails;

    //in memory security
    //as long as the program runs this is the default security setup
//    @Autowired
//    public void configureGlobalInMemory(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}password") /*"{noop}" tells spring not to hash
//             (don't encode) this password*/
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("{noop}password")
//                .roles("ADMIN", "USER");
//        
//    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/css/**", "/js/**", "/fonts/**").permitAll()
                .anyRequest().hasRole("USER") /*as a user if up above doesnt match anything this 
                is the default page*/
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?login_error=1")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
                
    }
    
    @Autowired
    public void configureGlobalInDB(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetails).passwordEncoder(bCryptPasswordEncoder());
        
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        
        return new BCryptPasswordEncoder();
    }
    
}
