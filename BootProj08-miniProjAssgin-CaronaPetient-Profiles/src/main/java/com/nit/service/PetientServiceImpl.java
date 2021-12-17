package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.dao.PetientDAO;
import com.nit.model.CaronaPetient;

@Component("pService")
public class PetientServiceImpl implements PetientService {
   
	@Autowired
	private PetientDAO dao;
	public PetientServiceImpl() {
		System.out.println("PetientServiceImpl:: 0-param Constuctor");
	}
	
	@Override
	public List<CaronaPetient> processPetient(String city1, String city2, String city3) throws Exception {
		List<CaronaPetient> list=null;
		//use dao class by sending details
		list=dao.getPetients(city1, city2, city3);
		//return list to controller
		return list;
	}
}
