package com.nit.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class _ATestRunner implements CommandLineRunner,Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("_ATestRunner.run()");
    System.out.println();
	}

	@Override
	public int getOrder() {
		return 20;     //if both are there like @Order and this method then final result will be this method value
	}

}
