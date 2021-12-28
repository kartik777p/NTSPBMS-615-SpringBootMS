package com.nit.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.service.IMovieMgmtService;

@Component
public class CRUDRepoRunnerTest implements CommandLineRunner {
	
    //we have to use Service class here thats why we inject service class obj here
	@Autowired
	private IMovieMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//create movie obj to save data
		Movie movie=new Movie();
		//set values to movie obj
		movie.setMName("Pushpa");
		movie.setRating(4.8f);
		movie.setYear("2k21");
		//use service class to do further opration(saving obj)
		try {
			System.out.println(service.registerMovie(movie));
		}catch (Exception e) {
			e.printStackTrace();
		}//run
	}//class

}
