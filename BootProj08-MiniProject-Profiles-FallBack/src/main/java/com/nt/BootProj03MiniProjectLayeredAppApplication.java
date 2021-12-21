package com.nt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollSystemController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjectLayeredAppApplication {
	
	
	@Bean("c3p0Ds")
	@Profile({"uat"}) //this ds should be activate at uat only 
	public ComboPooledDataSource getC3P0Ds()throws Exception {
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521");
		cds.setUser("SYSTEM");
		cds.setPassword("SYSTEM");
		//return cds
		return cds;
	}

	public static void main(String[] args) {
		//spring boot Way
		//SpringApplication application=new SpringApplication(BootProj03MiniProjectLayeredAppApplication.class);
		//add profile 
		//application.setAdditionalProfiles("uat");
		/* -------------------------------------------------------------------------*/
		//get IOC container
		//ApplicationContext ctx=application.run(args);
		ApplicationContext ctx=SpringApplication.run(BootProj03MiniProjectLayeredAppApplication.class, args);
		//get Controller class object
		 PayrollSystemController controller=ctx.getBean("controller",PayrollSystemController.class);
		 //gather inputs  from enduser
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter desg1");
		 String desg1=sc.next().toUpperCase();
		 System.out.println("enter desg2");
		 String desg2=sc.next().toUpperCase();
		 System.out.println("enter desg3");
		 String desg3=sc.next().toUpperCase();		
		 //invoke method
		 try {
			 List<Employee> listEmps=controller.showEmpsDetailsByDesgs(desg1, desg2, desg3);
				/* for(Employee e:listEmps) {   // Enhanced for loop 
					 System.out.println(e);  
				 }//for
				*/
				/*listEmps.forEach(emp->{      //Java8 forEach syntax1
				   System.out.println(emp);
				});*/
			 
				/* listEmps.forEach(emp->           //Java8 forEach syntax2
					   System.out.println(emp)
					   );*/
			 
			 listEmps.forEach(System.out::println);  // java8   forEach with method reference concept
			   
		 
		 }//try
		 catch(SQLException se) {
			 se.printStackTrace();
			 System.out.println("Internal DB Problem  ");
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("Internal unknown Problem  ");
		 }
		 
		 //close container 
		 ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
