package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.model.CaronaPetient;
import com.nit.service.PetientService;

@Component("pController")
public class PetientController {
   @Autowired
   private PetientService service;
   public PetientController() {
	System.out.println("PetientController :: 0-param Constuctor");
}
   
   public List<CaronaPetient> getPetints(String city1,String city2,String city3)throws Exception{
	    List<CaronaPetient> list=null;
	   //use service class
	   list=service.processPetient(city1, city2, city3);
	   //return to client app
	   return list;
   }
}
