package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.model.Employee;
import com.nit.service.EmployeeService;

@Component("empController")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	public List<Employee> ProcessEmps(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		// gather values from end user and send that values to service class to do
		// further operation
		list = service.ProcessEmps(desg1, desg2, desg3);
		// send list back to clint app
		return list;
	}// method
}// class
