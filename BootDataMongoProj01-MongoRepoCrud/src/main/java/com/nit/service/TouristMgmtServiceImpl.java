package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.document.Tourist;
import com.nit.repository.ITouristRepository;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepository repo;

	@Override
	public String registerTourist(Tourist t) {
		// save to db
		return repo.save(t).getTNo() + " id :-  based Tourist is Registed ";
	}// registerTourist

	@Override
	public List<Tourist> fetchAllTourist() {
		return repo.findAll();
	}// fetchAllTourist

	@Override
	public Tourist fetchTouristById(String id) {
		return repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("For the Given id there is no Tourist found"));
	}// fetchTouristById

	@Override
	public List<Tourist> fetchAllByExample(Tourist tourist) {
		// create Example obj having tourist details
		Example<Tourist> ex = Example.of(tourist); // prop---->Document/entity
		return repo.findAll(ex);
	}// fetchAllByExample

	@Override
	public List<Tourist> fetchAllByExampleAndSort(Tourist tourist, Boolean order, String... args) {
		// create Example obj having tourist details
		Example<Tourist> ex = Example.of(tourist); // prop---->Document/entity
		// prepare sort Object having details
		Sort sort = Sort.by(order ? Direction.ASC : Direction.DESC, args);
		// use repo by sending Example and Sort obj
		return repo.findAll(ex, sort);
	}// fetchAllByExampleAndSort

	@Override
	public List<Tourist> fetchAllBySort(Boolean order, String... args) {
		// create sort obj having details
		Sort sort = Sort.by(order ? Direction.ASC : Direction.DESC, args);
		// use repo class method to get list of tourist
		return repo.findAll(sort);
	}// fetchAll

	@Override
	public String ModifyTourist(String id, Long moNumber) {
		// find Tourist by id if not there throw exception and if found modify tourist
		Optional<Tourist> opt = repo.findById(id);
		if (opt.isPresent()) {
			// get obj
			Tourist tr = opt.get();
			// change the value of MoNumber
			tr.setMoNumber(moNumber);
			return repo.save(tr).getTNo() + " : id based tourist is updated ";
		}
		return "id :- " + id + " :- based Tourist is updated ";
	}// ModifyTourist

	@Override
	public String removeTouristById(String id) {
		Optional<Tourist> opt = repo.findById(id);
		if (opt.isPresent()) {
			// get obj
			Tourist tr = opt.get();
			// delete it
			repo.delete(tr);
			return id + " :- based tourist id deleted";
		}
		return "There is no tourist found for the given id to delete";
	}//removeTouristById
	
	@Override
	public String registerTouristByGroup(List<Tourist> list) {
		//submit tourist
	List<Tourist> trs=repo.insert(list);
	//Create arrayList to store List of Ids
	List<String> ids=new ArrayList<String>();
	trs.forEach(tr->{
		ids.add(tr.getTNo());
	});
		return ids.toString()+" ids based Tourists is registered......";
	}//registerTouristByGroup
}//class
