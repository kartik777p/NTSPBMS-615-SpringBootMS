package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.beans.CustomerInfo;
import com.nit.beans.FieldLevalInjectionPOC;

@SpringBootApplication
public class BootProj04ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		//get ioc container
	ApplicationContext ctx=	SpringApplication.run(BootProj04ConfigurationPropertiesApplication.class, args);
	  //get bean class obj
	  CustomerInfo info=ctx.getBean("custinfo",CustomerInfo.class);
	  //call toString
	  System.out.println(info.toString());
	  System.out.println();
	  System.out.println("====================================================================");
	  System.out.println();
	  FieldLevalInjectionPOC poc=ctx.getBean("poc",FieldLevalInjectionPOC.class);
	  //call print
	  //System.out.println(poc.toString());
	  //close ioc container
	  ((ConfigurableApplicationContext) ctx).close();
	}
}
