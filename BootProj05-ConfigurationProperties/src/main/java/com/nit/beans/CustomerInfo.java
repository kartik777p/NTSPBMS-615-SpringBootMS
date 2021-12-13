package com.nit.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
   
//here setter method injection takes place

@Data    //if we not write setter method here then all the will be initialized with its default value 
@ConfigurationProperties(prefix = "cust.info")   //here we can use at a time only 1 Prephix
@Component("custinfo")
public class CustomerInfo {
    private int id;
    private String name;
    private String addrs;
    private int age;
    //here we can not use env or System variable bcz at a time we can use only 1 prefix so here we are using user defined key ...so we can not use other one 
     private String Path;  //here does not work and it will be hold null bcz not matching 
	
}
