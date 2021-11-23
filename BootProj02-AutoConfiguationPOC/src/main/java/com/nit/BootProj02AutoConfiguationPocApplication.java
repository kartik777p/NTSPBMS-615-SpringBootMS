package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.dao.EmployeeDAO;

@SpringBootApplication
public class BootProj02AutoConfiguationPocApplication {

	public static void main(String[] args) {
		EmployeeDAO dao=null;
		int status=0;
		//get ioc container ref obj
		ApplicationContext ctx=   SpringApplication.run(BootProj02AutoConfiguationPocApplication.class, args);
		//get DAO(target) class obj
		dao=ctx.getBean("empDAO",EmployeeDAO.class);
		//call b.method of target clss
		try {
			status=dao.getEmpsCounts();
		}catch (Exception e) {
			e.printStackTrace();
		}//catch
		//print status
		System.out.println(status);
	}//main
}//class
