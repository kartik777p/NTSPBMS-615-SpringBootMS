package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Person;
import com.nit.repository.IPersonRepository;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {
    
	@Autowired
	private IPersonRepository repo;
	 
	@Override
	public String registerPerson(Person person) {
		return repo.save(person).getPid()+" id Based person is Registed ";
	}//registerPerson
	
	
	@Override
	public List<Person> fetAllPersonDetails() {
		return repo.findAll();
	}//fetAllPersonDetails
}//service
