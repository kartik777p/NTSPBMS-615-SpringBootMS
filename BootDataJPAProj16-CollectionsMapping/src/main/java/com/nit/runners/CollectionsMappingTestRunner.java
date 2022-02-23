package com.nit.runners;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Employee;
import com.nit.service.IEmployeeMgmtService;

@Component
public class CollectionsMappingTestRunner implements CommandLineRunner {
    
	@Autowired
	private IEmployeeMgmtService service;
	@Override
	public void run(String... args) throws Exception {
	/*	try {
			//Create emp Object
			Employee emp=new Employee(null, "Mahesh",
																List.of("shubham","Kisna","Ananta"),
																Set.of(111111111L,2222222222L),
																Map.of("AdharNo","09876543123","PanNo","BIPP1234"));
		   //Regiter 
			System.out.println(service.registerEmployee(emp));
		}catch (Exception e) {
			e.printStackTrace();
		}    */
		
		service.fetchAllEmps().forEach(System.out::println);  //directly not possible... to make it possiblle
																													//we have to write one property cfgs in application.Properties
		
	}

}
