package com.nit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
  
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Employee> getMoviesByDesg(String desg1, String desg2) {
		//create StoredProcedureQuery query having PLSQL procedure 
		StoredProcedureQuery query=manager.createStoredProcedureQuery("GET_EMPS_BY_JOB",Employee.class);
		//Register Procedure IN param With JDBC type
		query.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class, ParameterMode.IN);
		//Set values to In param
		query.setParameter(1,desg1);
		query.setParameter(2,desg2);
		//execute PROCEDURE and getList of results
		List<Employee> list=query.getResultList();
		//return list
		return list;
	}//getMoviesByDesg
}//service
