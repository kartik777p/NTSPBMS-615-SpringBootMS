package com.nit.dao;

import java.util.List;

import com.nit.model.CaronaPetient;

public interface PetientDAO {
	public List<CaronaPetient> getPetients(String city1,String city2,String city3) throws Exception;
}
