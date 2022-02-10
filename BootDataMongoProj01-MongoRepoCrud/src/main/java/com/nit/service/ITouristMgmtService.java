package com.nit.service;

import java.util.List;

import com.nit.document.Tourist;

public interface ITouristMgmtService {
   //register tourist
	public String registerTourist(Tourist t);
	//get List of tourist 
	public List<Tourist> fetchAllTourist();
	//fetch tourist by its id
	public Tourist fetchTouristById(String id);
	//findAllByExample
	public List<Tourist> fetchAllByExample(Tourist tourist);
	//findByAllByExampleAnd Sort
	public List<Tourist> fetchAllByExampleAndSort(Tourist tourist,Boolean order, String ... args);
	//findAll with Sort
	public List<Tourist> fetchAllBySort(Boolean order, String...args);
	//UpdateTouristById
	public String ModifyTourist(String id,Long moNumber);
	//deleteTouristById
	public String removeTouristById(String id);
	//registerTouristByGroup
	public String registerTouristByGroup(List<Tourist> list);
	
}
