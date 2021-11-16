package com.nit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.nit")
@ImportResource("com/nit/config/applicationContext.xml")
public class Appconfig {
    public Appconfig() {
		System.out.println("Appconfig:: 0-param constucstor");
	}
	//no need of @bean method bcz there is no predefined class which we want
}//class
