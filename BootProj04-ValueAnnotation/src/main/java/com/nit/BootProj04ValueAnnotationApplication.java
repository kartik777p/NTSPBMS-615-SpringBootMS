package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.benas.Hospital;

@SpringBootApplication
public class BootProj04ValueAnnotationApplication {

	public static void main(String[] args) {
		//get ioc conatiner obj ref
		 ApplicationContext ctx=    SpringApplication.run(BootProj04ValueAnnotationApplication.class, args);
		 //get target class obj
		 Hospital hs=ctx.getBean("hsptl",Hospital.class);
		 //call method to print data
		 System.out.println(hs.toString());
		 //close ioc container 
	}
}
