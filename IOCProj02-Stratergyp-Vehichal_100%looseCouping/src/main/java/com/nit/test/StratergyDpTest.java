package com.nit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.beans.Vehical;
import com.nit.config.Appconfig;

public class StratergyDpTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=null;
		Vehical vehical=null;
		//create ioc container
		ctx=new AnnotationConfigApplicationContext(Appconfig.class);
		System.out.println("----------------------------------------------------------------");
	   //get target class obj
		vehical=ctx.getBean("vehical",Vehical.class);
		//call b.method of target class
		vehical.Journey("Akola", "Mumbai");
	}//main
}//class
