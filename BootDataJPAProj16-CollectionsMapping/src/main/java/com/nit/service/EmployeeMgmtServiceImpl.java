package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;
import com.nit.repository.IEmployeeInfoRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
   
	@Autowired
	private IEmployeeInfoRepository repo;

	@Override
	public String registerEmployee(Employee emp) {
		return repo.save(emp).getEid()+" Id:-  Based Record is Stored ";
	}

	@Override
	public List<Employee> fetchAllEmps() {
		return repo.findAll();
	}
}
