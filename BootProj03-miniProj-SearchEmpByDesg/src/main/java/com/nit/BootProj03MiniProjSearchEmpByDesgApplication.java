package com.nit;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.controller.EmployeeController;
import com.nit.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjSearchEmpByDesgApplication {

	public static void main(String[] args) {
		List<Employee> list=new ArrayList<Employee>();
		//Scanner sc=null;
		ApplicationContext ctx=  SpringApplication.run(BootProj03MiniProjSearchEmpByDesgApplication.class, args);
	 //get target class obj
		EmployeeController con=ctx.getBean("empController",EmployeeController.class);
		//call b method of controller class
		try {
			list=con.ProcessEmps("manager", "clerk", "salesman");
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		//print the record
		list.forEach(emp ->{
			System.out.println("EmpNo:- "+emp.getEmpNo()+" EmpName:- "+emp.getEmpName()+" EmpJob:- "+emp.getJob()+" EmpSal :- "+emp.getSal());
		});
		
	}//main
}//class
