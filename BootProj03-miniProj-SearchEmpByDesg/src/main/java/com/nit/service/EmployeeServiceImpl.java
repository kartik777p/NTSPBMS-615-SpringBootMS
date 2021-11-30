package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.EmployeeDao;
import com.nit.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements  EmployeeService {
   
	@Autowired
	private EmployeeDao dao;
	
	@Override
	public List<Employee> ProcessEmps(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list=new ArrayList<Employee>();
		//use dao class by sending 3 desg
		list=dao.fetchEmpsByDesg(desg1, desg2, desg3);
		//return list
		return list;
	}//method
}//class
