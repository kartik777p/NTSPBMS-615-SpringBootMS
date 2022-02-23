package com.nit.service;

import java.util.List;

import com.nit.entity.Employee;

public interface IEmployeeMgmtService {
	//registerStudent
   public String registerEmployee(Employee emp);
   //findAll
   public List<Employee> fetchAllEmps();
   
}
