package com.nit.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Person;
import com.nit.service.IPersonMgmtService;

@Component
public class DateAndTimeAPI_MYSQL_TestRunner implements CommandLineRunner {
    
	@Autowired
	private IPersonMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
	/*	//create person obj having all this details
		Person person=new Person();
		person.setPname("Shubh");
		person.setPage(24f);
		person.setDob(LocalDate.of(1998, 10, 1)); //Month is 0 based 
		person.setTob(LocalTime.of(12,12));
		person.setDoj(LocalDateTime.of(2021,10, 1, 15, 2));
		//use service class 
		System.out.println(service.registerPerson(person));  */
		
		service.fetAllPersonDetails().forEach(System.out::println);
		
		
	}//run
}//class
