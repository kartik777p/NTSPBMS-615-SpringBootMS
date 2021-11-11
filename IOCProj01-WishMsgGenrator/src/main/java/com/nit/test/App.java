package com.nit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.beans.WishMsgGenrator;
import com.nit.config.AppConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = null;
		WishMsgGenrator genrator=null;
		String msg=null;
		// create ioc container having AppConfig class content as inMemory metadata
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
       //get target class obj
		genrator=ctx.getBean("wmg",WishMsgGenrator.class);
		//call method
		msg=genrator.genrateWishMsg("kartik");
		//print msg
		System.out.println(msg);
		//close ioc Container
		ctx.close();
	}//main
}//class
