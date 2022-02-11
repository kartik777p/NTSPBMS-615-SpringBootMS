package com.nit.service;

import java.util.List;

import com.nit.entity.Person;

public interface IPersonMgmtService {
	//save person info
	public String registerPerson(Person person);
	//get All person
	public List<Person> fetAllPersonDetails();
}
