package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.beans.PersonInfo;

@SpringBootApplication
public class BootProj06ConfigurationPropertiesWithAllTypeApplication {

	public static void main(String[] args) {
		//get Ioc container obj ref
	ApplicationContext ctx=	   SpringApplication.run(BootProj06ConfigurationPropertiesWithAllTypeApplication.class, args);
	 //get spring bean class obj
	  PersonInfo perInfo=ctx.getBean("pInfo",PersonInfo.class);
	  //print its data
	  System.out.println(perInfo);
	  //close IOC Conatiner
	  ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
