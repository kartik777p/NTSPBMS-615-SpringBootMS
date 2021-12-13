package com.nit.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("poc")
@ConfigurationProperties(prefix = "emp.info")
public class FieldLevalInjectionPOC {
	
	//@Value("${emp.info.name}")
	   private String name;
	
      public FieldLevalInjectionPOC() {
    	  System.out.println("FieldLevalInjectionPOC ::0-param Constuctor  "+name);
	}
      //setter method
	public void setName(String name) {
		//System.out.println(this.name);  
		this.name=name;
		System.out.println("FieldLevalInjectionPOC.setName()::- "+name);
	}
	//toString
//	@Override
//	public String toString() {
//		return "FieldLevalInjectionPOC [name=" + name + "]";
//	}
}
