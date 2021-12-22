package com.nit.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ABTest1Runner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ABTest1Runner.run()");
	    System.out.println("Non-Optional :- "+args.getNonOptionArgs());
	    System.out.println("Optional args values :- ");
	    for(String name:args.getOptionNames()) {    //name as String 
	    	System.out.println(name+" --->"+args.getOptionValues(name)); //get values for the given name
	    }//for
	    System.out.println();
	}//run
}//class
