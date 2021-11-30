package com.nit.service;

import java.util.List;

import com.nit.model.CaronaPetient;

public interface PetientService {
	public List<CaronaPetient> processPetient(String city1, String city2, String city3) throws Exception;
}
