package com.nit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.service.IEmployeeMgmtService;

@Component
public class MYSQLProcedureCallingTestRunner implements CommandLineRunner {
 
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.getMoviesByDesg("CLERK","MANAGER").forEach(System.out::println);
	}//run
}//class
