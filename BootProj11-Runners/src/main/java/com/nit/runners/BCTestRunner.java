package com.nit.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
 
//101 --name=kartik --addrs=hyd    -- use for Optional args   101- non optional

@Component               //if we dont want to use runner simply comment on @component then it will be not execute
@Order(2)
public class BCTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BCTestRunner.run()");
		System.out.println("Data is :- "+Arrays.toString(args));	 //converting Arrys to String 
		System.out.println();
	}
}
