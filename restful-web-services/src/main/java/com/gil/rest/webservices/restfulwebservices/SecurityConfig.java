/*package com.gil.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
//we removed this cause we removed the security dependency 
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()   
        .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            //.formLogin().and()
            .httpBasic();
 
    }
}*/
